WebSocketStompClient stompClient = new WebSocketStompClient(new StandardWebSocketClient());    stompFriendRequestsHandler = new WebsocketHandler();    WebSocketHttpHeaders stompFriendRequestHeader = createWebsocketHeader(headerForFriendRequestStomp);    System.out.println(stompFriendRequestHeader);    stompClient.connect(&quot;ws://localhost:8080/ws&quot;, stompFriendRequestHeader, stompFriendRequestsHandler);    StompSession session = stompFriendRequestsHandler.getSession();    session.subscribe(&quot;/all/messages&quot;, new StompFrameHandler() {        @Override        public Type getPayloadType(StompHeaders headers) {            System.out.println(&quot;getPayLoadType!&quot;);            return String.class;        }        @Override        public void handleFrame(StompHeaders headers, Object payload) {            System.out.println(&quot;YAY! We got the broadcast&quot;);            System.out.println(payload);        }    });ObjectMapper objectMapper = new ObjectMapper();    ObjectNode objectNode = objectMapper.createObjectNode();    objectNode.put(&quot;friendRequestUsername&quot;, 1);    try {        byte[] payload = objectMapper.writeValueAsBytes(objectNode);        stompFriendRequestsHandler.getSession().send(&quot;/app/application&quot;, payload);    } catch (JsonProcessingException e) {        throw new RuntimeException(e);    }