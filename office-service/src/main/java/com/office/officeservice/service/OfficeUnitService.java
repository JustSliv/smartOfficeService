package com.office.officeservice.service;

import com.office.officeservice.model.OfficeUnit;

import java.util.List;

public interface OfficeUnitService {
    OfficeUnit save(OfficeUnit officeUnit);
    OfficeUnit findById(Long officeUnitId);
    OfficeUnit update(OfficeUnit officeUnit);
    List<OfficeUnit> findAll();
    void deleteById(Long officeUnitId);
}
