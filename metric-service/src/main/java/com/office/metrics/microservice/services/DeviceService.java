package com.office.metrics.microservice.services;

import com.office.metrics.microservice.models.Device;

import java.util.List;

public interface DeviceService {
    Device save(Device device);

    Device findById(Long deviceId);

    List<Device> findAll();

    void deleteById(Long deviceId);
}
