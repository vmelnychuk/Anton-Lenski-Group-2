###   Java.MP.C4.M3.GC Default Task 1
Write a Command Line that starts a JavaApp using the __Serial Collector__ with the following parameters

* the 6m initial heap size for when the JVM starts // Xms6m
* the 18m maximum heap size // Xmx18m
* the 2m size of the Young Generation
* the 20m starting size of the Permanent Generation // XX:PermSize=20m
* the 30 maximum size of the Permanent Generation //XX:MaxPermSize=30m

`$ java -Xms6m -Xmx18m -Xmn2m -XX:PermSize=20m -XX:MaxPermSize=30m -XX:+UseSerialGC -jar JavaApp.jar`

###   Java.MP.C4.M3.GC Default Task 2
Write a Command Line that starts a JavaApp using the __Parallel Collector__ with the following parameters

* the 3m initial heap size for when the JVM starts
* the 12m maximum heap size
* the 1m size of the Young Generation
* the 20m starting size of the Permanent Generation
* the 20m maximum size of the Permanent Generation

`$ java -Xms3m -Xmx12m -Xmn1m -XX:PermSize=20m -XX:MaxPermSize=20m -XX:+UseParallelGC -jar JavaApp.jar`

###   Java.MP.C4.M3.GC Default Task 3
Write a Command Line that starts a JavaApp using the __Parallel Old Collector__ with the following parameters

* the 9m initial heap size for when the JVM starts
* the 18m maximum heap size
* the 3m size of the Young Generation
* the 40m starting size of the Permanent Generation
* the 40 maximum size of the Permanent Generation

`$ java -Xms9m -Xmx18m -Xmn3m -XX:PermSize=40m -XX:MaxPermSize=40m -XX:+UseParallelOldGC -jar JavaApp.jar`


###   Java.MP.C4.M3.GC Default Task 4
Write a Command Line that starts a JavaApp using the __Concurrent Mark Sweep (CMS) Collector__ with the following parameters

* the 6m initial heap size for when the JVM starts
* the 18m maximum heap size
* the 2m size of the Young Generation
* the 20m starting size of the Permanent Generation
* the 30 maximum size of the Permanent Generation

`$ java -Xms6m -Xmx18m -Xmn2m -XX:PermSize=20m -XX:MaxPermSize=30m -XX:+UseConcMarkSweepGC -jar JavaApp.jar`

###   Java.MP.C4.M3.GC Default Task 5 
Write a Command Line that starts a JavaApp using the __Concurrent Mark Sweep (CMS) Collector with 2 Parallel CMS Threads__ with the following parameters

* the 2m initial heap size for when the JVM starts
* the 18m maximum heap size
* the 1m size of the Young Generation
* the 24m starting size of the Permanent Generation
* the 36 maximum size of the Permanent Generation

`$ java -Xms2m -Xmx18m -Xmn1m -XX:PermSize=24m -XX:MaxPermSize=36m -XX:+UseConcMarkSweepGC -XX:ParallelCMSThreads=2 -jar JavaApp.jar`

###   Java.MP.C4.M3.GC Default Task 6
Write a Command Line that starts a JavaApp using the __Parallel Collector with 2 Parallel CMS Threads__ with the following parameters

* the 4m initial heap size for when the JVM starts
* the 16m maximum heap size
* the 3m size of the Young Generation
* the 24m starting size of the Permanent Generation
* the 32 maximum size of the Permanent Generation

`$ java -Xms4m -Xmx16m -Xmn3m -XX:PermSize=24m -XX:MaxPermSize=32m -XX:+UseParallelGC -XX:ParallelGCThreads=2 -jar JavaApp.jar`

this works, but has no effect

`$ java -Xms4m -Xmx16m -Xmn3m -XX:PermSize=24m -XX:MaxPermSize=32m -XX:+UseParallelGC -XX:ParallelCMSThreads=2 -jar JavaApp.jar`

###   Java.MP.C4.M3.GC Default Task 7
Write a Command Line that starts a JavaApp using the __G1 Garbage Collector__ with the following parameters

* the 4m initial heap size for when the JVM starts
* the 16m maximum heap size
* the 2m size of the Young Generation
* the 12m starting size of the Permanent Generation
* the 18 maximum size of the Permanent Generation

`$ java -Xms4m -Xmx16m -Xmn2m -XX:PermSize=12m -XX:MaxPermSize=18m -XX:+UseG1GC -jar JavaApp.jar`