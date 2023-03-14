package com.office.metrics.microservice.config;

import com.office.metrics.microservice.generator.DeviceGenerator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class GeneratorConfig {

    private final int countToGenerate = 100;

    private DeviceGenerator deviceGenerator;

    @Bean
    public void generateData() {
        deviceGenerator.generate(countToGenerate);
    }
}
