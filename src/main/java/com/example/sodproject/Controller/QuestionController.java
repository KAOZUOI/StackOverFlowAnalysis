package com.example.sodproject.Controller;

import com.example.sodproject.Service.StackOverflowDataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import org.icepear.echarts.Line;
import org.icepear.echarts.Pie;
import org.icepear.echarts.charts.line.LineAreaStyle;
import org.icepear.echarts.charts.line.LineSeries;
import org.icepear.echarts.charts.pie.PieDataItem;
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
@RequestMapping("/stackoverflow/question")
public class QuestionController {

  @Autowired
  private StackOverflowDataService stackOverflowService;

  @GetMapping("/questionHaveAcceptedAnswerPercentage")
  public String getQuestionHaveAcceptedAnswerPercentage() throws JsonProcessingException {
    double AcAnswerP = stackOverflowService.questionHaveAcceptedAnswerPercentage();
    Pie pie = new Pie()
        .setTooltip("item")
        .setLegend()
        .addSeries(new PieDataItem[]{
            new PieDataItem().setValue(AcAnswerP).setName("Have Accepted Answer"),
            new PieDataItem().setValue(100 - AcAnswerP).setName("No Accepted Answer"),
        });

    Engine engine = new Engine();
    Handlebars handlebars = new Handlebars();
    String html = "";
    try {
      Template template = handlebars.compile("templates/QuestionAcceptedAnswer");
      html = template.apply(engine.renderJsonOption(pie));
    } catch (IOException e) {
      System.out.println("template file not found");
    }
    return html;
  }

  @GetMapping("/acceptedAnswerTimeDistribution")
  public String getAcceptedAnswerTimeDistribution() throws JsonProcessingException {
    List<Map.Entry<Long, Long>> questionResolutionTime = stackOverflowService.acceptedAnswerTimeDistribution();

    Line line = new Line()
        .setTooltip("axis")
        .setLegend()
        .addXAxis(new CategoryAxis().setBoundaryGap(false)
            .setData(questionResolutionTime.stream().map(entry -> entry.getKey().toString())
                .toArray(String[]::new)))
        .addYAxis()
        .addSeries(new LineSeries()
            .setName("Question number")
            .setStack("Total")
            .setSmooth(true)
            .setLineStyle(new LineStyle().setWidth(0))
            .setShowSymbol(false)
            .setAreaStyle(new LineAreaStyle())
            .setData(
                questionResolutionTime.stream().map(Map.Entry::getValue).toArray(Number[]::new)));
    Engine engine = new Engine();
    Handlebars handlebars = new Handlebars();
    String html = "";
    try {
      Template template = handlebars.compile("templates/QuestionResolutionTime");
      html = template.apply(engine.renderJsonOption(line));
    } catch (IOException e) {
      System.out.println("template file not found");
    }
    return html;
  }

  @GetMapping("/nonAcceptedAnswerUpvotePercentage")
  public String getNonAcceptedAnswerUpvotePercentage() throws JsonProcessingException {
    double NoAcAnswerUpvoteGreater = stackOverflowService.nonAcceptedAnswerUpvotePercentage();
    Pie pie = new Pie()
        .setTooltip("item")
        .setLegend()
        .addSeries(new PieDataItem[]{
            new PieDataItem().setValue(NoAcAnswerUpvoteGreater).setName(
                "No Accepted Answer Upvote Greater"),
            new PieDataItem().setValue(100 - NoAcAnswerUpvoteGreater).setName(
                "Accepted Answer Upvote Greater"),
        });

    Engine engine = new Engine();
    Handlebars handlebars = new Handlebars();
    String html = "";
    try {
      Template template = handlebars.compile("templates/QuestionsNoAcAnswerUpvoteGreater");
      html = template.apply(engine.renderJsonOption(pie));
    } catch (IOException e) {
      System.out.println("template file not found");
    }
    return html;
  }
}
