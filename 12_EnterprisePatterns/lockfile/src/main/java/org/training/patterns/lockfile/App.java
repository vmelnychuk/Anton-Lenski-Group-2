package org.training.patterns.lockfile;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.training.patterns.lockfile.access.ExclusiveFileAccess;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final Logger log = Logger.getLogger(App.class);
    public static void main( String[] args ) throws IOException, InterruptedException
    {
        ExclusiveFileAccess file = ExclusiveFileAccess.openExclusive("D:/tmp.txt", "r");
        ExclusiveFileAccess file1 = ExclusiveFileAccess.openExclusive("D:/tmp.txt", "r");
        ExclusiveFileAccess file2 = ExclusiveFileAccess.openExclusive("D:/tmp.txt", "r");
        file.readChar();
        Thread.sleep(2000);
        file.close();
    }
}
