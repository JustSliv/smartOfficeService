package com.office.microservice.model;

import com.office.microservice.enums.RoomType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table
@Entity
@Builder(builderMethodName = "room")
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String roomName;
    @Column
    private double roomSize;
    @Column
    private boolean hasWorkPlaces;
    @Column
    private int workPlacesCount;
    @ManyToOne
    private OfficeUnit officeUnit;
    @Column
    private RoomType roomType;
}
