package com.office.metrics.microservice.services.impl;

import com.office.metrics.microservice.models.Device;
import com.office.metrics.microservice.repository.DeviceRepository;
import com.office.metrics.microservice.services.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;

    @Override
    public Device save(Device device) {
        return deviceRepository.save(device);
    }

    @Override
    public Device findById(Long deviceId) {
        return deviceRepository.findById(deviceId)
                .orElse(null);
    }

}
