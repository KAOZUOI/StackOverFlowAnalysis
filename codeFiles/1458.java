SEVERE: java.lang.NullPointerException    at org.hibernate.hql.internal.NameGenerator.generateColumnNames(NameGenerator.java:27)    at org.hibernate.hql.internal.ast.util.SessionFactoryHelper.generateColumnNames(SessionFactoryHelper.java:418)    at org.hibernate.hql.internal.ast.tree.SelectClause.initializeColumnNames(SelectClause.java:269)    at org.hibernate.hql.internal.ast.tree.SelectClause.finishInitialization(SelectClause.java:259)    at org.hibernate.hql.internal.ast.tree.SelectClause.initializeExplicitSelectClause(SelectClause.java:254)    at org.hibernate.hql.internal.ast.HqlSqlWalker.useSelectClause(HqlSqlWalker.java:1011)    at org.hibernate.hql.internal.ast.HqlSqlWalker.processQuery(HqlSqlWalker.java:779)    at org.hibernate.hql.internal.antlr.HqlSqlBaseWalker.query(HqlSqlBaseWalker.java:675)    at org.hibernate.hql.internal.antlr.HqlSqlBaseWalker.selectStatement(HqlSqlBaseWalker.java:311)    at org.hibernate.hql.internal.antlr.HqlSqlBaseWalker.statement(HqlSqlBaseWalker.java:259)    at org.hibernate.hql.internal.ast.QueryTranslatorImpl.analyze(QueryTranslatorImpl.java:261)    at org.hibernate.hql.internal.ast.QueryTranslatorImpl.doCompile(QueryTranslatorImpl.java:189)    at org.hibernate.hql.internal.ast.QueryTranslatorImpl.compile(QueryTranslatorImpl.java:141)    at org.hibernate.engine.query.spi.HQLQueryPlan.<init>(HQLQueryPlan.java:115)    at org.hibernate.engine.query.spi.HQLQueryPlan.<init>(HQLQueryPlan.java:77)    at org.hibernate.engine.query.spi.QueryPlanCache.getHQLQueryPlan(QueryPlanCache.java:153)    at org.hibernate.internal.AbstractSharedSessionContract.getQueryPlan(AbstractSharedSessionContract.java:545)    at org.hibernate.internal.AbstractSharedSessionContract.createQuery(AbstractSharedSessionContract.java:654)    at org.hibernate.internal.SessionImpl.createQuery(SessionImpl.java:3307)    at org.hibernate.query.criteria.internal.CriteriaQueryImpl$1.buildCompiledQuery(CriteriaQueryImpl.java:318)    at org.hibernate.query.criteria.internal.compile.CriteriaCompiler.compile(CriteriaCompiler.java:127)    at org.hibernate.internal.SessionImpl.createQuery(SessionImpl.java:3600)    at org.hibernate.internal.SessionImpl.createQuery(SessionImpl.java:203)    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)    at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)    at java.base/java.lang.reflect.Method.invoke(Method.java:567)    at org.springframework.orm.jpa.SharedEntityManagerCreator$SharedEntityManagerInvocationHandler.invoke(SharedEntityManagerCreator.java:301)    at com.sun.proxy.$Proxy111.createQuery(Unknown Source)    at com.openpayment.impl.dao.RegistryGroupDaoImpl.getRegistryGroupRows(RegistryGroupDaoImpl.java:247)    at com.openpayment.impl.service.RegistryGroupServiceImpl.getRegistryGroupRows(RegistryGroupServiceImpl.java:67)    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)    at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)    at java.base/java.lang.reflect.Method.invoke(Method.java:567)    at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:333)    at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:190)    at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:157)    at org.springframework.security.access.intercept.aopalliance.MethodSecurityInterceptor.invoke(MethodSecurityInterceptor.java:69)    at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:179)    at org.springframework.transaction.interceptor.TransactionInterceptor$1.proceedWithInvocation(TransactionInterceptor.java:99)    at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:283)    at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:96)    at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:179)    at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:213)    at com.sun.proxy.$Proxy174.getRegistryGroupRows(Unknown Source)    at com.openpayment.web.view.registry.RegistryGroupView.lambda$buildTable$7f718060$1(RegistryGroupView.java:167)    at com.vaadin.data.provider.CallbackDataProvider.fetchFromBackEnd(CallbackDataProvider.java:137)    at com.vaadin.data.provider.AbstractBackEndDataProvider.fetch(AbstractBackEndDataProvider.java:61)    at com.vaadin.data.provider.DataCommunicator.fetchItemsWithRange(DataCommunicator.java:404)    at com.vaadin.data.provider.DataCommunicator.sendDataToClient(DataCommunicator.java:377)    at com.vaadin.data.provider.DataCommunicator.beforeClientResponse(DataCommunicator.java:339)    at com.vaadin.server.communication.UidlWriter.write(UidlWriter.java:126)    at com.vaadin.server.communication.UidlRequestHandler.writeUidl(UidlRequestHandler.java:124)    at com.vaadin.server.communication.UidlRequestHandler.synchronizedHandleRequest(UidlRequestHandler.java:92)    at com.vaadin.server.SynchronizedRequestHandler.handleRequest(SynchronizedRequestHandler.java:40)    at com.vaadin.server.VaadinService.handleRequest(VaadinService.java:1606)    at com.vaadin.server.VaadinServlet.service(VaadinServlet.java:448)    at javax.servlet.http.HttpServlet.service(HttpServlet.java:728)    at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:305)    at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:210)    at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:51)    at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:243)    at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:210)    at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:222)    at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:123)    at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:502)    at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:171)    at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:100)    at org.apache.catalina.valves.AccessLogValve.invoke(AccessLogValve.java:953)    at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:118)    at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:408)    at org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1041)    at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:603)    at org.apache.tomcat.util.net.JIoEndpoint$SocketProcessor.run(JIoEndpoint.java:312)    at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)    at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)    at java.base/java.lang.Thread.run(Thread.java:835)