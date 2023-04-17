package com.office.microservice.config;

import com.office.microservice.generator.RoomGenerator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class GeneratorConfig {

    private RoomGenerator roomGenerator;

    @Bean
    public void generateUnitRooms(){
        roomGenerator.generate();
    }
}
