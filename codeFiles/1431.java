HttpClient.create()  .secure(spec -> spec.sslContext(SslContextBuilder.forClient())    .defaultConfiguration(SslProvider.DefaultConfigurationType.TCP)    .handshakeTimeout(Duration.ofSeconds(60))    .closeNotifyFlushTimeout(Duration.ofSeconds(20))    .closeNotifyReadTimeout(Duration.ofSeconds(20)));