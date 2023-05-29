package com.example.sodproject.Controller;

import com.example.sodproject.Service.StackOverflowDataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.hc.core5.http.ParseException;
import org.icepear.echarts.Bar;
import org.icepear.echarts.Line;
import org.icepear.echarts.Pie;
import org.icepear.echarts.charts.line.LineAreaStyle;
import org.icepear.echarts.charts.line.LineDataItem;
import org.icepear.echarts.charts.line.LineSeries;
import org.icepear.echarts.charts.pie.PieDataItem;
import org.icepear.echarts.components.coord.cartesian.CategoryAxis;
import org.icepear.echarts.components.marker.MarkPoint;
import org.icepear.echarts.components.series.ItemStyle;
import org.icepear.echarts.components.series.LineStyle;
import org.icepear.echarts.components.text.Label;
import org.icepear.echarts.origin.util.SeriesLabelOption;
import org.icepear.echarts.render.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.sodproject.Component.Line.createSeries;

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

  @GetMapping("/fetchAndStoreCodes")
  public String fetchAndStoreCodes() throws IOException, ParseException, InterruptedException {
    stackOverflowService.fetchAndStoreCodes();
    return "Fetch and store codes successfully!";
  }

  @GetMapping("/getAPIs")
  public String getAPIs() throws IOException, ParseException, InterruptedException {
    return stackOverflowService.getAPIs().toString();
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
