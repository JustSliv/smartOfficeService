package com.office.microservice.service.impl;

import com.office.microservice.service.OfficeUnitService;
import com.office.microservice.model.OfficeUnit;
import com.office.microservice.repository.OfficeUnitRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class OfficeUnitServiceImpl implements OfficeUnitService {

    private OfficeUnitRepository officeUnitRepository;

    @Override
    @Transactional
    public OfficeUnit save(OfficeUnit officeUnit) {
        return officeUnitRepository.save(officeUnit);
    }

    @Override
    @Transactional(readOnly = true)
    public OfficeUnit findById(Long officeUnitId) {
        return officeUnitRepository.findById(officeUnitId).orElseThrow();
    }

    @Override
    @Transactional
    public OfficeUnit update(OfficeUnit officeUnit) {
        return officeUnitRepository.save(officeUnit);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OfficeUnit> findAll() {
        return officeUnitRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Long officeUnitId) {
        officeUnitRepository.deleteById(officeUnitId);
    }
}
