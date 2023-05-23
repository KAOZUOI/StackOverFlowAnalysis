package com.example.sodproject.Service;


import com.example.sodproject.Model.Question;
import com.example.sodproject.Model.Tag;
import com.example.sodproject.Repository.TagRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileWriter;
import java.io.IOException;

import com.example.sodproject.Repository.QuestionRepository;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StackOverflowDataService {

  private static final String STACK_OVERFLOW_API_BASE_URL = "https://api.stackexchange.com/2.3";

  @Autowired
  private QuestionRepository questionRepository;
  private TagRepository tagRepository;

  public void fetchAndStoreQuestions() throws IOException {
    String apiUrl = STACK_OVERFLOW_API_BASE_URL
        + "/questions?order=desc&sort=activity&tagged=java&site=stackoverflow&filter=!nOedRLWnyS";
    HttpGet httpGet = new HttpGet(apiUrl);
    try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
      try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
        HttpEntity entity = response.getEntity();
        String jsonResponse = EntityUtils.toString(entity);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonAsString = objectMapper.writeValueAsString(jsonResponse);

        FileWriter fileWriter = new FileWriter("questions.json");
        fileWriter.write("");
        fileWriter.write(jsonAsString);
        fileWriter.close();

        JsonNode jsonNode = new ObjectMapper().readTree(jsonResponse);
        for (JsonNode item : jsonNode.get("items")) {
          System.out.println(item.get("question_id").asLong());
          questionRepository.save(new Question(
              item.get("question_id").asLong(),
              item.get("owner").get("user_id").asLong()));
//              item.get("answer_count").asLong(),
//              item.get("accepted_answer_id").asLong(),
//              new java.sql.Timestamp(item.get("creation_date").asLong()),
//              item.get("up_vote_count").asLong(),
//              item.get("view_count").asLong()));
        }
      } catch (IOException | ParseException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
