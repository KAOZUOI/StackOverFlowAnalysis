client = SsmClient.builder().httpClientBuilder(new SdkHttpClient() {   @Override   public void close() {   }   @Override   public ExecutableHttpRequest prepareRequest(HttpExecuteRequest request) {      return null;   }})