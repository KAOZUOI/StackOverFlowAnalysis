@Testvoid someTest() {    HashMap<String, Object> vars = new HashMap<>();    vars.put(&quot;key&quot;, validations);    executor.setProcessingContextBuilder(new WebProcessingContextBuilderWithJavaVariables(vars));    executor.execute(&quot;classpath:template.thtest&quot;);    Assertions.assertTrue(executor.isAllOK());}