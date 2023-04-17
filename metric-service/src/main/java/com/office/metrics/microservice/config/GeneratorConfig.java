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

    private final int countToGenerate = 100;

    private DeviceGenerator deviceGenerator;
    private MetricGenerator metricGenerator;
    private MetricParser metricParser;

    @Bean
    public void generateDeviceData() {
        deviceGenerator.generate(countToGenerate);
        metricGenerator.generate(1);
    }

//    @Bean
//    public void parseGeneratedJSON(){
//        metricParser.parseJSON("C:\\MyJavaProjects\\smartOfficeService\\metric-service\\src\\main\\resources\\jsons\\metric.json");
//    }
}
