package com.office.metrics.microservice.controllers;

import com.office.metrics.microservice.enums.DeviceType;
import com.office.metrics.microservice.generator.DeviceGenerator;
import com.office.metrics.microservice.models.Device;
import com.office.metrics.microservice.services.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public ResponseEntity<Device> findById(@PathVariable(name = "device_id") Long deviceId) {
        return ResponseEntity.ok(deviceService.findById(deviceId));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Device>> findAll() {
        return ResponseEntity.ok(deviceService.findAll());
    }

    @DeleteMapping("/deleteById/{device_id}")
    public void deleteById(@PathVariable(name = "device_id") Long deviceId) {
        deviceService.deleteById(deviceId);
    }

//    @PostMapping("/generate/{count}")
//    public ResponseEntity<String> generateDevices(@PathVariable(name = "count") int count) {
//        deviceGenerator.generate(count);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
