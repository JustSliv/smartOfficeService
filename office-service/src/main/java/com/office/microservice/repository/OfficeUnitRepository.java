package com.office.microservice.repository;

import com.office.microservice.model.OfficeUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeUnitRepository extends JpaRepository<OfficeUnit, Long> {
}
