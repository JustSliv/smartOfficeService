package com.office.metrics.microservice.parser;

import com.office.metrics.microservice.models.Device;
import com.office.metrics.microservice.models.Metric;
import com.office.metrics.microservice.services.MetricService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class MetricParser {

    private final MetricService metricService;

    public Metric parseJSON(String filePath) {
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
        JSONObject deviceObject = (JSONObject) jsonObject.get("device");
        Long deviceId = (Long) deviceObject.get("id");

        return metricService.save(buildMetric(value, LocalDateTime.parse(measureTime), deviceId));
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
