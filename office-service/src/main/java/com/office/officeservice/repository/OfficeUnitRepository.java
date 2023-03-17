package com.office.officeservice.repository;

import com.office.officeservice.model.OfficeUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeUnitRepository extends JpaRepository<OfficeUnit, Long> {
}
