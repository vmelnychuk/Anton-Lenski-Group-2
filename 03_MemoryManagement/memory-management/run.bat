call mvn clean package
START "" java -Xss4m -Xmx1024m -XX:SurvivorRatio=2 -XX:NewSize=10m -XX:MaxNewSize=10m -jar target/memory-eater.jar
jvisualvm