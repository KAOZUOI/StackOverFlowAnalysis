 protected WebServiceTemplate     buildWebServiceTemplate(Jaxb2Marshaller marshaller,                                                          HttpComponentsMessageSender messageSender, String uri,     Supplier<String> jwtToken) {     WebServiceTemplate template = new WebServiceTemplate();     template.setMarshaller(marshaller);     template.setUnmarshaller(marshaller);     template.setMessageSender(messageSender);     template.setDefaultUri(uri);     ClientInterceptor[] clientInterceptors =     ArrayUtils.addAll(template.getInterceptors(), new Logger(), new     JwtClientInterceptor(jwtToken));     template.setInterceptors(clientInterceptors);     return template; }