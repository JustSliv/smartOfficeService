package com.office.metrics.microservice.generator;

import lombok.AllArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

@Component
@AllArgsConstructor
public class MetricGenerator implements DataGenerator {
    /**
     * Ticket:
     * 1)Create MetricGenerator in which jsonFiles are created with metric properties
     * 2)Then generated files pass through parser and save in DB.
     */
    @Override
    public void generate(int countToGenerate) {
        createJSONFile();
    }

    private void createJSONFile() {
        JSONObject jsonObject = new JSONObject();

        JSONObject deviceObject = new JSONObject();
        deviceObject.put("id", 1);

        jsonObject.put("measureTime", "2019-02-03T10:08:02.432");
        jsonObject.put("value", "20");
        jsonObject.put("device", deviceObject);

        try{
            FileWriter file = new FileWriter("C:/MyJavaProjects/smartOfficeService/generatedMetricJSONs/metric.json");
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
