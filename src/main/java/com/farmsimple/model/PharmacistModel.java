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
@Table(name = "pharmacists")
public class PharmacistModel {
    @Id
    @Column(name = "username", columnDefinition = "varchar(256)")
    private String username;

    @Column(name = "email", columnDefinition = "varchar(256)")
    private String email;

    @Column(name = "mobile_number", columnDefinition = "varchar(256)")
    private String mobileNumber;

    @Column(name = "address", columnDefinition = "varchar(256)")
    private String address;

    @Column(name = "aadhar_number", columnDefinition = "varchar(256)")
    private String aadharNumber;

    @Column(name = "added_by", columnDefinition = "varchar(256)")
    private String addedBy;
}
