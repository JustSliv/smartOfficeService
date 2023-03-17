package com.office.metrics.microservice.services.impl;

import com.office.metrics.microservice.exceptions.ResourceNotFoundException;
import com.office.metrics.microservice.models.Device;
import com.office.metrics.microservice.repository.DeviceRepository;
import com.office.metrics.microservice.services.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;

    @Override
    @Transactional
    public Device save(Device device) {
        return deviceRepository.save(device);
    }

    @Override
    @Transactional(readOnly = true)
    public Device findById(Long deviceId) {
        return deviceRepository.findById(deviceId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Device with id=" + deviceId + " not found.")
                );
    }

    @Override
    @Transactional(readOnly = true)
    public List<Device> findAll() {
        return deviceRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Long deviceId) {//TODO correct handling when metric_id is not existing in DB
        if (isNull(deviceId)) {
            throw new RuntimeException("deviceId should not be:" + deviceId);
        }
        deviceRepository.deleteById(deviceId);
    }

}
