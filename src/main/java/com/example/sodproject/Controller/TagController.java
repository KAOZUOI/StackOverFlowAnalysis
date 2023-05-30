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
@RequestMapping("/stackoverflow/tag")
public class TagController {

  @Autowired
  private StackOverflowDataService stackOverflowService;

  @GetMapping("/frequentlyAppearTogetherWithJavaTag")
  public String getFrequentlyAppearTogetherWithJavaTag() throws JsonProcessingException {
    List<Map.Entry<String, Long>> TagsWithJava = stackOverflowService.frequentlyAppearTogetherWithJavaTag();
    Line line = new Line()
        .setTooltip("axis")
        .setLegend()
        .addXAxis(new CategoryAxis().setBoundaryGap(false)
            .setData(TagsWithJava.stream().map(entry -> entry.getKey()).toArray(String[]::new)))
        .addYAxis()
        .addSeries(new LineSeries()
            .setName("Tags With Java")
            .setStack("Total")
            .setSmooth(true)
            .setLineStyle(new LineStyle().setWidth(0))
            .setShowSymbol(false)
            .setAreaStyle(new LineAreaStyle())
            .setData(TagsWithJava.stream().map(Map.Entry::getValue).toArray(Number[]::new)));
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

  @GetMapping("/mostUpvoteTags")
  public String getMostUpvoteTags() throws JsonProcessingException {
    List<Map.Entry<String, Long>> mostUpvoteTags = stackOverflowService.mostUpvoteTags();
    Line line = new Line()
        .setTitle("Most Upvote Tags")
        .setTooltip("axis")
        .setLegend()
        .addXAxis(new CategoryAxis().setBoundaryGap(false)
            .setData(mostUpvoteTags.stream().map(entry -> entry.getKey()).toArray(String[]::new)))
        .addYAxis()
        .addSeries(new LineSeries()
            .setName("Upvote")
            .setStack("Total")
            .setSmooth(true)
            .setLineStyle(new LineStyle().setWidth(0))
            .setShowSymbol(false)
            .setAreaStyle(new LineAreaStyle())
            .setData(mostUpvoteTags.stream().map(Map.Entry::getValue).toArray(Number[]::new)));
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

  @GetMapping("/mostViewTags")
  public String getMostViewTags() throws JsonProcessingException {
    List<Map.Entry<String, Long>> mostViewTags = stackOverflowService.mostViewTags();
    Line line = new Line()
        .setTitle("Most View Tags")
        .setTooltip("axis")
        .setLegend()
        .addXAxis(new CategoryAxis().setBoundaryGap(false)
            .setData(mostViewTags.stream().map(entry -> entry.getKey()).toArray(String[]::new)))
        .addYAxis()
        .addSeries(new LineSeries()
            .setName("View")
            .setStack("Total")
            .setSmooth(true)
            .setLineStyle(new LineStyle().setWidth(0))
            .setShowSymbol(false)
            .setAreaStyle(new LineAreaStyle())
            .setData(mostViewTags.stream().map(Map.Entry::getValue).toArray(Number[]::new)));
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
