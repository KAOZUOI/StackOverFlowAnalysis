package br.com.uburu.spring.controller;// Imports@RestController@RequestMapping(&quot;/api/v1/filter&quot;)public class FilterController {    @Autowired    private FilterService service;    @GetMapping    public ResponseEntity<List<Filter>> getAll() {        List<Filter> filters = service.getAll();        return new ResponseEntity<List<Filter>>(filters, HttpStatus.OK);    }    @GetMapping(&quot;/{id}&quot;)    public ResponseEntity<Filter> getById(@PathVariable(&quot;id&quot;) long id) {        Filter filter = service.findById(id);        return new ResponseEntity<Filter>(filter, HttpStatus.OK);    }    // Some other methods    }