@Bean@Order(Ordered.HIGHEST_PRECEDENCE)public SecurityFilterChain securityAuthFilterChain(HttpSecurity http) throws Exception {    OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http);    return http.formLogin().and().build();}@Beanpublic AuthorizationServerSettings authorizationServerSettings(){return AuthorizationServerSettings.builder().build();}@Beanpublic JWKSource<SecurityContext> jwkSource(){    RSAKey rsaKey = JwksKeys.generateRSAKey();    JWKSet set = new JWKSet(rsaKey);    return (j, sc) -> j.select(set);}@Beanpublic OAuth2TokenCustomizer<JwtEncodingContext> jwtCustomizer() {    return context -> {        if (context.getTokenType() == OAuth2TokenType.ACCESS_TOKEN) {            Authentication principal = context.getPrincipal();            Set<String> authorities = principal.getAuthorities().stream()                    .map(GrantedAuthority::getAuthority)                    .collect(Collectors.toSet());            for (String s:authorities)                System.out.println(s);            context.getClaims().claim(&quot;roles&quot;, authorities);        }    };}