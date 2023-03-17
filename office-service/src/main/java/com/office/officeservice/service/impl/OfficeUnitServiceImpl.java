package com.office.officeservice.service.impl;

import com.office.officeservice.service.OfficeUnitService;
import com.office.officeservice.model.OfficeUnit;
import com.office.officeservice.repository.OfficeUnitRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class OfficeUnitServiceImpl implements OfficeUnitService {

    private OfficeUnitRepository officeUnitRepository;
    @Override
    public OfficeUnit save(OfficeUnit officeUnit) {
        return officeUnitRepository.save(officeUnit);
    }

    @Override
    public OfficeUnit findById(Long officeUnitId) {
        return officeUnitRepository.findById(officeUnitId).orElseThrow();
    }

    @Override
    public OfficeUnit update(OfficeUnit officeUnit) {
        return officeUnitRepository.save(officeUnit);
    }

    @Override
    public List<OfficeUnit> findAll() {
        return officeUnitRepository.findAll();
    }

    @Override
    public void deleteById(Long officeUnitId) {
        officeUnitRepository.deleteById(officeUnitId);
    }
}
