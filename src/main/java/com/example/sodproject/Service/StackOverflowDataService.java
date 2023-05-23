package com.example.sodproject.Service;


import com.example.sodproject.Model.Question;
import com.example.sodproject.Model.Tag;
import com.example.sodproject.Repository.TagRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

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
//        private Long question_id;
//        private Long user_id;
//        private Long answer_count;
//        private Long accepted_answer_id;
//        private Timestamp creation_date;
//        private Long up_vote_count;
//        private Long view_count;
        JsonNode jsonNode = new ObjectMapper().readTree(jsonResponse);
        for (JsonNode item : jsonNode.get("items")) {
          JsonNode questionIdNode = item.get("question_id");
          long questionId = (questionIdNode != null && !questionIdNode.isNull()) ? questionIdNode.asLong() : 0L;

          JsonNode ownerIdNode = item.get("owner").get("user_id");
          long ownerId = (ownerIdNode != null && !ownerIdNode.isNull()) ? ownerIdNode.asLong() : 0L;

          JsonNode answerCountNode = item.get("answer_count");
          long answerCount = (answerCountNode != null && !answerCountNode.isNull()) ? answerCountNode.asLong() : 0L;

          JsonNode acceptedAnswerIdNode = item.get("accepted_answer_id");
          long acceptedAnswerId = (acceptedAnswerIdNode != null && !acceptedAnswerIdNode.isNull()) ? acceptedAnswerIdNode.asLong() : 0L;

          Timestamp creationDate = new Timestamp(0L);
          JsonNode creationDateNode = item.get("creation_date");
          if (creationDate != null && !creationDateNode.isNull()) {
            creationDate = new Timestamp(creationDateNode.asLong());
          }

          JsonNode upVoteCountNode = item.get("up_vote_count");
          long upVoteCount = (upVoteCountNode != null && !upVoteCountNode.isNull()) ? upVoteCountNode.asLong() : 0L;

          JsonNode viewCountNode = item.get("view_count");
          long viewCount = (viewCountNode != null && !viewCountNode.isNull()) ? viewCountNode.asLong() : 0L;

          questionRepository.save(new Question(
              questionId,
              ownerId,
              answerCount,
              acceptedAnswerId,
              creationDate,
              upVoteCount,
              viewCount
          ));
          System.out.println(item.get("question_id").asLong());
        }
      } catch (IOException | ParseException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
