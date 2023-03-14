package com.office.metrics.microservice.services;

import com.office.metrics.microservice.enums.DeviceType;
import com.office.metrics.microservice.models.Device;
import com.office.metrics.microservice.models.Metric;
import com.office.metrics.microservice.parser.MetricParser;


public interface MetricService {

    Metric save(Metric metric);

    Metric findById(Long metricId);
}
