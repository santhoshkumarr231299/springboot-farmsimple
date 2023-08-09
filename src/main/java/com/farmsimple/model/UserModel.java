package com.farmsimple.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "users")
public class UserModel {
    @Id
    @Column(name = "username", columnDefinition = "varchar(256)")
    private String username;

    @Column(name = "password", columnDefinition = "varchar(256)")
    private String password;

    @Column(name = "role", columnDefinition = "int")
    private int role;

    @Column(name = "role_desc", columnDefinition = "varchar(256)")
    private String roleDesc;

    @Column(name = "last_accessed", columnDefinition = "int default 1")
    private int lastAccessed;

    @Column(name = "email", columnDefinition = "varchar(256)")
    private String email;

    @Column(name = "pharmacy_name", columnDefinition = "varchar(256)")
    private String pharmacyName;

    @Column(name = "branch_id", columnDefinition = "int")
    private int branchId;

    @Column(name = "mobile_number", columnDefinition = "varchar(20)")
    private String mobileNumber;

    @Column(name = "have_access_to", columnDefinition = "varchar(256)")
    private String haveAccessTo;

    @Column(name = "subscription_pack", columnDefinition = "varchar(256)")
    private String subscriptionPack;

    @Column(name = "date_of_subscription", columnDefinition = "date")
    private Date dateOfSubscription;

    @Column(name = "status", columnDefinition = "int default 1")
    private int status;
}
