package com.example.sodproject.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import com.example.sodproject.Model.Question;
import com.example.sodproject.Repository.QuestionRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collections;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

@Service
public class StackOverflowDataService {

  private static final String STACK_OVERFLOW_API_BASE_URL = "https://api.stackexchange.com/2.3";

  @Autowired
  private QuestionRepository questionRepository;

  public void fetchAndStoreQuestions() throws JsonProcessingException {
    RestTemplate restTemplate = new RestTemplate();
    String apiUrl = STACK_OVERFLOW_API_BASE_URL
        + "/questions?order=desc&sort=activity&tagged=java&site=stackoverflow";

    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null,
        String.class);

    String filePath = "/home/lerrorgk/Desktop/CodeField/file.txt";
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
      writer.write(Objects.requireNonNull(response.getBody()));
    } catch (IOException e) {
      e.printStackTrace();
    }

    // 将 JSON 响应转换为 JsonNode 对象
    ObjectMapper objectMapper = new ObjectMapper();
    JsonNode jsonNode = null;
    try {
      jsonNode = objectMapper.readTree(response.getBody());
    } catch (Exception e) {
      e.printStackTrace();
    }


    assert jsonNode != null;
        jsonNode.get("items").forEach(item -> {
            String title = item.get("title").asText();
            String body = item.get("body").asText();
            long question_id = item.get("question_id").asLong();
            Question question = new Question(question_id, title, body);
            questionRepository.save(question);
        });
  }
}
