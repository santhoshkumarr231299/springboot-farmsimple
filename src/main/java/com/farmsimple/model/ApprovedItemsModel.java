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
@Table(name = "approved_items")
public class ApprovedItemsModel {
    @Id
    @Column(name = "mid", columnDefinition = "varchar(256)")
    private String id;

    @Column(name = "username", columnDefinition = "varchar(256)")
    private String username;

    @Column(name = "medname", columnDefinition = "varchar(256)")
    private String medName;

    @Column(name = "quantity", columnDefinition = "varchar(256)")
    private String quantity;

    @Column(name = "price", columnDefinition = "int")
    private int price;

    @Column(name = "pharmacy_name", columnDefinition = "varchar(256)")
    private String pharmacyName;

    @Column(name = "delivery_man", columnDefinition = "varchar(256) default 'NOT_ALLOCATED'")
    private String deliveryMan;

    @Column(name = "is_delivered", columnDefinition = "int default 0")
    private int isDelivered;
}
