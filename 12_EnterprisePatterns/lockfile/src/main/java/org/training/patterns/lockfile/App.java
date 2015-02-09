package org.training.patterns.lockfile;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.training.patterns.lockfile.access.ExclusiveFileAccess;

public class App 
{
    private static final Logger log = Logger.getLogger(App.class);
    public static void main( String[] args ) throws IOException, InterruptedException {
        ExclusiveFileAccess file = ExclusiveFileAccess.open("D:/tmp.txt", "r");
        log.info(file.readLine());
        file.close();
    }
}
