@SpringBootTest(classes = TestRedisConfiguration.class)@ActiveProfiles(&quot;test&quot;)public class EventStreamRepositoryTest {    @Autowired    private EventStreamRepository eventStreamRepository;    @Resource    private RedisConfiguration redisConfiguration;    @Resource    private EventsDataSourceProvider eventsDataSourceProvider;    @Resource    private EventsConversionUtil eventsConversionUtil;    private String organizationId = &quot;1879048492&quot;;    @BeforeEach    private void cleanUp() {        redisConfiguration.redisTemplate().getConnectionFactory().getConnection().flushDb();    }    @Test    public void saveEvents() {        List<String> events = eventsDataSourceProvider.getAllTypesEvents();        List<String> savedEvents = new ArrayList<>();        events.stream().forEach(event -> {            EventDto eventDto = eventsConversionUtil.convertJsonStringToObject(event);            savedEvents.add(eventStreamRepository.saveEvent(eventsConversionUtil.getEventIdIndexFromJson(event), organizationId,                    eventsConversionUtil.convertDateToSeconds(eventDto.getTimestamp()), event, eventDto.getTimestamp()));        });        Assertions.assertEquals(savedEvents.size(), events.size());    }    @Test    public void getAllEventsForOrg() {        cleanUp();        List<String> events = eventsDataSourceProvider.getAllTypesEvents();        List<String> savedEvents = new ArrayList<>();        events.stream().forEach(event -> {            EventDto eventDto = eventsConversionUtil.convertJsonStringToObject(event);            savedEvents.add(eventStreamRepository.saveEvent(eventsConversionUtil.getEventIdIndexFromJson(event), organizationId,                    eventsConversionUtil.convertDateToSeconds(eventDto.getTimestamp()), event, eventDto.getTimestamp()));        });        List<String> eventsJson = eventStreamRepository.getAllEvents(organizationId);        Assertions.assertEquals(eventsJson.size(), savedEvents.size());    }}