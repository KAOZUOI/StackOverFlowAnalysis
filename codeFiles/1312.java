2023-04-03 14:57:46.534  INFO 22976 --- [nio-8080-exec-1] c.n.a.e.c.ForwardConfiguration           : No requested mapping found. Forwarding to index2023-04-03 14:57:46.545  WARN 22976 --- [nio-8080-exec-1] o.s.web.servlet.PageNotFound             : No mapping for POST /myContext/2023-04-03 14:57:46.546  INFO 22976 --- [nio-8080-exec-1] c.n.a.e.c.ForwardConfiguration           : No requested mapping found. Forwarding to indexDisconnected from the target VM, address: '127.0.0.1:51491', transport: 'socket'2023-04-03 14:58:10.378 ERROR 22976 --- [nio-8080-exec-1] o.a.c.c.C.[.[.[.[dispatcherServlet]      : Servlet.service() for servlet [dispatcherServlet] threw exceptionjava.lang.StackOverflowError: null    at java.base/java.util.concurrent.ConcurrentHashMap.putVal(ConcurrentHashMap.java:1012)    at java.base/java.util.concurrent.ConcurrentHashMap.put(ConcurrentHashMap.java:1006)    at org.apache.catalina.connector.Request.setAttribute(Request.java:1584)    at org.apache.catalina.connector.RequestFacade.setAttribute(RequestFacade.java:540)    at org.apache.catalina.core.ApplicationHttpRequest.setAttribute(ApplicationHttpRequest.java:306)    at org.apache.catalina.core.ApplicationHttpRequest.setAttribute(ApplicationHttpRequest.java:306)    at org.apache.catalina.core.ApplicationHttpRequest.setAttribute(ApplicationHttpRequest.java:306)    at org.apache.catalina.core.ApplicationHttpRequest.setAttribute(ApplicationHttpRequest.java:306)...... repeating many lines of setAttribute     at org.apache.catalina.core.ApplicationHttpRequest.setAttribute(ApplicationHttpRequest.java:306)    at org.apache.catalina.core.ApplicationHttpRequest.setAttribute(ApplicationHttpRequest.java:306)    at org.apache.catalina.core.ApplicationHttpRequest.setAttribute(ApplicationHttpRequest.java:306)    at javax.servlet.ServletRequestWrapper.setAttribute(ServletRequestWrapper.java:259)    at javax.servlet.ServletRequestWrapper.setAttribute(ServletRequestWrapper.java:259)    at javax.servlet.ServletRequestWrapper.setAttribute(ServletRequestWrapper.java:259)    at javax.servlet.ServletRequestWrapper.setAttribute(ServletRequestWrapper.java:259)    at javax.servlet.ServletRequestWrapper.setAttribute(ServletRequestWrapper.java:259)    at javax.servlet.ServletRequestWrapper.setAttribute(ServletRequestWrapper.java:259)    at org.springframework.web.servlet.resource.ResourceUrlEncodingFilter$ResourceUrlEncodingRequestWrapper.setAttribute(ResourceUrlEncodingFilter.java:87)    at javax.servlet.ServletRequestWrapper.setAttribute(ServletRequestWrapper.java:259)    at org.springframework.web.servlet.mvc.condition.ProducesRequestCondition.getAcceptedMediaTypes(ProducesRequestCondition.java:287)    at org.springframework.web.servlet.mvc.condition.ProducesRequestCondition.getMatchingCondition(ProducesRequestCondition.java:208)    at org.springframework.web.servlet.mvc.method.RequestMappingInfo.getMatchingCondition(RequestMappingInfo.java:393)    at org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping.getMatchingMapping(RequestMappingInfoHandlerMapping.java:109)    at org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping.getMatchingMapping(RequestMappingInfoHandlerMapping.java:67)    at org.springframework.web.servlet.handler.AbstractHandlerMethodMapping.addMatchingMappings(AbstractHandlerMethodMapping.java:448)    at org.springframework.web.servlet.handler.AbstractHandlerMethodMapping.lookupHandlerMethod(AbstractHandlerMethodMapping.java:408)    at org.springframework.data.rest.webmvc.BasePathAwareHandlerMapping.lookupHandlerMethod(BasePathAwareHandlerMapping.java:103)    at org.springframework.data.rest.webmvc.RepositoryRestHandlerMapping.lookupHandlerMethod(RepositoryRestHandlerMapping.java:147)    at org.springframework.web.servlet.handler.AbstractHandlerMethodMapping.getHandlerInternal(AbstractHandlerMethodMapping.java:383)    at org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping.getHandlerInternal(RequestMappingInfoHandlerMapping.java:125)    at org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping.getHandlerInternal(RequestMappingInfoHandlerMapping.java:67)    at org.springframework.web.servlet.handler.AbstractHandlerMapping.getHandler(AbstractHandlerMapping.java:498)    at org.springframework.data.rest.webmvc.config.DelegatingHandlerMapping$HandlerSelectionResult.from(DelegatingHandlerMapping.java:147)    at org.springframework.data.rest.webmvc.config.DelegatingHandlerMapping.getHandler(DelegatingHandlerMapping.java:114)    at org.springframework.web.servlet.DispatcherServlet.getHandler(DispatcherServlet.java:1261)    at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1043)    at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:963)    at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)    at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:909)    at javax.servlet.http.HttpServlet.service(HttpServlet.java:681)    at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)    at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)    at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:227)    at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162)    at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)    at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189)    at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162)    at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:102)    at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189)    at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162)    at org.apache.catalina.core.ApplicationDispatcher.invoke(ApplicationDispatcher.java:711)    at org.apache.catalina.core.ApplicationDispatcher.processRequest(ApplicationDispatcher.java:459)    at org.apache.catalina.core.ApplicationDispatcher.doForward(ApplicationDispatcher.java:385)    at org.apache.catalina.core.ApplicationDispatcher.forward(ApplicationDispatcher.java:313)    at org.springframework.session.web.http.SessionRepositoryFilter$SessionRepositoryRequestWrapper$SessionCommittingRequestDispatcher.forward(SessionRepositoryFilter.java:412)    at org.springframework.security.web.header.HeaderWriterFilter$HeaderWriterRequestDispatcher.forward(HeaderWriterFilter.java:170)    at org.springframework.web.servlet.view.InternalResourceView.renderMergedOutputModel(InternalResourceView.java:171)    at org.springframework.web.servlet.view.AbstractView.render(AbstractView.java:316)    at org.springframework.web.servlet.DispatcherServlet.render(DispatcherServlet.java:1401)    at org.springframework.web.servlet.DispatcherServlet.processDispatchResult(DispatcherServlet.java:1145)    at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1084)    at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:963)    at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)    at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:909)    at javax.servlet.http.HttpServlet.service(HttpServlet.java:681)    at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)    at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)    at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:227)    at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162)    at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)    at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189)    at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162)    at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:102)    at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189)    at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162)    at org.apache.catalina.core.ApplicationDispatcher.invoke(ApplicationDispatcher.java:711)    at org.apache.catalina.core.ApplicationDispatcher.processRequest(ApplicationDispatcher.java:459)    at org.apache.catalina.core.ApplicationDispatcher.doForward(ApplicationDispatcher.java:385)    at org.apache.catalina.core.ApplicationDispatcher.forward(ApplicationDispatcher.java:313)    at org.springframework.session.web.http.SessionRepositoryFilter$SessionRepositoryRequestWrapper$SessionCommittingRequestDispatcher.forward(SessionRepositoryFilter.java:412)    at org.springframework.security.web.header.HeaderWriterFilter$HeaderWriterRequestDispatcher.forward(HeaderWriterFilter.java:170)    at org.springframework.web.servlet.view.InternalResourceView.renderMergedOutputModel(InternalResourceView.java:171)    ... repeating blocks of stacktrace