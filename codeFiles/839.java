public class UTPasswordCallback implements CallbackHandler {     public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {        for (Callback callback : callbacks) {            WSPasswordCallback wpc = (WSPasswordCallback) callback;            if (wpc.getIdentifier().equals(&quot;cxf&quot;)) {                wpc.setPassword(&quot;cxf&quot;);                return;            }        }    }}public class HWClient {     public static void main(String[] args) {        HelloWorldService service = new HelloWorldService();        HelloWorld hw = service.getHelloWorldPort();                 Client client = ClientProxy.getClient(hw);        Endpoint endpoint = client.getEndpoint();         Map props = new HashMap();        props.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);        props.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);        props.put(WSHandlerConstants.PW_CALLBACK_CLASS, UTPasswordCallback.class.getName());        props.put(WSHandlerConstants.USER, &quot;cxf&quot;);                 WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(props);        endpoint.getOutInterceptors().add(wssOut);    }}