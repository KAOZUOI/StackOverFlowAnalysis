package project.config;import org.springframework.context.annotation.Configuration;import org.springframework.security.config.annotation.web.builders.HttpSecurity;import org.springframework.security.config.annotation.web.configuration.Enable Web Security;import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;@Configuration@EnableWebSecuritypublic class SecurityConfig extends WebSecurityConfigurerAdapter{    @Override    protected void configure(Http Security http) throws Exception    {        http.authorizerequest()        .antMatchers(&quot;/h2-console/*&quot;).denyAll()        .and().headers().frameOptions().disable();    }}