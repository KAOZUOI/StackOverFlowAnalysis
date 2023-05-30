public class WebProcessingContextBuilderWithJavaVariables extends WebProcessingContextBuilder {    private final Map<String, Object> vars;    public WebProcessingContextBuilderWithJavaVariables(Map<String, Object> variables) {        vars = variables;    }    @Override    protected void doAdditionalVariableProcessing(            final ITest test,            final HttpServletRequest request, final HttpServletResponse response, final ServletContext servletContext,            final Locale locale, final Map<String, Object> variables) {        variables.putAll(vars);    }}