@RestControllerpublic class WhatsappController {    private final String VERIFICATION_TOKEN = &quot;12345&quot;;    @GetMapping(&quot;/webhook&quot;)    public ResponseEntity<String> verifyWebhook(@RequestParam(&quot;hub.mode&quot;) String mode,                                                @RequestParam(&quot;hub.challenge&quot;) String challenge,                                                @RequestParam(&quot;hub.verify_token&quot;) String token) {        if (mode.equals(&quot;subscribe&quot;) && token.equals(VERIFICATION_TOKEN)) {            return new ResponseEntity<>(challenge, HttpStatus.OK);        } else {            return new ResponseEntity<>(&quot;Verification token or mode mismatch&quot;, HttpStatus.FORBIDDEN);        }    }}