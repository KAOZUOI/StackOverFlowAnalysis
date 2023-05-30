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

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;

import com.example.sodproject.Repository.QuestionRepository;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;


import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spoon.Launcher;
import spoon.reflect.CtModel;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtModule;
import spoon.reflect.declaration.CtPackage;
import spoon.reflect.declaration.CtType;
import spoon.reflect.visitor.filter.TypeFilter;
import spoon.reflect.factory.Factory;

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

    List<String> urls = new ArrayList<>();
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

          JsonNode jsonNode = new ObjectMapper().readTree(jsonResponse);
          for (JsonNode item : jsonNode.get("items")) {
            JsonNode questionIdNode = item.get("question_id");
            long questionId =
                (questionIdNode != null && !questionIdNode.isNull()) ? questionIdNode.asLong() : 0L;

            JsonNode tagsNode = item.get("tags");
            if (tagsNode.isArray()) {
              for (JsonNode tag : tagsNode) {
                String tagName = tag.asText();
                tagRepository.save(new Tag(questionId, tagName));
              }
            }

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

            JsonNode linkNode = item.get("link");
            String link = (linkNode != null && !linkNode.isNull()) ? linkNode.asText() : "";
            urls.add(link);

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

    FileWriter fileWriter = new FileWriter("urls.txt");
    for (String aUrl : urls) {
      fileWriter.write(aUrl + "\n");
    }
    fileWriter.close();

  }

  public void fetchAndStoreCodes() throws IOException, InterruptedException {
    //从文件中读取urls
    List<String> urls = new ArrayList<>();
    BufferedReader readerUrls = new BufferedReader(new FileReader("urls.txt"));
    String lineUrl;
    while ((lineUrl = readerUrls.readLine()) != null) {
      urls.add(lineUrl);
    }
    readerUrls.close();

    int count = 0;

    for (String url : urls) {
      URL stackOverflowUrl = new URL(url);
      URLConnection connection = stackOverflowUrl.openConnection();

      // 读取网页内容
      BufferedReader reader = new BufferedReader(
          new InputStreamReader(connection.getInputStream()));
      StringBuilder content = new StringBuilder();
      String line;
      while ((line = reader.readLine()) != null) {
        content.append(line);
      }
      reader.close();

      String html = content.toString();
      Pattern pattern = Pattern.compile("<pre><code>([\\s\\S]*?)</code></pre>");
      Matcher matcher = pattern.matcher(html);

      String path = "/home/lerrorgk/Desktop/Book/java2/StackOverFlowAnalysis/codeFiles/";
      while (matcher.find()) {
        String code = matcher.group(1);
        code = code.replace("&lt;", "<")
            .replace("&gt;", ">")
            .replace("&amp;", "&");
        String mypath = path + count + ".java";
        FileWriter fileWriter = new FileWriter(mypath);
        fileWriter.write(code);
        fileWriter.close();
        count++;
      }

      Thread.sleep(1000);
    }
  }

  public List<Map.Entry<String, Integer>> getAPIs() throws IOException {
    int count = 0;
    Map<String, Integer> map = new HashMap<>();
    String myPath = "/home/lerrorgk/Desktop/Book/java2/StackOverFlowAnalysis/codeFiles/";
    for (File file : new File(myPath).listFiles()) {
      if(count > 300){
        break;
      }
      myPath = "/home/lerrorgk/Desktop/Book/java2/StackOverFlowAnalysis/codeFiles/";
      myPath = myPath + count + ".java";
      if (file.isFile()) {
        try{
          Set<String> codes =  extractAPIs(myPath);
          for (String code : codes) {
            if (code.equals("unnamed package") || code.equals("unnamed module")){
              continue;
            }
            if (map.containsKey(code)) {
              map.put(code, map.get(code) + 1);
            } else {
              map.put(code, 1);
            }
          }
        } catch (Exception e){
          continue;
        }
      }
      count++;
    }
    List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
    list.sort(Map.Entry.comparingByValue());
    Collections.reverse(list);
    return list;
  }

  public static Set<String> extractAPIs(String path) {
    Set<String> apis = new HashSet<>();
    Launcher launcher = new Launcher();

    // 设置输入源码路径
    launcher.addInputResource(path);

    // 解析源码
    launcher.buildModel();

    Factory factory = launcher.getFactory();
    // 获取解析后的模型
    CtModel model = launcher.getModel();

    // 遍历模型，提取代码片段
    for (CtType<?> ctType : model.getElements(new TypeFilter<>(CtType.class))) {
      // 获取类名
      String className = ctType.getSimpleName();
      apis.add(className);

      // 获取方法名
      for (CtMethod<?> ctMethod : ctType.getMethods()) {
        String methodName = ctMethod.getSimpleName();
        apis.add(methodName);
      }
    }

    for (CtType<?> ctType : model.getElements(new TypeFilter<>(CtType.class))) {
      // 获取方法调用表达式
      for (CtInvocation<?> invocation : ctType.getElements(new TypeFilter<>(CtInvocation.class))) {
        // 获取调用的API名称
        String apiName = invocation.getExecutable().getSignature();
        apis.add(apiName);
      }
    }
    for (CtType<?> ctType : model.getAllTypes()){
      String fieldName = ctType.getSimpleName();
      apis.add(fieldName);
    }

    for(CtPackage ctType : model.getAllPackages()){
      String packageName = ctType.getSimpleName();
      apis.add(packageName);
    }

    for(CtModule ctType : model.getAllModules()){
      String typeName = ctType.getSimpleName();
      apis.add(typeName);
    }
    // 获取所有的 CtInterface 元素
    for (CtType<?> ctInterface : factory.Interface().getAll()) {
      apis.add(ctInterface.getSimpleName());
      for (CtMethod<?> ctMethod : ctInterface.getMethods()) {
        // 将方法的名称添加到API集合中
        apis.add(ctMethod.getSimpleName());
      }
    }

    // 获取所有的 CtClass 元素
    for (CtType<?> ctClass : factory.Class().getAll()) {
      apis.add(ctClass.getSimpleName());
      for (CtMethod<?> ctMethod : ctClass.getMethods()) {
        // 将方法的名称添加到API集合中
        apis.add(ctMethod.getSimpleName());
      }
    }

    // 获取所有的 CtEnum 元素
    for (CtType<?> ctEnum : factory.Enum().getAll()) {
      apis.add(ctEnum.getSimpleName());
      for (CtMethod<?> ctMethod : ctEnum.getMethods()) {
        // 将方法的名称添加到API集合中
        apis.add(ctMethod.getSimpleName());
      }
    }

    for (CtModule ctModule : factory.Module().getAllModules()) {
      apis.add(ctModule.getSimpleName());
    }

    for (CtPackage ctPackage : factory.Package().getAll()) {
      apis.add(ctPackage.getSimpleName());
    }
    return apis;
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
        if (tag.getTag().equals("java")) {
          continue;
        }
        tagCount.put(tag.getTag(), 1L);
      }
    }
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
        if(tag.getTag().equals("java") ){
          continue;
        }
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
        if(tag.getTag().equals("java") ){
          continue;
        }
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
            userParticipateDistribution.get(questionUserId) + 3);
      } else {
        userParticipateDistribution.put(questionUserId, 3L);
      }
    }

    List<Answer> answers = answerRepository.findAll();
    for (Answer answer : answers) {
      long answerUserId = answer.getUserId();
      if (userParticipateDistribution.containsKey(answerUserId)) {
        userParticipateDistribution.put(answerUserId,
            userParticipateDistribution.get(answerUserId) + 2);
      } else {
        userParticipateDistribution.put(answerUserId, 2L);
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
