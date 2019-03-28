# Deposit Retention

Start Kafka Brokers:
zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties

kafka-server-start /usr/local/etc/kafka/server.properties


Kstreams-drools project:
demo-kafka-streams/deposit-retention/

mvn clean install
java -jar target/deposit-retention-1.0.0.jar

