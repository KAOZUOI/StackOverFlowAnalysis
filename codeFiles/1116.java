java.lang.NullPointerExceptionat org.jboss.security.auth.message.config.JBossServerAuthConfig.getAuthContext(JBossServerAuthConfig.java:108)at org.apache.catalina.authenticator.AuthenticatorBase.getJaspicState(AuthenticatorBase.java:773)at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:619)at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:135)at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92)at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:78)at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:360)at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:399)at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65)at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:891)at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1784)at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)at org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1191)at org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659)at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)at java.base/java.lang.Thread.run(Thread.java:834)