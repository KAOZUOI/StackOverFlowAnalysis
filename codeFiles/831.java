@Configurationpublic class EMailConfig{    public static final String MAIL_OUTBOUND_ENDPOINT_ID = &quot;mailOutbound.mailOutboundAdapter&quot;;    public static final String OUTBOUND_MAIL_CHANNEL_NAME = &quot;outboundMailChannel&quot;;    @Bean    public IntegrationFlow mailOutbound(final MailSender mailSender)    {        return IntegrationFlows.from(OUTBOUND_MAIL_CHANNEL_NAME)                .handle(Mail.outboundAdapter(mailSender), e -> e.id(MAIL_OUTBOUND_ENDPOINT_ID))                .get();    }}