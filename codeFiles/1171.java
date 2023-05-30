package io.github.devatherock.controllerimport com.fasterxml.jackson.databind.ObjectMapperimport org.springframework.beans.factory.annotation.Autowiredimport org.springframework.boot.autoconfigure.EnableAutoConfigurationimport org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfigurationimport org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvcimport org.springframework.boot.test.context.SpringBootTestimport org.springframework.test.context.TestPropertySourceimport org.springframework.test.web.servlet.MockMvcimport org.springframework.test.web.servlet.request.MockMvcRequestBuildersimport spock.lang.Specificationimport java.nio.file.Filesimport java.nio.file.Paths@SpringBootTest@TestPropertySource(properties = &quot;jpa.enabled=false&quot;)@AutoConfigureMockMvc@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)class GenerateApiDocSpec extends Specification {    @Autowired    MockMvc mockMvc    @Autowired    ObjectMapper objectMapper    void 'test generate api doc'() {        setup:        Files.deleteIfExists(Paths.get('api-spec.json'))        when:        String apiSpec = mockMvc.perform(MockMvcRequestBuilders.get('/v3/api-docs'))                .andReturn().response.contentAsString        then:        def json = objectMapper.readValue(apiSpec, Map)        json['paths']['/hello']        cleanup:        new File('api-spec.json') << apiSpec    }}