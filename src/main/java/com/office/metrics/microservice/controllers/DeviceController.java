package com.office.metrics.microservice.controllers;

import com.office.metrics.microservice.enums.DeviceType;
import com.office.metrics.microservice.models.Device;
import com.office.metrics.microservice.services.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/device")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class DeviceController {

    private final DeviceService deviceService;

    @PostMapping("/save")
    public ResponseEntity<Device> save() {
        Device device = Device.device().maxCapacity(1000).type(DeviceType.LUMINOSITY).build();
        return ResponseEntity.ok(deviceService.save(device));
    }

    @GetMapping("/findById")
    public ResponseEntity<Device> findById(Long deviceId){
        return ResponseEntity.ok(deviceService.findById(deviceId));
    }
}



