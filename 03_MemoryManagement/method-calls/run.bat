call mvn clean package
START "" java -Xss1m -Xms265m -Xmx265m -XX:SurvivorRatio=1 -XX:NewSize=9m -XX:MaxNewSize=9m -jar target/method-calls.jar
jvisualvm