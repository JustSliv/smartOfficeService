package com.office.microservice.service;

import com.office.microservice.model.OfficeUnit;

import java.util.List;

public interface OfficeUnitService {
    OfficeUnit save(OfficeUnit officeUnit);
    OfficeUnit findById(Long officeUnitId);
    OfficeUnit update(OfficeUnit officeUnit);
    List<OfficeUnit> findAll();
    void deleteById(Long officeUnitId);
}
