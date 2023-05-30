@RunWith(SpringRunner.class)@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)public class DummyChallengeTest extends AbstractSteps {    @Test    public void testHelloEndpoint() {                RestAssured.baseURI = &quot;http://localhost:8082&quot;;        RestAssured.basePath =&quot;/hello&quot;;        Response res = given()                .when().get()                .then().log().all()                .extract().response();        Assert.assertEquals(&quot;hello&quot;, res.getBody().asString());    }    @Test    public void testGreetingEndpoint() {        String uuid = UUID.randomUUID().toString();        //getServiceUrl() returning me the application base url        String requestUrl = getServiceUrl() + &quot;/hello/greeting/{name}&quot;;                given()                .pathParam(&quot;name&quot;, uuid)                .when().get(requestUrl)                .then().log().all()                .statusCode(200)                .body(is(&quot;hello &quot; + uuid)).log().all().extract();    }}