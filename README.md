Pre-reqs:

Java 8
Spring Boot
Axon 4
Axon Server

1) Run axon server as docker container:

sudo docker run -d --name axonserver -p 8024:8024 -p 8124:8124 axoniq/axonserver

or if you prefer download axonserver.jar and run $ java -jar axonserver.jar

2) Command side:

cd giftcard-axon4-command
mvn clean install
mvn spring-boot:run

3) Query side:

cd giftcard-axon4-query
mvn clean install
mvn spring-boot:run

4) Sending commands and queries:

Issue GiftCard : http://localhost:8081/card/1/issue/100/command
Redeem GiftCard : http://localhost:8081/card/1/redeem/50/command
List all the cards: http://localhost:8082/cards






