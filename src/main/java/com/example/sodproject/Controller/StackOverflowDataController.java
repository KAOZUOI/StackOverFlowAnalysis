package com.example.sodproject.Controller;

import com.example.sodproject.Service.StackOverflowDataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import java.io.IOException;
import org.apache.hc.core5.http.ParseException;
import org.icepear.echarts.Line;
import org.icepear.echarts.Pie;
import org.icepear.echarts.charts.line.LineAreaStyle;
import org.icepear.echarts.charts.line.LineSeries;
import org.icepear.echarts.charts.pie.PieDataItem;
import org.icepear.echarts.components.coord.cartesian.CategoryAxis;
import org.icepear.echarts.components.title.Title;
import org.icepear.echarts.render.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stackoverflow")
public class StackOverflowDataController {

  @Autowired
  private StackOverflowDataService stackOverflowService;

  @GetMapping("/update")
  public String updateData() throws IOException, ParseException, InterruptedException {
    stackOverflowService.fetchAndStoreQuestions();
    return "Data updated successfully!";
  }

  @GetMapping("/noAnswerPercentage")
  public String getQuestions() throws JsonProcessingException {
    double noAnswerPercentage = stackOverflowService.noAnswerPercentage();
    Pie pie = new Pie()
        .setTitle("Question have answer")
        .setTooltip("item")
        .setLegend()
        .addSeries(new PieDataItem[] {
            new PieDataItem().setValue(noAnswerPercentage).setName("No Answer"),
            new PieDataItem().setValue(100 - noAnswerPercentage).setName("Answered"),
        });

    Engine engine = new Engine();
    Handlebars handlebars = new Handlebars();
    String html = "";
    try {
      Template template = handlebars.compile("templates/index2");
      html = template.apply(engine.renderJsonOption(pie));
    } catch (IOException e) {
      System.out.println("template file not found");
    }
    return html;
  }

  @GetMapping("/averageAnswerCount")
  public double averageAnswerCount() throws JsonProcessingException {
    return stackOverflowService.averageAnswerCount();
  }

  @GetMapping("/maxAnswerCount")
  public long getMaxAnswerCount() throws JsonProcessingException {
    return stackOverflowService.maxAnswerCount();
  }

  @GetMapping("/answerCountDistribution")
  public String getAnswerCountDistribution() throws JsonProcessingException {
    return stackOverflowService.answerCountDistribution().toString();
  }

  @GetMapping("/questionHaveAcceptedAnswerPercentage")
  public double getQuestionHaveAcceptedAnswerPercentage() throws JsonProcessingException {
    return stackOverflowService.questionHaveAcceptedAnswerPercentage();
  }

  @GetMapping("/acceptedAnswerTimeDistribution")
  public String getAcceptedAnswerTimeDistribution() throws JsonProcessingException {
    return stackOverflowService.acceptedAnswerTimeDistribution().toString();
  }

  @GetMapping("/nonAcceptedAnswerUpvotePercentage")
  public double getNonAcceptedAnswerUpvotePercentage() throws JsonProcessingException {
    return stackOverflowService.nonAcceptedAnswerUpvotePercentage();
  }

  @GetMapping("/frequentlyAppearTogetherWithJavaTag")
  public String getFrequentlyAppearTogetherWithJavaTag() throws JsonProcessingException {
    return stackOverflowService.frequentlyAppearTogetherWithJavaTag().toString();
  }

  @GetMapping("/mostUpvoteTags")
  public String getMostUpvoteTags() throws JsonProcessingException {
    return stackOverflowService.mostUpvoteTags().toString();
  }

  @GetMapping("/mostViewTags")
  public String getMostViewTags() throws JsonProcessingException {
    return stackOverflowService.mostViewTags().toString();
  }

  @GetMapping("/userAnswerDistribution")
  public String getUserAnswerDistribution() throws JsonProcessingException {
    return stackOverflowService.userAnswerDistribution().toString();
  }

  @GetMapping("/userCommentDistribution")
  public String getUserCommentDistribution() throws JsonProcessingException {
    return stackOverflowService.userCommentDistribution().toString();
  }

  @GetMapping("/userParticipateDistribution")
  public String getUserParticipateDistribution() throws JsonProcessingException {
    return stackOverflowService.userParticipateDistribution().toString();
  }

  @GetMapping("/mostActiveUsers")
  public String getMostActiveUsers() throws JsonProcessingException {
    return stackOverflowService.mostActiveUsers().toString();
  }

  @GetMapping("/option")
  public String index() {
    Pie pie = new Pie()
        .setTitle("Basic Pie")
        .setTooltip("item")
        .setLegend()
        .addSeries(new PieDataItem[] {
            new PieDataItem().setValue(1048).setName("Search Engine"),
            new PieDataItem().setValue(735).setName("Direct"),
            new PieDataItem().setValue(580).setName("Email"),
            new PieDataItem().setValue(484).setName("Union Ads"),
            new PieDataItem().setValue(300).setName("Video Ads")
        });

    Engine engine = new Engine();
    Handlebars handlebars = new Handlebars();
    String html = "";
    try {
      Template template = handlebars.compile("templates/index2");
      html = template.apply(engine.renderJsonOption(pie));
    } catch (IOException e) {
      System.out.println("template file not found");
    }
    return html;
  }


}
