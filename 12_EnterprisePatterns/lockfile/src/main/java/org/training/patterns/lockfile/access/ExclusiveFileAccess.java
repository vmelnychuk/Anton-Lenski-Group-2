package org.training.patterns.lockfile.access;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.apache.log4j.Logger;
import org.training.patterns.lockfile.access.exception.FileSharingException;

public class ExclusiveFileAccess extends RandomAccessFile implements Closeable {
    private static final String LOCK_FILE_SUFFIX = ".lock";
    private static final long RETRY_TIMEOUT = 2000L;
    private static final int RETRY_LIMIT = 3;
    private static final Logger log = Logger.getLogger(ExclusiveFileAccess.class);
    private File lockFile;

    public static ExclusiveFileAccess openExclusive(String fileName, String mode) throws IOException {
        File lockFile = new File(fileName + LOCK_FILE_SUFFIX);
        if(!lockFile.createNewFile()) {
            log.info("lock file exists");
                throw new FileSharingException(fileName + " file is bussy");
        }
        log.info("create lock file");
        return new ExclusiveFileAccess(fileName, mode, lockFile);
    }

    private ExclusiveFileAccess(String fileName, String mode, File lockFile) throws FileNotFoundException {
        super(fileName, mode);
        this.lockFile = lockFile;
    }

    public synchronized void close() throws IOException {
        if (lockFile != null) {
            lockFile.delete();
            lockFile = null;
            log.info("delete lockfile");
            super.close();
        }
    }

    public static ExclusiveFileAccess open(String fileName, String mode) throws IOException, InterruptedException {
        int retryNumber = 0;
        while(true) {
            try {
                return openExclusive(fileName, mode);
            } catch(FileSharingException e) {
                if (++retryNumber == RETRY_LIMIT) {
                    log.error("file already in use");
                    e.printStackTrace();
                    throw e;
                }
                log.error("file already in use");
                log.error("waiting...");
                Thread.sleep(RETRY_TIMEOUT);
            }
        }
    }
    @Override
    protected void finalize() throws Throwable {
        close();
    }
}
