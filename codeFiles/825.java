2023-02-08 16:56:09 [2023-02-08 15:56:09,556] INFO Session establishment complete on server zookeeper/192.168.144.2:2181, session id = 0x1000085b81e0003, negotiated timeout = 40000 (org.apache.zookeeper.ClientCnxn)2023-02-08 16:56:09 [2023-02-08 15:56:09,696] INFO Session: 0x1000085b81e0003 closed (org.apache.zookeeper.ZooKeeper)2023-02-08 16:56:09 [2023-02-08 15:56:09,696] INFO EventThread shut down for session: 0x1000085b81e0003 (org.apache.zookeeper.ClientCnxn)2023-02-08 16:56:09 [2023-02-08 15:56:09,787] INFO AdminClientConfig values:/*  Omitted for brevity  */(org.apache.kafka.clients.admin.AdminClientConfig)2023-02-08 16:56:10 [2023-02-08 15:56:10,284] INFO Kafka version: 7.3.1-ccs (org.apache.kafka.common.utils.AppInfoParser)2023-02-08 16:56:10 [2023-02-08 15:56:10,284] INFO Kafka commitId: 8628b0341c3c4676 (org.apache.kafka.common.utils.AppInfoParser)2023-02-08 16:56:10 [2023-02-08 15:56:10,284] INFO Kafka startTimeMs: 1675871770281 (org.apache.kafka.common.utils.AppInfoParser)2023-02-08 16:56:10 [2023-02-08 15:56:10,308] INFO [AdminClient clientId=adminclient-1] Node -1 disconnected. (org.apache.kafka.clients.NetworkClient)2023-02-08 16:56:10 [2023-02-08 15:56:10,313] WARN [AdminClient clientId=adminclient-1] Connection to node -1 (localhost/127.0.0.1:54776) could not be established. Broker may not be available. (org.apache.kafka.clients.NetworkClient)/*  These lines repeat a few times until the container times out and exits.  */2023-02-08 16:56:50 [2023-02-08 15:56:50,144] INFO [AdminClient clientId=adminclient-1] Node -1 disconnected. (org.apache.kafka.clients.NetworkClient)2023-02-08 16:56:50 [2023-02-08 15:56:50,144] WARN [AdminClient clientId=adminclient-1] Connection to node -1 (localhost/127.0.0.1:54776) could not be established. Broker may not be available. (org.apache.kafka.clients.NetworkClient)2023-02-08 16:56:50 [2023-02-08 15:56:50,298] ERROR Error while getting broker list. (io.confluent.admin.utils.ClusterStatus)2023-02-08 16:56:50 java.util.concurrent.ExecutionException: org.apache.kafka.common.errors.TimeoutException: Timed out waiting for a node assignment. Call: listNodes2023-02-08 16:56:50     at java.base/java.util.concurrent.CompletableFuture.reportGet(CompletableFuture.java:395)2023-02-08 16:56:50     at java.base/java.util.concurrent.CompletableFuture.get(CompletableFuture.java:1999)2023-02-08 16:56:50     at org.apache.kafka.common.internals.KafkaFutureImpl.get(KafkaFutureImpl.java:165)2023-02-08 16:56:50     at io.confluent.admin.utils.ClusterStatus.isKafkaReady(ClusterStatus.java:147)2023-02-08 16:56:50     at io.confluent.admin.utils.cli.KafkaReadyCommand.main(KafkaReadyCommand.java:149)2023-02-08 16:56:50 Caused by: org.apache.kafka.common.errors.TimeoutException: Timed out waiting for a node assignment. Call: listNodes2023-02-08 16:56:51 [2023-02-08 15:56:51,103] INFO [AdminClient clientId=adminclient-1] Node -1 disconnected. (org.apache.kafka.clients.NetworkClient)2023-02-08 16:56:51 [2023-02-08 15:56:51,103] WARN [AdminClient clientId=adminclient-1] Connection to node -1 (localhost/127.0.0.1:54776) could not be established. Broker may not be available. (org.apache.kafka.clients.NetworkClient)2023-02-08 16:56:51 [2023-02-08 15:56:51,300] INFO Expected 1 brokers but found only 0. Trying to query Kafka for metadata again ... (io.confluent.admin.utils.ClusterStatus)2023-02-08 16:56:51 [2023-02-08 15:56:51,300] ERROR Expected 1 brokers but found only 0. Brokers found []. (io.confluent.admin.utils.ClusterStatus)2023-02-08 16:56:51 Using log4j config /etc/schema-registry/log4j.properties