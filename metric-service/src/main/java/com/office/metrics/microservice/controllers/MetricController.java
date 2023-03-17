package com.office.metrics.microservice.controllers;

import com.office.metrics.microservice.models.Device;
import com.office.metrics.microservice.models.Metric;
import com.office.metrics.microservice.services.DeviceService;
import com.office.metrics.microservice.services.MetricService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/metric")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class MetricController {

    private final MetricService metricService;
    private final DeviceService deviceService;

    @PostMapping("/save")
    public ResponseEntity<Metric> save(@RequestBody Metric metric) {
        Device device = deviceService.findById(metric.getDevice().getId());
        metric.setDevice(device);
        return ResponseEntity.ok(metricService.save(metric));
    }

    @GetMapping("/findById/{metric_id}")
    public Metric findById(@PathVariable(name = "metric_id") Long metricId) {
        return metricService.findById(metricId);
    }

    @GetMapping("/findAll")
    public List<Metric> findAll() {
        return metricService.findAll();
    }

    @DeleteMapping("/deleteById/{metric_id}")
    public void deleteById(@PathVariable(name = "metric_id") Long metricId) {
        metricService.deleteById(metricId);
    }
}
