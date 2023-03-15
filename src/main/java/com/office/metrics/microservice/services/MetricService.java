package com.office.metrics.microservice.services;

import com.office.metrics.microservice.models.Metric;

import java.util.List;

public interface MetricService {

    Metric save(Metric metric);

    Metric findById(Long metricId);

    List<Metric> findAll();

    void deleteById(Long metricId);
}
