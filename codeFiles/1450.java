@Component@Order(Ordered.HIGHEST_PRECEDENCE)public class MyFilter implements Filter {    @Override    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {        log.info(&quot;MyFilter invoked............&quot;);        final HttpServletResponse response = (HttpServletResponse) servletResponse;        response.setHeader(&quot;Access-Control-Allow-Private-Network&quot;, &quot;true&quot;);        filterChain.doFilter(servletRequest, servletResponse);    }}