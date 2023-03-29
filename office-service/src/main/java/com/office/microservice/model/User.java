package com.office.microservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Person")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private String login;
    @Column
    private String password;
    @Column
    private LocalDateTime loginLastTime;
    @Column
    private String email;
    @Column
    private String phoneNumber;
    @Column
    private String roleName;
    @ManyToMany
    private Set<OfficeUnit> officeUnit;
}
