package com.example.sodproject.Controller;

import com.example.sodproject.Service.StackOverflowDataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import org.icepear.echarts.Line;
import org.icepear.echarts.charts.line.LineAreaStyle;
import org.icepear.echarts.charts.line.LineSeries;
import org.icepear.echarts.components.coord.cartesian.CategoryAxis;
import org.icepear.echarts.components.series.LineStyle;
import org.icepear.echarts.render.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stackoverflow/user")
public class UserController {

  @Autowired
  private StackOverflowDataService stackOverflowService;

  @GetMapping("/userAnswerDistribution")
  public String getUserAnswerDistribution() throws JsonProcessingException {
    List<Map.Entry<Long, Long>> userAnswer = stackOverflowService.userAnswerDistribution();
    Line line = new Line()
        .setTitle("User Answers")
        .setTooltip("axis")
        .setLegend()
        .addXAxis(new CategoryAxis().setBoundaryGap(false)
            .setData(userAnswer.stream().map(Map.Entry::getKey).toArray(Long[]::new)))
        .addYAxis()
        .addSeries(new LineSeries()
            .setName("Answers")
            .setStack("Total")
            .setSmooth(true)
            .setLineStyle(new LineStyle().setWidth(0))
            .setShowSymbol(false)
            .setAreaStyle(new LineAreaStyle())
            .setData(userAnswer.stream().map(Map.Entry::getValue).toArray(Number[]::new)));
    Engine engine = new Engine();
    Handlebars handlebars = new Handlebars();
    String html = "";
    try {
      Template template = handlebars.compile("templates/index2");
      html = template.apply(engine.renderJsonOption(line));
    } catch (IOException e) {
      System.out.println("template file not found");
    }
    return html;

  }

  @GetMapping("/userCommentDistribution")
  public String getUserCommentDistribution() throws JsonProcessingException {
    List<Map.Entry<Long, Long>> userComment = stackOverflowService.userCommentDistribution();
    Line line = new Line()
        .setTitle("User Comments")
        .setTooltip("axis")
        .setLegend()
        .addXAxis(new CategoryAxis().setBoundaryGap(false)
            .setData(userComment.stream().map(Map.Entry::getKey).toArray(Long[]::new)))
        .addYAxis()
        .addSeries(new LineSeries()
            .setName("Comments")
            .setStack("Total")
            .setSmooth(true)
            .setLineStyle(new LineStyle().setWidth(0))
            .setShowSymbol(false)
            .setAreaStyle(new LineAreaStyle())
            .setData(userComment.stream().map(Map.Entry::getValue).toArray(Number[]::new)));
    Engine engine = new Engine();
    Handlebars handlebars = new Handlebars();
    String html = "";
    try {
      Template template = handlebars.compile("templates/index2");
      html = template.apply(engine.renderJsonOption(line));
    } catch (IOException e) {
      System.out.println("template file not found");
    }
    return html;

  }

  @GetMapping("/userParticipateDistribution")
  public String getUserParticipateDistribution() throws JsonProcessingException {
    List<Map.Entry<Long, Long>> userParticipate = stackOverflowService.userParticipateDistribution();
    Line line = new Line()
        .setTitle("User Participates")
        .setTooltip("axis")
        .setLegend()
        .addXAxis(new CategoryAxis().setBoundaryGap(false)
            .setData(userParticipate.stream().map(Map.Entry::getKey).toArray(Long[]::new)))
        .addYAxis()
        .addSeries(new LineSeries()
            .setName("Participation")
            .setStack("Total")
            .setSmooth(true)
            .setLineStyle(new LineStyle().setWidth(0))
            .setShowSymbol(false)
            .setAreaStyle(new LineAreaStyle())
            .setData(userParticipate.stream().map(Map.Entry::getValue).toArray(Number[]::new)));
    Engine engine = new Engine();
    Handlebars handlebars = new Handlebars();
    String html = "";
    try {
      Template template = handlebars.compile("templates/index2");
      html = template.apply(engine.renderJsonOption(line));
    } catch (IOException e) {
      System.out.println("template file not found");
    }
    return html;
  }

  @GetMapping("/mostActiveUsers")
  public String getMostActiveUsers() throws JsonProcessingException {
    List<Map.Entry<Long, Long>> mostActiveUsers = stackOverflowService.mostActiveUsers();
    Line line = new Line()
        .setTitle("Most Active Users")
        .setTooltip("axis")
        .setLegend()
        .addXAxis(new CategoryAxis().setBoundaryGap(false)
            .setData(mostActiveUsers.stream().map(Map.Entry::getKey).toArray(Long[]::new)))
        .addYAxis()
        .addSeries(new LineSeries()
            .setName("Active Points")
            .setStack("Total")
            .setSmooth(true)
            .setLineStyle(new LineStyle().setWidth(0))
            .setShowSymbol(false)
            .setAreaStyle(new LineAreaStyle())
            .setData(mostActiveUsers.stream().map(Map.Entry::getValue).toArray(Number[]::new)));
    Engine engine = new Engine();
    Handlebars handlebars = new Handlebars();
    String html = "";
    try {
      Template template = handlebars.compile("templates/index2");
      html = template.apply(engine.renderJsonOption(line));
    } catch (IOException e) {
      System.out.println("template file not found");
    }
    return html;
  }
}
