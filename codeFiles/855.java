@ApplicationScopedpublic class AppScopeTest {    private final String test;        private TestClass testclass;    @Inject    public AppScopeTest (@ConfigProperty(name = &quot;my-config-prop&quot;) String test) {        this.testClass = new TestClass(test);    }}