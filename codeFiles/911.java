        String destination = &quot;/user/&quot; + Main.getApplicationState().getUserId() + &quot;/queue/friend-requests&quot;;    stompFriendRequestsHandler.getSession().subscribe(destination, new StompFrameHandler() {        @Override        public Type getPayloadType(StompHeaders headers) {            // Return the expected payload type of the message            return String.class;        }        @Override        public void handleFrame(StompHeaders headers, Object payload) {            System.out.println(&quot;- - - - - - - - - - - - - - - - - - -&quot;);            System.out.println(&quot;recived the user specifiq&quot;);            System.out.println(payload);        }    });    stompFriendRequestsHandler.getSession().subscribe(&quot;/topic&quot;, new StompFrameHandler() {        @Override        public Type getPayloadType(StompHeaders headers) {            return String.class;        }        @Override        public void handleFrame(StompHeaders headers, Object payload) {            System.out.println(&quot;- - - - - - - - - - - - - - - - - - -&quot;);            System.out.println(&quot;recieved the topic&quot;);            System.out.println(payload);        }    });}