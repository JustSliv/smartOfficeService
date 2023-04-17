package com.office.microservice.controller;

import com.office.microservice.model.OfficeUnit;
import com.office.microservice.service.OfficeUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/officeUnit")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class OfficeUnitController {

    private final OfficeUnitService officeUnitService;

    @PostMapping("/save")
    public ResponseEntity<OfficeUnit> save(@RequestBody OfficeUnit officeUnit) {
        return ResponseEntity.ok(officeUnitService.save(officeUnit));
    }

    @GetMapping("/findById/{office_unit_id}")
    public ResponseEntity<OfficeUnit> findById(@PathVariable(name = "office_unit_id") Long officeId) {
        return ResponseEntity.ok(officeUnitService.findById(officeId));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<OfficeUnit>> findAll() {
        return ResponseEntity.ok(officeUnitService.findAll());
    }

    @DeleteMapping("/deleteById/{office_id}")
    public void deleteById(@PathVariable(name = "office_id") Long officeId) {
        officeUnitService.deleteById(officeId);
    }
}
