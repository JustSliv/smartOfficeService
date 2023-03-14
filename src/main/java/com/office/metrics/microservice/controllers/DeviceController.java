package com.office.metrics.microservice.controllers;

import com.office.metrics.microservice.enums.DeviceType;
import com.office.metrics.microservice.generator.DeviceGenerator;
import com.office.metrics.microservice.models.Device;
import com.office.metrics.microservice.services.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/device")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class DeviceController {

    private final DeviceService deviceService;
    private final DeviceGenerator deviceGenerator;

    @PostMapping("/save")
    public ResponseEntity<Device> save() {
        Device device = Device.device().maxCapacity(1000).type(DeviceType.LUMINOSITY).build();
        return ResponseEntity.ok(deviceService.save(device));
    }

    @GetMapping("/findById/{device_id}")
    public ResponseEntity<Device> findById(@PathVariable(name = "device_id") Long deviceId){
        return ResponseEntity.ok(deviceService.findById(deviceId));
    }

    @PostMapping("/generate/{count}")
    public ResponseEntity<String> generateDevices(@PathVariable(name = "count") int count) {
        deviceGenerator.generate(count);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
