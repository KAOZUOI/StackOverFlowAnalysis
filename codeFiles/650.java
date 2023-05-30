package com.wellframe.excalibur.auth.accesscontrol;import org.aopalliance.intercept.MethodInvocation;import org.springframework.context.ApplicationContext;import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;import org.springframework.security.core.Authentication;/\*\** Used to provide custom security expressions in the @PreAuthorize annotation.  \*/  public class CustomMethodSecurityExpressionHandler extends DefaultMethodSecurityExpressionHandler {  private ApplicationContext context;  public CustomMethodSecurityExpressionHandler() {  String stopHere = &quot;stopHere&quot;;  }  @Override  protected MethodSecurityExpressionOperations createSecurityExpressionRoot(Authentication authentication,  MethodInvocation invocation) {       CustomMethodSecurityExpressionRoot root = new CustomMethodSecurityExpressionRoot(authentication, this.context);       root.setThis(invocation.getThis());       root.setPermissionEvaluator(getPermissionEvaluator());       root.setTrustResolver(getTrustResolver());       root.setRoleHierarchy(getRoleHierarchy());       root.setDefaultRolePrefix(getDefaultRolePrefix());       return root;  }  @Override  public void setApplicationContext(ApplicationContext applicationContext) {  super.setApplicationContext(applicationContext);  this.context = applicationContext;  }  }