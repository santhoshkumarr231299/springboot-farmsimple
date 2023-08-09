package com.farmsimple.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "invoices")
public class InvoicesModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "username", columnDefinition = "varchar(256)")
    private String username;

    @Column(name = "pharm_name", columnDefinition = "varchar(256)")
    private String pharmacyName;

    @Column(name = "branch", columnDefinition = "int")
    private int branchId;

    @Column(name = "amount", columnDefinition = "varchar(256)")
    private String amount;

    @Column(name = "quantity", columnDefinition = "int")
    private int quantity;

    @Column(name = "invoice_date", columnDefinition = "date")
    private Date invoiceDate;
}
