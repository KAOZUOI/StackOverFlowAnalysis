@Configuration@EnableR2dbcRepositories(basePackages = &quot;com.springboot2.repository&quot;)public class R2DBCConfig extends AbstractR2dbcConfiguration {    @Bean    public ConnectionFactory connectionFactory() {        return ConnectionFactories.get(                ConnectionFactoryOptions.builder()                        .option(DRIVER, &quot;postgresql&quot;)                        .option(HOST, &quot;localhost&quot;)                        .option(PORT, 5432)                        .option(USER, &quot;admin&quot;)                        .option(PASSWORD, &quot;admin&quot;)                        .option(DATABASE, &quot;springdb&quot;)                        .build());    }    @Bean    ReactiveTransactionManager transactionManager(ConnectionFactory connectionFactory) {        return new R2dbcTransactionManager(connectionFactory);    }}