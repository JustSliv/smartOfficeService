package com.office.metrics.microservice.services.impl;

import com.office.metrics.microservice.dto.RoomMetricDTO;
import com.office.metrics.microservice.exceptions.ResourceNotFoundException;
import com.office.metrics.microservice.models.Device;
import com.office.metrics.microservice.models.Metric;
import com.office.metrics.microservice.repository.MetricRepository;
import com.office.metrics.microservice.services.MetricService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class MetricServiceImpl implements MetricService {

    private final MetricRepository metricRepository;
    private final KafkaTemplate<String, RoomMetricDTO> kafkaTemplate;

    @Override
    @Transactional
    public Metric save(Metric metric) {
        Metric savedMetric = metricRepository.save(metric);
        kafkaTemplate.send("gotMetricFromRoom", buildRoomMetricDTO(metric));
        return savedMetric;
    }

    @Override
    @Transactional(readOnly = true)
    public Metric findById(Long metricId) {
        return metricRepository.findById(metricId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Metric with id=" + metricId + " not found.")
                );
    }

    @Override
    @Transactional(readOnly = true)
    public List<Metric> findAll() {
        return metricRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Long metricId) {//TODO correct handling when metric_id is not existing in DB
        if (isNull(metricId)) {
            throw new RuntimeException("metricId should not be:" + metricId);
        }
        metricRepository.deleteById(metricId);
    }

    private RoomMetricDTO buildRoomMetricDTO(Metric metric) {
        return RoomMetricDTO.roomMetricDTO()
                .metricId(metric.getId())
                .roomId(metric.getDevice().getRoomId())
                .build();
    }
}
