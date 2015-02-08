package org.training.patterns.lockfile.access;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.training.patterns.lockfile.access.exception.FileSharingException;

public class ExclusiveFileAccess extends RandomAccessFile implements Closeable {
    private static final String LOCK_FILE_SUFFIX = ".lock";
    private File lockFile;
    
    public static ExclusiveFileAccess openExclusive(String fileName, String mode) throws IOException {
        File lockFile = new File(fileName + LOCK_FILE_SUFFIX);
        if (!lockFile.createNewFile()) {
            throw new FileSharingException(fileName + " exists");
        }
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
            super.close();
        }
    }
}
