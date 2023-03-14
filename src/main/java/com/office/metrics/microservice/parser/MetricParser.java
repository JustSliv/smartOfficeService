package com.office.metrics.microservice.parser;

import com.office.metrics.microservice.models.Device;
import com.office.metrics.microservice.models.Metric;
import lombok.experimental.UtilityClass;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.time.LocalDateTime;

@UtilityClass
public class MetricParser {

    public static Metric parseJSON(String filePath) {
        JSONObject jsonObject = null;
        try {
            FileReader reader = new FileReader(filePath);
            JSONParser jsonParser = new JSONParser();
            jsonObject = (JSONObject) jsonParser.parse(reader);
        } catch (Exception e) {
            System.err.println("The file cannot be read!");
        }
        String value = (String) jsonObject.get("value");
        String measureTime = (String) jsonObject.get("measureTime");
        Long deviceId = (Long) jsonObject.get("deviceId");

        return buildMetric(value, LocalDateTime.parse(measureTime), deviceId);
    }

    private static Metric buildMetric(String value, LocalDateTime measureTime, Long deviceId) {
        return Metric.metric()
                .value(value)
                .measureTime(measureTime)
                .device(getDevice(deviceId))
                .build();
    }

    private static Device getDevice(Long deviceId){
        return Device.device()
                .id(deviceId)
                .build();
    }
}
