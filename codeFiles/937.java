2023-03-09 15:55:02.596 ERROR 13171 --- [  restartedMain] o.s.boot.SpringApplication               : Application run failedorg.springframework.beans.factory.BeanCreationException: Error creating bean with name 'org.springframework.boot.actuate.autoconfigure.metrics.cache.CacheMetricsRegistrarConfiguration': Bean instantiation via constructor failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.boot.actuate.autoconfigure.metrics.cache.CacheMetricsRegistrarConfiguration]: Constructor threw exception; nested exception is org.springframework.beans.factory.support.ScopeNotActiveException: Error creating bean with name 'scopedTarget.requestCacheManager': Scope 'request' is not active for the current thread; consider defining a scoped proxy for this bean if you intend to refer to it from a singleton; nested exception is java.lang.IllegalStateException: No thread-bound request found: Are you referring to request attributes outside of an actual web request, or processing a request outside of the originally receiving thread? If you are actually operating within a web request and still receive this message, your code is probably running outside of DispatcherServlet: In this case, use RequestContextListener or RequestContextFilter to expose the current request.    at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:315)    at org.springframework.beans.factory.support.ConstructorResolver.autowireConstructor(ConstructorResolver.java:296)    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.autowireConstructor(AbstractAutowireCapableBeanFactory.java:1372)    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1222)    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:582)    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)    at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)    at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)    at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)    at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)    at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:953)    at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:918)    at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)    at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:145)    at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:740)    at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:415)    at org.springframework.boot.SpringApplication.run(SpringApplication.java:303)    at org.springframework.boot.SpringApplication.run(SpringApplication.java:1312)    at org.springframework.boot.SpringApplication.run(SpringApplication.java:1301)    at tld.company.package.MyApplication.main(MyApplication.java:12)    at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:104)    at java.base/java.lang.reflect.Method.invoke(Method.java:577)    at org.springframework.boot.devtools.restart.RestartLauncher.run(RestartLauncher.java:49)Caused by: org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.boot.actuate.autoconfigure.metrics.cache.CacheMetricsRegistrarConfiguration]: Constructor threw exception; nested exception is org.springframework.beans.factory.support.ScopeNotActiveException: Error creating bean with name 'scopedTarget.requestCacheManager': Scope 'request' is not active for the current thread; consider defining a scoped proxy for this bean if you intend to refer to it from a singleton; nested exception is java.lang.IllegalStateException: No thread-bound request found: Are you referring to request attributes outside of an actual web request, or processing a request outside of the originally receiving thread? If you are actually operating within a web request and still receive this message, your code is probably running outside of DispatcherServlet: In this case, use RequestContextListener or RequestContextFilter to expose the current request.    at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:224)    at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:117)    at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:311)    ... 22 common frames omittedCaused by: org.springframework.beans.factory.support.ScopeNotActiveException: Error creating bean with name 'scopedTarget.requestCacheManager': Scope 'request' is not active for the current thread; consider defining a scoped proxy for this bean if you intend to refer to it from a singleton; nested exception is java.lang.IllegalStateException: No thread-bound request found: Are you referring to request attributes outside of an actual web request, or processing a request outside of the originally receiving thread? If you are actually operating within a web request and still receive this message, your code is probably running outside of DispatcherServlet: In this case, use RequestContextListener or RequestContextFilter to expose the current request.    at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:383)    at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)    at org.springframework.aop.target.SimpleBeanTargetSource.getTarget(SimpleBeanTargetSource.java:35)    at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:195)    at jdk.proxy3/jdk.proxy3.$Proxy123.getCacheNames(Unknown Source)    at org.springframework.boot.actuate.autoconfigure.metrics.cache.CacheMetricsRegistrarConfiguration.bindCacheManagerToRegistry(CacheMetricsRegistrarConfiguration.java:70)    at java.base/java.util.LinkedHashMap.forEach(LinkedHashMap.java:721)    at org.springframework.boot.actuate.autoconfigure.metrics.cache.CacheMetricsRegistrarConfiguration.bindCachesToRegistry(CacheMetricsRegistrarConfiguration.java:66)    at org.springframework.boot.actuate.autoconfigure.metrics.cache.CacheMetricsRegistrarConfiguration.<init>(CacheMetricsRegistrarConfiguration.java:57)    at java.base/jdk.internal.reflect.DirectConstructorHandleAccessor.newInstance(DirectConstructorHandleAccessor.java:67)    at java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:499)    at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:483)    at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:211)    ... 24 common frames omittedCaused by: java.lang.IllegalStateException: No thread-bound request found: Are you referring to request attributes outside of an actual web request, or processing a request outside of the originally receiving thread? If you are actually operating within a web request and still receive this message, your code is probably running outside of DispatcherServlet: In this case, use RequestContextListener or RequestContextFilter to expose the current request.    at org.springframework.web.context.request.RequestContextHolder.currentRequestAttributes(RequestContextHolder.java:131)    at org.springframework.web.context.request.AbstractRequestAttributesScope.get(AbstractRequestAttributesScope.java:42)    at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:371)    ... 36 common frames omitted