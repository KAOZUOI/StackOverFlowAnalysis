  private static CountDownLatch countDownLatch = new CountDownLatch(1);    @GetMapping(&quot;/mono&quot;)  public Mono<Object> testMono(@RequestBody Mono<SignInRequest> body) {    countDownLatch = new CountDownLatch(1);    Mono<Integer> objectMono = Mono.just(25);    return objectMono        .flatMap(i -> body.flatMap(b -> doWork(i)));  }    @GetMapping(&quot;/mono/2&quot;)  public Mono<Object> testMono2(Integer a) {    countDownLatch = new CountDownLatch(1);    Mono<Integer> mono = Mono.just(99);    Mono<Integer> objectMono = Mono.just(a);    return objectMono        .flatMap(i -> mono.flatMap(b -> doWork(i)));  }    private Mono<Object> doWork(Integer i) {    return Mono.fromCallable(() -> {      System.out.println(Thread.currentThread().getName());      if(countDownLatch.await(i, TimeUnit.SECONDS)) {        return i;      }      throw new RuntimeException(&quot;time exceeded&quot;);    });  }