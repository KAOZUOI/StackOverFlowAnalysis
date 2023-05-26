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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
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

  public void fetchAndStoreQuestions() throws IOException, InterruptedException, ParseException {

    TreeMap<Long, Long> postIdsAnswerCount = new TreeMap<>();
    TreeMap<Long, Long> postIdsCommentCount = new TreeMap<>();

    String url = STACK_OVERFLOW_API_BASE_URL
        + "/questions?pagesize=100&order=desc&sort=activity&tagged=java&site=stackoverflow&filter=!6WPIommDaeLM5";
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
            postIdsAnswerCount.put(questionId, answerCount);

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

            JsonNode commentCount = item.get("comment_count");
            long commentCountLong =
                (commentCount != null && !commentCount.isNull()) ? commentCount.asLong() : 0L;
            postIdsCommentCount.put(questionId, commentCountLong);

            questionRepository.save(new Question(
                questionId,
                ownerId,
                answerCount,
                acceptedAnswerId,
                creationDate,
                upVoteCount,
                viewCount,
                commentCountLong
            ));

          }
        }
      }
    }

    while (postIdsAnswerCount.size() != 0) {
      StringBuilder questionIds = new StringBuilder();
      long sum = 0L;
      long count = 0L;
      Iterator<Map.Entry<Long, Long>> iterator = postIdsAnswerCount.entrySet().iterator();
      while (iterator.hasNext()) {
        if (sum > 100 || count == 100) {
          break;
        }
        Map.Entry<Long, Long> entry = iterator.next();
        questionIds.append(entry.getKey()).append(";");
        iterator.remove();
        count++;
        sum += entry.getValue();
      }
      questionIds.deleteCharAt(questionIds.length() - 1);

      Thread.sleep(100);

      String answerUrl = STACK_OVERFLOW_API_BASE_URL
          + "/questions/" + questionIds
          + "/answers?pagesize=100&order=desc&sort=activity&site=stackoverflow&filter=!6WPIomoVB5-xc";

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

        JsonNode commentCountAnswerNode = itemAnswer.get("comment_count");
        long commentCountAnswer =
            (commentCountAnswerNode != null && !commentCountAnswerNode.isNull())
                ? commentCountAnswerNode.asLong() : 0L;
        postIdsCommentCount.put(answerId, commentCountAnswer);

        answerRepository.save(new Answer(
            answerId,
            ownerIdAnswer,
            questionIdAnswer,
            creationDateAnswer,
            upVoteCountAnswer,
            isAcceptedAnswer,
            commentCountAnswer
        ));
      }
    }

    while (postIdsCommentCount.size() != 0) {
      StringBuilder postIds = new StringBuilder();
      long sum = 0L;
      long count = 0L;
      Iterator<Map.Entry<Long, Long>> iterator = postIdsCommentCount.entrySet().iterator();
      while (iterator.hasNext()) {
        if (sum > 100 || count == 100) {
          break;
        }
        Map.Entry<Long, Long> entry = iterator.next();
        postIds.append(entry.getKey()).append(";");
        iterator.remove();
        count++;
        sum += entry.getValue();
      }
      postIds.deleteCharAt(postIds.length() - 1);

      Thread.sleep(100);

      String commentUrl = STACK_OVERFLOW_API_BASE_URL
          + "/posts/" + postIds
          + "/comments?pagesize=100&order=desc&sort=creation&site=stackoverflow";
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

  }

  public double noAnswerPercentage() {
    return questionRepository.countByAnswerCount(0L) * 100.0 / questionRepository.count();
  }

  public double averageAnswerCount() {
    List<Question> questions = questionRepository.findAll();
    long sum = 0L;
    for (Question question : questions) {
      sum += question.getAnswerCount();
    }
    return (double) sum / questions.size();
  }

  public long maxAnswerCount() {
    List<Question> questions = questionRepository.findAll();
    long max = 0L;
    for (Question question : questions) {
      if (question.getAnswerCount() > max) {
        max = question.getAnswerCount();
      }
    }
    return max;
  }

  public List<Map.Entry<Long, Long>> answerCountDistribution() {
    TreeMap<Long, Long> answerCountDistribution = new TreeMap<>();
    List<Question> questions = questionRepository.findAll();
    for (Long answerCount : questions.stream().map(Question::getAnswerCount).toList()) {
      if (answerCountDistribution.containsKey(answerCount)) {
        answerCountDistribution.put(answerCount, answerCountDistribution.get(answerCount) + 1);
      } else {
        answerCountDistribution.put(answerCount, 1L);
      }
    }
    List<Map.Entry<Long, Long>> list = new ArrayList<>(answerCountDistribution.entrySet());
    list.sort(Map.Entry.comparingByKey());
    Collections.reverse(list);
    return list;
  }

  //question have accepted answer percentage
  public double questionHaveAcceptedAnswerPercentage() {

    return 100.0 - (questionRepository.countByAcceptedAnswerId(0L) * 100.0
        / questionRepository.count());
  }

  public List<Map.Entry<Long, Long>> acceptedAnswerTimeDistribution() {
    TreeMap<Long, Long> acceptedAnswerTimeDistribution = new TreeMap<>();
    List<Question> questions = questionRepository.findByAcceptedAnswerIdNot(0L);
    for (Question question : questions) {

      long questionTime = question.getCreationDate().getTime();
      long day = TimeUnit.DAYS.convert(questionTime, TimeUnit.MILLISECONDS);
      List<Answer> answers = answerRepository.findByAnswerId(question.getAcceptedAnswerId());
      for (Answer answer : answers) {
        long answerTime = answer.getCreationDate().getTime();
        long day2 = TimeUnit.DAYS.convert(answerTime, TimeUnit.MILLISECONDS);
        long diff = day2 - day;
        if (acceptedAnswerTimeDistribution.containsKey(diff)) {
          acceptedAnswerTimeDistribution.put(diff, acceptedAnswerTimeDistribution.get(diff) + 1);
        } else {
          acceptedAnswerTimeDistribution.put(diff, 1L);
        }
      }
    }
    List<Map.Entry<Long, Long>> list = new ArrayList<>(acceptedAnswerTimeDistribution.entrySet());
    list.sort(Map.Entry.comparingByKey());
    Collections.reverse(list);
    return list;
  }


  public double nonAcceptedAnswerUpvotePercentage() {
    long count = 0L;
    List<Question> questions = questionRepository.findByAcceptedAnswerIdNot(0L);
    for (Question question : questions) {
      List<Answer> answers = answerRepository.findByQuestionId(question.getQuestionId());
      long acceptedAnswerId = question.getAcceptedAnswerId();
      long acceptedAnswerUpvoteCount = 0L;
      for (Answer answer : answers) {
        if (answer.getAnswerId() == acceptedAnswerId) {
          acceptedAnswerUpvoteCount = answer.getUpVoteCount();
          break;
        }
      }
      for (Answer answer : answers) {
        if (answer.getAnswerId() != acceptedAnswerId
            && answer.getUpVoteCount() > acceptedAnswerUpvoteCount) {
          count++;
          break;
        }
      }
    }
    return count * 100.0 / questions.size();
  }

//  Which tags frequently appear together with the java tag?

  public List<Map.Entry<String, Long>> frequentlyAppearTogetherWithJavaTag() {
    TreeMap<String, Long> tagCount = new TreeMap<>();
    List<Tag> tagList = tagRepository.findAll();
    for (Tag tag : tagList) {
      if (tagCount.containsKey(tag.getTag())) {
        tagCount.put(tag.getTag(), tagCount.get(tag.getTag()) + 1);
      } else {
        tagCount.put(tag.getTag(), 1L);
      }
    }
    //sort
    List<Map.Entry<String, Long>> list = new ArrayList<>(tagCount.entrySet());
    list.sort(Map.Entry.comparingByValue());
    Collections.reverse(list);
    return list;
  }

//  Which tags or tag combinations receive the most upvotes?

  public List<Map.Entry<String, Long>> mostUpvoteTags() {
    TreeMap<String, Long> tagCount = new TreeMap<>();
    List<Tag> tagList = tagRepository.findAll();
    for (Tag tag : tagList) {
      if(!tagCount.containsKey(tag.getTag())){
        tagCount.put(tag.getTag(), 0L);
      }
      List<Question> questions = questionRepository.findByQuestionId(tag.getQuestionId());
      for (Question question : questions) {
        tagCount.put(tag.getTag(), tagCount.get(tag.getTag()) + question.getUpVoteCount());
      }
    }
    List<Map.Entry<String, Long>> list = new ArrayList<>(tagCount.entrySet());
    list.sort(Map.Entry.comparingByValue());
    Collections.reverse(list);
    return list;
  }

  public List<Map.Entry<String, Long>> mostViewTags() {
    TreeMap<String, Long> tagCount = new TreeMap<>();
    List<Tag> tagList = tagRepository.findAll();
    for (Tag tag : tagList) {
      if(!tagCount.containsKey(tag.getTag())){
        tagCount.put(tag.getTag(), 0L);
      }
      List<Question> questions = questionRepository.findByQuestionId(tag.getQuestionId());
      for (Question question : questions) {
        tagCount.put(tag.getTag(), tagCount.get(tag.getTag()) + question.getViewCount());
      }
    }
    List<Map.Entry<String, Long>> list = new ArrayList<>(tagCount.entrySet());
    list.sort(Map.Entry.comparingByValue());
    Collections.reverse(list);
    return list;
  }


  public List<Map.Entry<Long, Long>> userAnswerDistribution() {
    TreeMap<Long, Long> userAnswerDistribution = new TreeMap<>();
    List<Question> questions = questionRepository.findAll();
    for (Question question : questions) {
      userAnswerDistribution.put(question.getQuestionId(), question.getAnswerCount());
    }
    List<Map.Entry<Long, Long>> list = new ArrayList<>(userAnswerDistribution.entrySet());
    list.sort(Map.Entry.comparingByValue());
    Collections.reverse(list);
    return list;
  }

  public List<Map.Entry<Long, Long>> userCommentDistribution() {
    TreeMap<Long, Long> userCommentDistribution = new TreeMap<>();
    List<Question> questions = questionRepository.findAll();
    for (Question question : questions) {
      userCommentDistribution.put(question.getQuestionId(), question.getCommentCount());
      for(Answer answer : answerRepository.findByQuestionId(question.getQuestionId())){
        userCommentDistribution.put(question.getQuestionId(), userCommentDistribution.get(question.getQuestionId()) + answer.getCommentCount());
      }
    }
    List<Map.Entry<Long, Long>> list = new ArrayList<>(userCommentDistribution.entrySet());
    list.sort(Map.Entry.comparingByValue());
    Collections.reverse(list);
    return list;
  }

  public List<Map.Entry<Long, Long>> userParticipateDistribution(){
    TreeMap<Long, Long> userParticipateDistribution = new TreeMap<>();
    List<Question> questions = questionRepository.findAll();
    for(Question question : questions){
      userParticipateDistribution.put(question.getQuestionId(), question.getCommentCount() + question.getAnswerCount());
      for(Answer answer : answerRepository.findByQuestionId(question.getQuestionId())){
        userParticipateDistribution.put(question.getQuestionId(), userParticipateDistribution.get(question.getQuestionId()) + answer.getCommentCount());
      }
    }
    List<Map.Entry<Long, Long>> list = new ArrayList<>(userParticipateDistribution.entrySet());
    list.sort(Map.Entry.comparingByValue());
    Collections.reverse(list);
    return list;
  }




  public List<Map.Entry<Long, Long>> mostActiveUsers() {
    TreeMap<Long, Long> userParticipateDistribution = new TreeMap<>();
    List<Question> questions = questionRepository.findAll();
    for (Question question : questions) {
      long questionUserId = question.getUserId();
      if (userParticipateDistribution.containsKey(questionUserId)) {
        userParticipateDistribution.put(questionUserId,
            userParticipateDistribution.get(questionUserId) + 1);
      } else {
        userParticipateDistribution.put(questionUserId, 1L);
      }
    }

    List<Answer> answers = answerRepository.findAll();
    for (Answer answer : answers) {
      long answerUserId = answer.getUserId();
      if (userParticipateDistribution.containsKey(answerUserId)) {
        userParticipateDistribution.put(answerUserId,
            userParticipateDistribution.get(answerUserId) + 1);
      } else {
        userParticipateDistribution.put(answerUserId, 1L);
      }
    }

    List<Comment> comments = commentRepository.findAll();
    for (Comment comment : comments) {
      long commentUserId = comment.getUserId();
      if (userParticipateDistribution.containsKey(commentUserId)) {
        userParticipateDistribution.put(commentUserId,
            userParticipateDistribution.get(commentUserId) + 1);
      } else {
        userParticipateDistribution.put(commentUserId, 1L);
      }
    }

    List<Map.Entry<Long, Long>> list = new ArrayList<>(userParticipateDistribution.entrySet());
    list.sort(Map.Entry.comparingByValue());
    Collections.reverse(list);
    return list;
  }

}
