package com.example.sodproject.Controller;

import com.example.sodproject.Service.StackOverflowDataService;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import org.icepear.echarts.Line;
import org.icepear.echarts.charts.line.LineAreaStyle;
import org.icepear.echarts.charts.line.LineSeries;
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
@RequestMapping("/stackoverflow/codeAnalyze")
public class CodeAnalyzeController {
    @Autowired
    private StackOverflowDataService stackOverflowService;
    @GetMapping("/getAPIs")
    public String codeAnalyze() throws IOException {
        List<Map.Entry<String, Integer>> apis = stackOverflowService.getAPIs();
        Line line = new Line()
            .setTitle("Most Active Users")
            .setTooltip("axis")
            .setLegend()
            .addXAxis(new CategoryAxis().setBoundaryGap(false)
                .setData(apis.stream().map(Map.Entry::getKey).toArray(String[]::new)))
            .addYAxis()
            .addSeries(new LineSeries()
                .setName("Active Points")
                .setStack("Total")
                .setSmooth(true)
                .setLineStyle(new LineStyle().setWidth(0))
                .setShowSymbol(false)
                .setAreaStyle(new LineAreaStyle())
                .setData(apis.stream().map(Map.Entry::getValue).toArray(Number[]::new)));
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
