package com.office.metrics.microservice.services.impl;

import com.office.metrics.microservice.models.Metric;
import com.office.metrics.microservice.repository.MetricRepository;
import com.office.metrics.microservice.services.MetricService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class MetricServiceImpl implements MetricService {

    private final MetricRepository metricRepository;

    public Metric save(Metric metric) {
        return metricRepository.save(metric);
    }

    public Metric findById(Long metricId) {
        return metricRepository.findById(metricId)
                .orElse(null);
    }
}
