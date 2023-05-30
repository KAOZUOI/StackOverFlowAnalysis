  init {    requestProcessor.asFlux()      .flatMap { request ->        try {          logger.debug(&quot;handleByRabbitMq : {}&quot;, request)          footGateway.handleByRabbitMq(request)        } catch (e: Exception) {          logger.error(&quot;unknown error when processing foo request&quot;, e)          Mono.empty()        }      }      .subscribe()  }  fun handleRequest(fooRequest: FooRequest): Mono<FooResponse> {    val (_, id) = fooRequest    val responseSink = Sinks.one<FooResponse>()    responseListeners[id] = responseSink    requestProcessor.emitNext(fooRequest, emitFailureHandler)    return responseSink.asMono()      .timeout(Duration.ofSeconds(10))      .onErrorResume { Mono.just(FooResponse(REQUEST_SUBMITTED)) }      .doOnTerminate { responseListeners.remove(id) }  }