package com.office.metrics.microservice.services;

import com.office.metrics.microservice.models.Device;

public interface DeviceService {
    Device save(Device device);

    Device findById(Long deviceId);
}
