Error starting ApplicationContext. To display the condition evaluation report re-run your application with 'debug' enabled.[2m2023-01-01T09:06:30.943+09:00[0;39m [33m WARN[0;39m [35m10464[0;39m [2m---[0;39m [2m[actor-tcp-nio-3][0;39m [36mdev.miku.r2dbc.mysql.MySqlConnection    [0;39m [2m:[0;39m The server timezone is <???ѹα? ǥ?ؽ> that's unknown, trying to use system default timezone[2m2023-01-01T09:06:30.945+09:00[0;39m [33m WARN[0;39m [35m10464[0;39m [2m---[0;39m [2m[actor-tcp-nio-3][0;39m [36mdev.miku.r2dbc.mysql.MySqlConnection    [0;39m [2m:[0;39m The server timezone is <???ѹα? ǥ?ؽ> that's unknown, trying to use system default timezone[2m2023-01-01T09:06:30.947+09:00[0;39m [33m WARN[0;39m [35m10464[0;39m [2m---[0;39m [2m[actor-tcp-nio-3][0;39m [36mdev.miku.r2dbc.mysql.MySqlConnection    [0;39m [2m:[0;39m The server timezone is <???ѹα? ǥ?ؽ> that's unknown, trying to use system default timezone[2m2023-01-01T09:06:30.948+09:00[0;39m [33m WARN[0;39m [35m10464[0;39m [2m---[0;39m [2m[actor-tcp-nio-3][0;39m [36mdev.miku.r2dbc.mysql.MySqlConnection    [0;39m [2m:[0;39m The server timezone is <???ѹα? ǥ?ؽ> that's unknown, trying to use system default timezone[2m2023-01-01T09:06:30.951+09:00[0;39m [33m WARN[0;39m [35m10464[0;39m [2m---[0;39m [2m[actor-tcp-nio-3][0;39m [36mdev.miku.r2dbc.mysql.MySqlConnection    [0;39m [2m:[0;39m The server timezone is <???ѹα? ǥ?ؽ> that's unknown, trying to use system default timezone[2m2023-01-01T09:06:30.953+09:00[0;39m [33m WARN[0;39m [35m10464[0;39m [2m---[0;39m [2m[actor-tcp-nio-3][0;39m [36mdev.miku.r2dbc.mysql.MySqlConnection    [0;39m [2m:[0;39m The server timezone is <???ѹα? ǥ?ؽ> that's unknown, trying to use system default timezone[2m2023-01-01T09:06:30.955+09:00[0;39m [33m WARN[0;39m [35m10464[0;39m [2m---[0;39m [2m[actor-tcp-nio-3][0;39m [36mdev.miku.r2dbc.mysql.MySqlConnection    [0;39m [2m:[0;39m The server timezone is <???ѹα? ǥ?ؽ> that's unknown, trying to use system default timezone[2m2023-01-01T09:06:30.974+09:00[0;39m [31mERROR[0;39m [35m10464[0;39m [2m---[0;39m [2m[  restartedMain][0;39m [36mo.s.boot.SpringApplication              [0;39m [2m:[0;39m Application run failedorg.springframework.beans.factory.BeanCreationException: Error creating bean with name 'initializer' defined in class path resource [com/aaa/blog/wf/config/BlogWebFluxConfig.class]: Failed to execute SQL script statement #1 of class path resource [sql/spring-boot-mysql-schema.sql]: DROP TABLE IF EXISTS tag    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1751) ~[spring-beans-6.0.3.jar:6.0.3]    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:599) ~[spring-beans-6.0.3.jar:6.0.3]    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:521) ~[spring-beans-6.0.3.jar:6.0.3]    at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:326) ~[spring-beans-6.0.3.jar:6.0.3]    at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-6.0.3.jar:6.0.3]    at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:324) ~[spring-beans-6.0.3.jar:6.0.3]    at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:200) ~[spring-beans-6.0.3.jar:6.0.3]    at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:961) ~[spring-beans-6.0.3.jar:6.0.3]    at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:915) ~[spring-context-6.0.3.jar:6.0.3]    at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:584) ~[spring-context-6.0.3.jar:6.0.3]    at org.springframework.boot.web.reactive.context.ReactiveWebServerApplicationContext.refresh(ReactiveWebServerApplicationContext.java:66) ~[spring-boot-3.0.1.jar:3.0.1]    at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:730) ~[spring-boot-3.0.1.jar:3.0.1]    at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:432) ~[spring-boot-3.0.1.jar:3.0.1]    at org.springframework.boot.SpringApplication.run(SpringApplication.java:308) ~[spring-boot-3.0.1.jar:3.0.1]    at org.springframework.boot.SpringApplication.run(SpringApplication.java:1302) ~[spring-boot-3.0.1.jar:3.0.1]    at org.springframework.boot.SpringApplication.run(SpringApplication.java:1291) ~[spring-boot-3.0.1.jar:3.0.1]    at com.aaa.blog.wf.SpringBlogWebFluxMySqlApplication.main(SpringBlogWebFluxMySqlApplication.java:10) ~[classes/:na]    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) ~[na:na]    at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]    at java.base/java.lang.reflect.Method.invoke(Method.java:568) ~[na:na]    at org.springframework.boot.devtools.restart.RestartLauncher.run(RestartLauncher.java:49) ~[spring-boot-devtools-3.0.1.jar:3.0.1]Caused by: org.springframework.r2dbc.connection.init.ScriptStatementFailedException: Failed to execute SQL script statement #1 of class path resource [sql/spring-boot-mysql-schema.sql]: DROP TABLE IF EXISTS tag    at org.springframework.r2dbc.connection.init.ScriptUtils.lambda$runStatement$9(ScriptUtils.java:571) ~[spring-r2dbc-6.0.3.jar:6.0.3]    at reactor.core.publisher.FluxOnErrorResume$ResumeSubscriber.onError(FluxOnErrorResume.java:94) ~[reactor-core-3.5.1.jar:3.5.1]    at reactor.core.publisher.MonoStreamCollector$StreamCollectorSubscriber.onError(MonoStreamCollector.java:149) ~[reactor-core-3.5.1.jar:3.5.1]    at reactor.core.publisher.MonoStreamCollector$StreamCollectorSubscriber.onNext(MonoStreamCollector.java:126) ~[reactor-core-3.5.1.jar:3.5.1]    at reactor.core.publisher.FluxFlatMap$FlatMapMain.tryEmit(FluxFlatMap.java:543) ~[reactor-core-3.5.1.jar:3.5.1]    at reactor.core.publisher.FluxFlatMap$FlatMapInner.onNext(FluxFlatMap.java:984) ~[reactor-core-3.5.1.jar:3.5.1]    at reactor.core.publisher.FluxMap$MapSubscriber.onNext(FluxMap.java:122) ~[reactor-core-3.5.1.jar:3.5.1]    at reactor.core.publisher.FluxPeek$PeekSubscriber.onNext(FluxPeek.java:200) ~[reactor-core-3.5.1.jar:3.5.1]    at reactor.core.publisher.Operators$MonoSubscriber.complete(Operators.java:1839) ~[reactor-core-3.5.1.jar:3.5.1]    at reactor.core.publisher.NextProcessor.tryEmitValue(NextProcessor.java:358) ~[reactor-core-3.5.1.jar:3.5.1]    at reactor.core.publisher.NextProcessor.onNext(NextProcessor.java:298) ~[reactor-core-3.5.1.jar:3.5.1]    at dev.miku.r2dbc.mysql.MySqlResult.lambda$null$3(MySqlResult.java:114) ~[r2dbc-mysql-0.8.2.RELEASE.jar:0.8.2.RELEASE]    at reactor.core.publisher.LambdaSubscriber.onNext(LambdaSubscriber.java:160) ~[reactor-core-3.5.1.jar:3.5.1]    at reactor.core.publisher.FluxWindowPredicate$WindowFlux.drainRegular(FluxWindowPredicate.java:670) ~[reactor-core-3.5.1.jar:3.5.1]    at reactor.core.publisher.FluxWindowPredicate$WindowFlux.drain(FluxWindowPredicate.java:748) ~[reactor-core-3.5.1.jar:3.5.1]    at reactor.core.publisher.FluxWindowPredicate$WindowFlux.onNext(FluxWindowPredicate.java:790) ~[reactor-core-3.5.1.jar:3.5.1]    at reactor.core.publisher.FluxWindowPredicate$WindowPredicateMain.onNext(FluxWindowPredicate.java:241) ~[reactor-core-3.5.1.jar:3.5.1]    at reactor.core.publisher.FluxHandleFuseable$HandleFuseableSubscriber.onNext(FluxHandleFuseable.java:193) ~[reactor-core-3.5.1.jar:3.5.1]    at reactor.core.publisher.FluxContextWrite$ContextWriteSubscriber.onNext(FluxContextWrite.java:107) ~[reactor-core-3.5.1.jar:3.5.1]    at dev.miku.r2dbc.mysql.util.DiscardOnCancelSubscriber.onNext(DiscardOnCancelSubscriber.java:70) ~[r2dbc-mysql-0.8.2.RELEASE.jar:0.8.2.RELEASE]    at reactor.core.publisher.FluxPeekFuseable$PeekConditionalSubscriber.onNext(FluxPeekFuseable.java:854) ~[reactor-core-3.5.1.jar:3.5.1]    at reactor.core.publisher.MonoFlatMapMany$FlatMapManyInner.onNext(MonoFlatMapMany.java:250) ~[reactor-core-3.5.1.jar:3.5.1]    at reactor.core.publisher.FluxPeek$PeekSubscriber.onNext(FluxPeek.java:200) ~[reactor-core-3.5.1.jar:3.5.1]    at reactor.core.publisher.FluxHandle$HandleSubscriber.onNext(FluxHandle.java:128) ~[reactor-core-3.5.1.jar:3.5.1]    at reactor.core.publisher.FluxPeekFuseable$PeekConditionalSubscriber.onNext(FluxPeekFuseable.java:854) ~[reactor-core-3.5.1.jar:3.5.1]    at reactor.core.publisher.EmitterProcessor.drain(EmitterProcessor.java:537) ~[reactor-core-3.5.1.jar:3.5.1]    at reactor.core.publisher.EmitterProcessor.tryEmitNext(EmitterProcessor.java:343) ~[reactor-core-3.5.1.jar:3.5.1]    at reactor.core.publisher.InternalManySink.emitNext(InternalManySink.java:27) ~[reactor-core-3.5.1.jar:3.5.1]    at reactor.core.publisher.EmitterProcessor.onNext(EmitterProcessor.java:309) ~[reactor-core-3.5.1.jar:3.5.1]    at dev.miku.r2dbc.mysql.client.ReactorNettyClient$ResponseSink.next(ReactorNettyClient.java:340) ~[r2dbc-mysql-0.8.2.RELEASE.jar:0.8.2.RELEASE]    at dev.miku.r2dbc.mysql.client.ReactorNettyClient.lambda$new$0(ReactorNettyClient.java:103) ~[r2dbc-mysql-0.8.2.RELEASE.jar:0.8.2.RELEASE]    at reactor.core.publisher.FluxPeek$PeekSubscriber.onNext(FluxPeek.java:185) ~[reactor-core-3.5.1.jar:3.5.1]    at reactor.netty.channel.FluxReceive.drainReceiver(FluxReceive.java:292) ~[reactor-netty-core-1.1.1.jar:1.1.1]    at reactor.netty.channel.FluxReceive.onInboundNext(FluxReceive.java:401) ~[reactor-netty-core-1.1.1.jar:1.1.1]    at reactor.netty.channel.ChannelOperations.onInboundNext(ChannelOperations.java:411) ~[reactor-netty-core-1.1.1.jar:1.1.1]    at reactor.netty.channel.ChannelOperationsHandler.channelRead(ChannelOperationsHandler.java:113) ~[reactor-netty-core-1.1.1.jar:1.1.1]    at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:444) ~[netty-transport-4.1.86.Final.jar:4.1.86.Final]    at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:420) ~[netty-transport-4.1.86.Final.jar:4.1.86.Final]    at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:412) ~[netty-transport-4.1.86.Final.jar:4.1.86.Final]    at dev.miku.r2dbc.mysql.client.MessageDuplexCodec.handleDecoded(MessageDuplexCodec.java:187) ~[r2dbc-mysql-0.8.2.RELEASE.jar:0.8.2.RELEASE]    at dev.miku.r2dbc.mysql.client.MessageDuplexCodec.channelRead(MessageDuplexCodec.java:95) ~[r2dbc-mysql-0.8.2.RELEASE.jar:0.8.2.RELEASE]    at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:442) ~[netty-transport-4.1.86.Final.jar:4.1.86.Final]    at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:420) ~[netty-transport-4.1.86.Final.jar:4.1.86.Final]    at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:412) ~[netty-transport-4.1.86.Final.jar:4.1.86.Final]    at io.netty.handler.codec.ByteToMessageDecoder.fireChannelRead(ByteToMessageDecoder.java:346) ~[netty-codec-4.1.86.Final.jar:4.1.86.Final]    at io.netty.handler.codec.ByteToMessageDecoder.channelRead(ByteToMessageDecoder.java:318) ~[netty-codec-4.1.86.Final.jar:4.1.86.Final]    at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:444) ~[netty-transport-4.1.86.Final.jar:4.1.86.Final]    at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:420) ~[netty-transport-4.1.86.Final.jar:4.1.86.Final]    at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:412) ~[netty-transport-4.1.86.Final.jar:4.1.86.Final]    at io.netty.handler.ssl.SslHandler.unwrap(SslHandler.java:1373) ~[netty-handler-4.1.86.Final.jar:4.1.86.Final]    at io.netty.handler.ssl.SslHandler.decodeJdkCompatible(SslHandler.java:1236) ~[netty-handler-4.1.86.Final.jar:4.1.86.Final]    at io.netty.handler.ssl.SslHandler.decode(SslHandler.java:1285) ~[netty-handler-4.1.86.Final.jar:4.1.86.Final]    at io.netty.handler.codec.ByteToMessageDecoder.decodeRemovalReentryProtection(ByteToMessageDecoder.java:529) ~[netty-codec-4.1.86.Final.jar:4.1.86.Final]    at io.netty.handler.codec.ByteToMessageDecoder.callDecode(ByteToMessageDecoder.java:468) ~[netty-codec-4.1.86.Final.jar:4.1.86.Final]    at io.netty.handler.codec.ByteToMessageDecoder.channelRead(ByteToMessageDecoder.java:290) ~[netty-codec-4.1.86.Final.jar:4.1.86.Final]    at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:444) ~[netty-transport-4.1.86.Final.jar:4.1.86.Final]    at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:420) ~[netty-transport-4.1.86.Final.jar:4.1.86.Final]    at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:412) ~[netty-transport-4.1.86.Final.jar:4.1.86.Final]    at io.netty.channel.DefaultChannelPipeline$HeadContext.channelRead(DefaultChannelPipeline.java:1410) ~[netty-transport-4.1.86.Final.jar:4.1.86.Final]    at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:440) ~[netty-transport-4.1.86.Final.jar:4.1.86.Final]    at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:420) ~[netty-transport-4.1.86.Final.jar:4.1.86.Final]    at io.netty.channel.DefaultChannelPipeline.fireChannelRead(DefaultChannelPipeline.java:919) ~[netty-transport-4.1.86.Final.jar:4.1.86.Final]    at io.netty.channel.nio.AbstractNioByteChannel$NioByteUnsafe.read(AbstractNioByteChannel.java:166) ~[netty-transport-4.1.86.Final.jar:4.1.86.Final]    at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:788) ~[netty-transport-4.1.86.Final.jar:4.1.86.Final]    at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:724) ~[netty-transport-4.1.86.Final.jar:4.1.86.Final]    at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:650) ~[netty-transport-4.1.86.Final.jar:4.1.86.Final]    at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:562) ~[netty-transport-4.1.86.Final.jar:4.1.86.Final]    at io.netty.util.concurrent.SingleThreadEventExecutor$4.run(SingleThreadEventExecutor.java:997) ~[netty-common-4.1.86.Final.jar:4.1.86.Final]    at io.netty.util.internal.ThreadExecutorMap$2.run(ThreadExecutorMap.java:74) ~[netty-common-4.1.86.Final.jar:4.1.86.Final]    at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30) ~[netty-common-4.1.86.Final.jar:4.1.86.Final]    at java.base/java.lang.Thread.run(Thread.java:833) ~[na:na]    Suppressed: java.lang.Exception: #block terminated with an error        at reactor.core.publisher.BlockingSingleSubscriber.blockingGet(BlockingSingleSubscriber.java:99) ~[reactor-core-3.5.1.jar:3.5.1]        at reactor.core.publisher.Mono.block(Mono.java:1710) ~[reactor-core-3.5.1.jar:3.5.1]        at org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer.execute(ConnectionFactoryInitializer.java:112) ~[spring-r2dbc-6.0.3.jar:6.0.3]        at org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer.afterPropertiesSet(ConnectionFactoryInitializer.java:97) ~[spring-r2dbc-6.0.3.jar:6.0.3]        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1797) ~[spring-beans-6.0.3.jar:6.0.3]        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1747) ~[spring-beans-6.0.3.jar:6.0.3]        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:599) ~[spring-beans-6.0.3.jar:6.0.3]        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:521) ~[spring-beans-6.0.3.jar:6.0.3]        at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:326) ~[spring-beans-6.0.3.jar:6.0.3]        at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-6.0.3.jar:6.0.3]        at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:324) ~[spring-beans-6.0.3.jar:6.0.3]        at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:200) ~[spring-beans-6.0.3.jar:6.0.3]        at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:961) ~[spring-beans-6.0.3.jar:6.0.3]        at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:915) ~[spring-context-6.0.3.jar:6.0.3]        at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:584) ~[spring-context-6.0.3.jar:6.0.3]        at org.springframework.boot.web.reactive.context.ReactiveWebServerApplicationContext.refresh(ReactiveWebServerApplicationContext.java:66) ~[spring-boot-3.0.1.jar:3.0.1]        at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:730) ~[spring-boot-3.0.1.jar:3.0.1]        at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:432) ~[spring-boot-3.0.1.jar:3.0.1]        at org.springframework.boot.SpringApplication.run(SpringApplication.java:308) ~[spring-boot-3.0.1.jar:3.0.1]        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1302) ~[spring-boot-3.0.1.jar:3.0.1]        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1291) ~[spring-boot-3.0.1.jar:3.0.1]        at com.aaa.blog.wf.SpringBlogWebFluxMySqlApplication.main(SpringBlogWebFluxMySqlApplication.java:10) ~[classes/:na]        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) ~[na:na]        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]        at java.base/java.lang.reflect.Method.invoke(Method.java:568) ~[na:na]        at org.springframework.boot.devtools.restart.RestartLauncher.run(RestartLauncher.java:49) ~[spring-boot-devtools-3.0.1.jar:3.0.1]Caused by: java.lang.ClassCastException: class java.lang.Integer cannot be cast to class java.lang.Long (java.lang.Integer and java.lang.Long are in module java.base of loader 'bootstrap')    at java.base/java.util.stream.Collectors.lambda$summingLong$23(Collectors.java:699) ~[na:na]    at reactor.core.publisher.MonoStreamCollector$StreamCollectorSubscriber.onNext(MonoStreamCollector.java:117) ~[reactor-core-3.5.1.jar:3.5.1]    ... 67 common frames omitted