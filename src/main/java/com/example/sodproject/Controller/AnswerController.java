package com.example.sodproject.Controller;

import com.example.sodproject.Service.StackOverflowDataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import org.icepear.echarts.Bar;
import org.icepear.echarts.Line;
import org.icepear.echarts.Pie;
import org.icepear.echarts.charts.line.LineAreaStyle;
import org.icepear.echarts.charts.line.LineSeries;
import org.icepear.echarts.charts.pie.PieDataItem;
import org.icepear.echarts.components.coord.cartesian.CategoryAxis;
import org.icepear.echarts.components.series.LineStyle;
import org.icepear.echarts.render.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stackoverflow/answer")
public class AnswerController {

  @Autowired
  private StackOverflowDataService stackOverflowService;

  @GetMapping("/noAnswerPercentage")
  public String getQuestions() throws JsonProcessingException {
    double noAnswerPercentage = stackOverflowService.noAnswerPercentage();
    Pie pie = new Pie()
        .setTitle("Question answered")
        .setTooltip("item")
        .setLegend()
        .addSeries(new PieDataItem[]{
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
  public String averageAnswerCount() throws JsonProcessingException {
    double avg = stackOverflowService.averageAnswerCount();
    double max = stackOverflowService.maxAnswerCount();
    Bar bar = new Bar()
        .setLegend()
        .setTooltip("item")
        .addXAxis(new String[]{"Average", "Max"})
        .addYAxis()
        .addSeries(new Number[]{avg, max});
    Engine engine = new Engine();
    Handlebars handlebars = new Handlebars();
    String html = "";
    try {
      Template template = handlebars.compile("templates/index2");
      html = template.apply(engine.renderJsonOption(bar));
    } catch (IOException e) {
      System.out.println("template file not found");
    }
    return html;
  }

  @GetMapping("/maxAnswerCount")
  public String getMaxAnswerCount() throws JsonProcessingException {
    double avg = stackOverflowService.averageAnswerCount();
    double max = stackOverflowService.maxAnswerCount();
    Bar bar = new Bar()
        .setLegend()
        .setTooltip("item")
        .addXAxis(new String[]{"Average", "Max"})
        .addYAxis()
        .addSeries(new Number[]{avg, max});

    Engine engine = new Engine();
    Handlebars handlebars = new Handlebars();
    String html = "";
    try {
      Template template = handlebars.compile("templates/index2");
      html = template.apply(engine.renderJsonOption(bar));
    } catch (IOException e) {
      System.out.println("template file not found");
    }
    return html;
  }

  @GetMapping("/answerCountDistribution")
  public String getAnswerCountDistribution() throws JsonProcessingException {
    List<Map.Entry<Long, Long>> answerCounts = stackOverflowService.answerCountDistribution();

    Line line = new Line()
        .setTitle("Answer Distribution")
        .setTooltip("axis")
        .setLegend()
        .addXAxis(new CategoryAxis().setBoundaryGap(false)
            .setData(answerCounts.stream().map(entry -> entry.getKey().toString())
                .toArray(String[]::new)))
        .addYAxis()
        .addSeries(new LineSeries()
            .setName("Question number")
            .setStack("Total")
            .setSmooth(true)
            .setLineStyle(new LineStyle().setWidth(0))
            .setShowSymbol(false)
            .setAreaStyle(new LineAreaStyle())
            .setData(answerCounts.stream().map(Map.Entry::getValue).toArray(Number[]::new)));
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
