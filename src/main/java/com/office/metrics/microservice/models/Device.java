package com.office.metrics.microservice.models;

import com.office.metrics.microservice.enums.DeviceType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Builder(builderMethodName = "device")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Device {

    private static final String ID = "id";
    private static final String TYPE = "type";
    private static final String MAX_CAPACITY = "maxCapacity";
    private static final String CURRENT_CAPACITY = "currentCapacity";
    private static final String ROOM_ID = "roomId";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID)
    private Long id;
    @Column(name = TYPE)
    private DeviceType type;
    @Column(name = MAX_CAPACITY)
    private Integer maxCapacity = 0;
    @Column(name = CURRENT_CAPACITY)
    private Integer currentCapacity = 0;
    @Column(name = ROOM_ID)
    private Long roomId;

}
