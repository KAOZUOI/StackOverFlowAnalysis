2023-04-22 16:20:54.758 ERROR 12124 --- [  restartedMain] o.s.boot.SpringApplication               : Application run failedorg.springframework.context.ApplicationContextException: Failed to start bean 'org.springframework.kafka.config.internalKafkaListenerEndpointRegistry'; nested exception is org.apache.kafka.common.KafkaException: Failed to construct kafka consumer    at org.springframework.context.support.DefaultLifecycleProcessor.doStart(DefaultLifecycleProcessor.java:181) ~[spring-context-5.3.26.jar:5.3.26]    at org.springframework.context.support.DefaultLifecycleProcessor.access$200(DefaultLifecycleProcessor.java:54) ~[spring-context-5.3.26.jar:5.3.26]    at org.springframework.context.support.DefaultLifecycleProcessor$LifecycleGroup.start(DefaultLifecycleProcessor.java:356) ~[spring-context-5.3.26.jar:5.3.26]    at java.base/java.lang.Iterable.forEach(Iterable.java:75) ~[na:na]    at org.springframework.context.support.DefaultLifecycleProcessor.startBeans(DefaultLifecycleProcessor.java:155) ~[spring-context-5.3.26.jar:5.3.26]    at org.springframework.context.support.DefaultLifecycleProcessor.onRefresh(DefaultLifecycleProcessor.java:123) ~[spring-context-5.3.26.jar:5.3.26]    at org.springframework.context.support.AbstractApplicationContext.finishRefresh(AbstractApplicationContext.java:937) ~[spring-context-5.3.26.jar:5.3.26]    at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:586) ~[spring-context-5.3.26.jar:5.3.26]    at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:147) ~[spring-boot-2.7.10.jar:2.7.10]    at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:731) ~[spring-boot-2.7.10.jar:2.7.10]    at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:408) ~[spring-boot-2.7.10.jar:2.7.10]    at org.springframework.boot.SpringApplication.run(SpringApplication.java:307) ~[spring-boot-2.7.10.jar:2.7.10]    at org.springframework.boot.SpringApplication.run(SpringApplication.java:1303) ~[spring-boot-2.7.10.jar:2.7.10]    at org.springframework.boot.SpringApplication.run(SpringApplication.java:1292) ~[spring-boot-2.7.10.jar:2.7.10]    at com.microservices.registration.RegistrationApplication.main(RegistrationApplication.java:16) ~[classes/:na]    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) ~[na:na]    at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]    at java.base/java.lang.reflect.Method.invoke(Method.java:568) ~[na:na]    at org.springframework.boot.devtools.restart.RestartLauncher.run(RestartLauncher.java:49) ~[spring-boot-devtools-2.7.10.jar:2.7.10]Caused by: org.apache.kafka.common.KafkaException: Failed to construct kafka consumer    at org.apache.kafka.clients.consumer.KafkaConsumer.<init>(KafkaConsumer.java:823) ~[kafka-clients-3.1.2.jar:na]    at org.apache.kafka.clients.consumer.KafkaConsumer.<init>(KafkaConsumer.java:664) ~[kafka-clients-3.1.2.jar:na]    at org.springframework.kafka.core.DefaultKafkaConsumerFactory.createRawConsumer(DefaultKafkaConsumerFactory.java:483) ~[spring-kafka-3.0.4.jar:3.0.4]    at org.springframework.kafka.core.DefaultKafkaConsumerFactory.createKafkaConsumer(DefaultKafkaConsumerFactory.java:451) ~[spring-kafka-3.0.4.jar:3.0.4]    at org.springframework.kafka.core.DefaultKafkaConsumerFactory.createConsumerWithAdjustedProperties(DefaultKafkaConsumerFactory.java:427) ~[spring-kafka-3.0.4.jar:3.0.4]    at org.springframework.kafka.core.DefaultKafkaConsumerFactory.createKafkaConsumer(DefaultKafkaConsumerFactory.java:394) ~[spring-kafka-3.0.4.jar:3.0.4]    at org.springframework.kafka.core.DefaultKafkaConsumerFactory.createConsumer(DefaultKafkaConsumerFactory.java:371) ~[spring-kafka-3.0.4.jar:3.0.4]    at org.springframework.kafka.listener.KafkaMessageListenerContainer$ListenerConsumer.<init>(KafkaMessageListenerContainer.java:852) ~[spring-kafka-3.0.4.jar:3.0.4]    at org.springframework.kafka.listener.KafkaMessageListenerContainer.doStart(KafkaMessageListenerContainer.java:381) ~[spring-kafka-3.0.4.jar:3.0.4]    at org.springframework.kafka.listener.AbstractMessageListenerContainer.start(AbstractMessageListenerContainer.java:531) ~[spring-kafka-3.0.4.jar:3.0.4]    at org.springframework.kafka.listener.ConcurrentMessageListenerContainer.doStart(ConcurrentMessageListenerContainer.java:226) ~[spring-kafka-3.0.4.jar:3.0.4]    at org.springframework.kafka.listener.AbstractMessageListenerContainer.start(AbstractMessageListenerContainer.java:531) ~[spring-kafka-3.0.4.jar:3.0.4]    at org.springframework.kafka.config.KafkaListenerEndpointRegistry.startIfNecessary(KafkaListenerEndpointRegistry.java:383) ~[spring-kafka-3.0.4.jar:3.0.4]    at org.springframework.kafka.config.KafkaListenerEndpointRegistry.start(KafkaListenerEndpointRegistry.java:328) ~[spring-kafka-3.0.4.jar:3.0.4]    at org.springframework.context.support.DefaultLifecycleProcessor.doStart(DefaultLifecycleProcessor.java:178) ~[spring-context-5.3.26.jar:5.3.26]    ... 19 common frames omittedCaused by: org.apache.kafka.common.config.ConfigException: No resolvable bootstrap urls given in bootstrap.servers    at org.apache.kafka.clients.ClientUtils.parseAndValidateAddresses(ClientUtils.java:89) ~[kafka-clients-3.1.2.jar:na]    at org.apache.kafka.clients.ClientUtils.parseAndValidateAddresses(ClientUtils.java:48) ~[kafka-clients-3.1.2.jar:na]    at org.apache.kafka.clients.consumer.KafkaConsumer.<init>(KafkaConsumer.java:730) ~[kafka-clients-3.1.2.jar:na]    ... 33 common frames omittedProcess finished with exit code 0