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
@Table(name = "cartitems")
public class CartItemsModel {
    @Id
    @Column(name = "mid", columnDefinition = "varchar(256)")
    private int id;

    @Column(name = "username", columnDefinition = "varchar(256)")
    private String username;

    @Column(name = "medname", columnDefinition = "varchar(256)")
    private String medName;

    @Column(name = "quantity", columnDefinition = "int")
    private int quantity;

    @Column(name = "price", columnDefinition = "price")
    private int price;

    @Column(name = "pharm_name", columnDefinition = "varchar(256)")
    private String pharmacyName;

    @Column(name = "is_ordered", columnDefinition = "int default 0")
    private int isOrdered;
}
