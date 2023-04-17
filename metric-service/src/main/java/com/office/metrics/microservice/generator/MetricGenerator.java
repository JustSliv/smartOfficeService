package com.office.metrics.microservice.generator;

import lombok.AllArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.lang.String.format;

@Component
@AllArgsConstructor
public class MetricGenerator implements DataGenerator {

    private static final String ID = "id";
    private static final String MEASURE_TIME = "measureTime";
    private static final String VALUE = "value";
    private static final String DEVICE = "device";
    private static final String FILEPATH = "metric-service/src/main/resources/jsons/metric%d.json";

    @Override
    public void generate(int countToGenerate) {
        createJSONFile(countToGenerate);
    }

    private void createJSONFile(int filesToGenerate) {
        for (int i = 1; i <= filesToGenerate; i++) {
            LocalDateTime measureTime = LocalDateTime.now().minusMinutes(i);
            JSONObject jsonObject = new JSONObject();

            JSONObject deviceObject = new JSONObject();
            deviceObject.put(ID, i);

            jsonObject.put(MEASURE_TIME, measureTime.format(DateTimeFormatter.ISO_DATE_TIME));
            jsonObject.put(VALUE, String.valueOf(i + 20));
            jsonObject.put(DEVICE, deviceObject);

            try {
                FileWriter file = new FileWriter(format(FILEPATH, i));
                file.write(jsonObject.toJSONString());
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
