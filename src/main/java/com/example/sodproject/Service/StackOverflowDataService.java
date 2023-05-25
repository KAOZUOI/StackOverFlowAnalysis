package com.example.sodproject.Service;


import com.example.sodproject.Model.Answer;
import com.example.sodproject.Model.Comment;
import com.example.sodproject.Model.Question;
import com.example.sodproject.Model.Tag;
import com.example.sodproject.Repository.AnswerRepository;
import com.example.sodproject.Repository.CommentRepository;
import com.example.sodproject.Repository.TagRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

import com.example.sodproject.Repository.QuestionRepository;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Iterator;
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
  @Autowired
  private TagRepository tagRepository;
  @Autowired
  private AnswerRepository answerRepository;
  @Autowired
  private CommentRepository commentRepository;

  public void fetchAndStoreQuestions() throws IOException {
    String url = STACK_OVERFLOW_API_BASE_URL
        + "/questions?pagesize=100&order=desc&sort=activity&tagged=java&site=stackoverflow&filter=!nOedRLWnyS";
    //String数组
    String[] apiUrls = {
        url + "&fromdate=1669852800&todate=1672444800",
        url + "&fromdate=1672444800&todate=1675123200",
        url + "&fromdate=1675123200&todate=1677715200",
        url + "&fromdate=1677715200&todate=1680393600",
        url + "&fromdate=1680393600&todate=1682985600",
    };
    for (String apiUrl : apiUrls) {
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
            JsonNode questionIdNode = item.get("question_id");
            long questionId =
                (questionIdNode != null && !questionIdNode.isNull()) ? questionIdNode.asLong() : 0L;

            JsonNode tagsNode = item.get("tags");
            FileWriter fileWriterTags = new FileWriter("tags.txt");
            fileWriterTags.write("");
            if (tagsNode.isArray()) {
              for (JsonNode tag : tagsNode) {
                String tagName = tag.asText();
                fileWriterTags.write(tagName + "\n");
                tagRepository.save(new Tag(questionId, tagName));
              }
            }
            fileWriterTags.close();

            JsonNode ownerIdNode = item.get("owner").get("user_id");
            long ownerId =
                (ownerIdNode != null && !ownerIdNode.isNull()) ? ownerIdNode.asLong() : 0L;

            JsonNode answerCountNode = item.get("answer_count");
            long answerCount =
                (answerCountNode != null && !answerCountNode.isNull()) ? answerCountNode.asLong()
                    : 0L;

            JsonNode acceptedAnswerIdNode = item.get("accepted_answer_id");
            long acceptedAnswerId = (acceptedAnswerIdNode != null && !acceptedAnswerIdNode.isNull())
                ? acceptedAnswerIdNode.asLong() : 0L;

            Timestamp creationDate = new Timestamp(0L);
            JsonNode creationDateNode = item.get("creation_date");
            if (creationDate != null && !creationDateNode.isNull()) {
              long creationDateLong = creationDateNode.asLong() * 1000;
              creationDate = new Timestamp(creationDateLong);
            }

            JsonNode upVoteCountNode = item.get("up_vote_count");
            long upVoteCount =
                (upVoteCountNode != null && !upVoteCountNode.isNull()) ? upVoteCountNode.asLong()
                    : 0L;

            JsonNode viewCountNode = item.get("view_count");
            long viewCount =
                (viewCountNode != null && !viewCountNode.isNull()) ? viewCountNode.asLong() : 0L;

            questionRepository.save(new Question(
                questionId,
                ownerId,
                answerCount,
                acceptedAnswerId,
                creationDate,
                upVoteCount,
                viewCount
            ));

            Thread.sleep(100);

            String answerUrl = STACK_OVERFLOW_API_BASE_URL
                + "/questions/" + questionId
                + "/answers?order=desc&sort=activity&site=stackoverflow&filter=!nNPvSNUjdS";

            HttpGet answerHttpGet = new HttpGet(answerUrl);
            CloseableHttpClient httpclientAnswer = HttpClients.createDefault();
            CloseableHttpResponse responseAnswer = httpclientAnswer.execute(answerHttpGet);
            HttpEntity entityAnswer = responseAnswer.getEntity();
            String jsonResponseAnswer = EntityUtils.toString(entityAnswer);
            JsonNode jsonNodeAnswer = new ObjectMapper().readTree(jsonResponseAnswer);
            for (JsonNode itemAnswer : jsonNodeAnswer.get("items")) {
              JsonNode answerIdNode = itemAnswer.get("answer_id");
              long answerId =
                  (answerIdNode != null && !answerIdNode.isNull()) ? answerIdNode.asLong() : 0L;

              JsonNode ownerIdAnswerNode = itemAnswer.get("owner").get("user_id");
              long ownerIdAnswer = (ownerIdAnswerNode != null && !ownerIdAnswerNode.isNull())
                  ? ownerIdAnswerNode.asLong() : 0L;

              JsonNode questionIdAnswerNode = itemAnswer.get("question_id");
              long questionIdAnswer =
                  (questionIdAnswerNode != null && !questionIdAnswerNode.isNull())
                      ? questionIdAnswerNode.asLong() : 0L;

              JsonNode creationDateAnswerNode = itemAnswer.get("creation_date");
              Timestamp creationDateAnswer = new Timestamp(0L);
              if (creationDateAnswerNode != null && !creationDateAnswerNode.isNull()) {
                long creationDateAnswerLong = creationDateAnswerNode.asLong() * 1000;
                creationDateAnswer = new Timestamp(creationDateAnswerLong);
              }

              JsonNode upVoteCountAnswerNode = itemAnswer.get("up_vote_count");
              long upVoteCountAnswer =
                  (upVoteCountAnswerNode != null && !upVoteCountAnswerNode.isNull())
                      ? upVoteCountAnswerNode.asLong() : 0L;

              JsonNode isAcceptedAnswerNode = itemAnswer.get("is_accepted");
              boolean isAcceptedAnswer =
                  (isAcceptedAnswerNode != null && !isAcceptedAnswerNode.isNull())
                      ? isAcceptedAnswerNode.asBoolean() : false;

              answerRepository.save(new Answer(
                  answerId,
                  ownerIdAnswer,
                  questionIdAnswer,
                  creationDateAnswer,
                  upVoteCountAnswer,
                  isAcceptedAnswer
              ));

              Thread.sleep(100);

              String commentUrl = STACK_OVERFLOW_API_BASE_URL
                  + "/posts/" + answerId
                  + "/comments?order=desc&sort=creation&site=stackoverflow";
              HttpGet commentHttpGet = new HttpGet(commentUrl);
              CloseableHttpClient httpclientComment = HttpClients.createDefault();
              CloseableHttpResponse responseComment = httpclientComment.execute(commentHttpGet);
              HttpEntity entityComment = responseComment.getEntity();
              String jsonResponseComment = EntityUtils.toString(entityComment);
              JsonNode jsonNodeComment = new ObjectMapper().readTree(jsonResponseComment);
              for (JsonNode itemComment : jsonNodeComment.get("items")) {
                JsonNode commentIdNode = itemComment.get("comment_id");
                long commentId =
                    (commentIdNode != null && !commentIdNode.isNull()) ? commentIdNode.asLong()
                        : 0L;

                JsonNode ownerIdCommentNode = itemComment.get("owner").get("user_id");
                long ownerIdComment = (ownerIdCommentNode != null && !ownerIdCommentNode.isNull())
                    ? ownerIdCommentNode.asLong() : 0L;

                JsonNode postIdCommentNode = itemComment.get("post_id");
                long postIdComment =
                    (postIdCommentNode != null && !postIdCommentNode.isNull())
                        ? postIdCommentNode.asLong() : 0L;

                commentRepository.save(new Comment(
                    commentId,
                    postIdComment,
                    ownerIdComment
                ));
              }
            }

            Thread.sleep(100);
            String commentUrl = STACK_OVERFLOW_API_BASE_URL
                + "/posts/" + questionId
                + "/comments?order=desc&sort=creation&site=stackoverflow";
            HttpGet commentHttpGet = new HttpGet(commentUrl);
            CloseableHttpClient httpclientComment = HttpClients.createDefault();
            CloseableHttpResponse responseComment = httpclientComment.execute(commentHttpGet);
            HttpEntity entityComment = responseComment.getEntity();
            String jsonResponseComment = EntityUtils.toString(entityComment);
            JsonNode jsonNodeComment = new ObjectMapper().readTree(jsonResponseComment);
            for (JsonNode itemComment : jsonNodeComment.get("items")) {
              JsonNode commentIdNode = itemComment.get("comment_id");
              long commentId =
                  (commentIdNode != null && !commentIdNode.isNull()) ? commentIdNode.asLong() : 0L;

              JsonNode ownerIdCommentNode = itemComment.get("owner").get("user_id");
              long ownerIdComment = (ownerIdCommentNode != null && !ownerIdCommentNode.isNull())
                  ? ownerIdCommentNode.asLong() : 0L;

              JsonNode postIdCommentNode = itemComment.get("post_id");
              long postIdComment =
                  (postIdCommentNode != null && !postIdCommentNode.isNull())
                      ? postIdCommentNode.asLong() : 0L;

              commentRepository.save(new Comment(
                  commentId,
                  postIdComment,
                  ownerIdComment
              ));

            }
          }
        } catch (ParseException | InterruptedException e) {
          throw new RuntimeException(e);
        }

      }
    }
  }
}
