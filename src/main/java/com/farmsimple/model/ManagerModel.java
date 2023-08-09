package com.farmsimple.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "managers")
public class ManagerModel {
    @Id
    @Column(name = "username", columnDefinition = "varchar(256)")
    private String username;

    @Column(name = "email", columnDefinition = "varchar(256)")
    private String email;

    @Column(name = "branch_id", columnDefinition = "int")
    private int branchId;

    @Column(name = "address", columnDefinition = "varchar(256)")
    private String address;

    @Column(name = "pharmacy_name", columnDefinition = "varchar(256)")
    private String pharmacyName;
}
