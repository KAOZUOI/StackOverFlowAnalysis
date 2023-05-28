package com.example.sodproject.Component;

import org.icepear.echarts.charts.line.LineAreaStyle;
import org.icepear.echarts.charts.line.LineSeries;
import org.icepear.echarts.components.marker.MarkPoint;
import org.icepear.echarts.components.series.LineStyle;

public class Line {
    public static LineSeries createSeries(String name, Object[] data) {
        return new LineSeries()
            .setName(name)
            .setStack("Total")
            .setSmooth(true)
            .setLineStyle(new LineStyle().setWidth(0))
            .setShowSymbol(false)
            .setAreaStyle(new LineAreaStyle())
            .setData(data);
    }
}
