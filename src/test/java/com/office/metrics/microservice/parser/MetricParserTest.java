package com.office.metrics.microservice.parser;

import com.office.metrics.microservice.models.Metric;
import org.junit.jupiter.api.Test;

import static com.office.metrics.microservice.parser.MetricParser.parseJSON;
import static org.assertj.core.api.Assertions.assertThat;


class MetricParserTest {

    public static final String FILEPATH = "C:\\MyJavaProjects\\metrics.microservice\\src\\main\\resources\\templates\\tempSensorResults.json";

//    @Test
//    void testParseJSON() {
//        Metric metric = parseJSON(FILEPATH);
//        assertThat(metric.getDeviceId()).isEqualTo(5245);
//        assertThat(metric.getValue()).isEqualTo("25");
//        assertThat(metric.getMeasureTime()).isEqualTo("2019-02-03T10:08:02.432");
//    }
}