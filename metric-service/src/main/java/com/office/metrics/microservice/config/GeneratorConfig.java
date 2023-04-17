package com.office.metrics.microservice.config;

import com.office.metrics.microservice.generator.DeviceGenerator;
import com.office.metrics.microservice.generator.MetricGenerator;
import com.office.metrics.microservice.parser.MetricParser;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class GeneratorConfig {

    private static final String FILEPATH = "metric-service/src/main/resources/jsons/metric%d.json";
    private final int countToGenerate = 100;

    private DeviceGenerator deviceGenerator;
    private MetricGenerator metricGenerator;
    private MetricParser metricParser;

    @Bean
    public void generateData() {
        deviceGenerator.generate(countToGenerate);
        metricGenerator.generate(countToGenerate);
    }

    @Bean
    public void parseGeneratedJSON() {
        for (int i = 1; i <= countToGenerate; i++) {
            metricParser.parseJSON(String.format(FILEPATH, i));
        }
    }
}
