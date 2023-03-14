package com.office.metrics.microservice.models;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.metamodel.IdentifiableType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder(builderMethodName = "metric")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Metric {

    private static final String ID = "id";
    private static final String VALUE = "value";
    private static final String MEASURE_TIME = "measureTime";
    private static final String DEVICE_ID = "deviceId";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID)
    private Long id;
    @Column(name = VALUE)
    private String value;
    @Column(name = MEASURE_TIME)
    private LocalDateTime measureTime;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(name = DEVICE_ID)
    private Device device;
}
