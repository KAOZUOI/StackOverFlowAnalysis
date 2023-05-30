// you need to add it to your SecurityWebFilterChain ServerHttpSecurity http configuration// this logoutSuccessHandler allows redirection after success logout to &quot;/v1/logout/success&quot;// you also need to provide @Controller which will return some response on ithttp.logout(logout -> logout        .logoutSuccessHandler((exchange, authentication) -> {          ServerHttpResponse response = exchange.getExchange().getResponse();          response.setStatusCode(HttpStatus.FOUND);          response.getHeaders().setLocation(URI.create(&quot;/v1/logout/success&quot;));          response.getCookies().remove(&quot;JSESSIONID&quot;);          return exchange.getExchange().getSession()              .flatMap(WebSession::invalidate);        })// this allows to proceed logout via GET request to &quot;/v1/logout&quot;        .requiresLogout(ServerWebExchangeMatchers.pathMatchers(HttpMethod.GET, &quot;/v1/logout&quot;)));