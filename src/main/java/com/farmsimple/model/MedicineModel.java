package com.farmsimple.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "medicines")
public class MedicineModel {
    @Id
    @Column(name = "mid", columnDefinition = "int")
    private int id;

    @Column(name = "mname", columnDefinition = "varchar(256)")
    private String medName;

    @Column(name = "mcompany", columnDefinition = "varchar(256)")
    private String manufacturer;

    @Column(name = "quantity", columnDefinition = "int default 0")
    private int quantity;

    @Column(name = "expiry_date", columnDefinition = "date")
    private Date expiryDate;

    @Column(name = "med_mrp", columnDefinition = "varchar(15)")
    private int medicineMrp;

    @Column(name = "med_rate", columnDefinition = "varchar(15)")
    private int medRate;

    @Column(name = "status", columnDefinition = "int default 0")
    private int status;

    @Column(name = "pharmacy_name", columnDefinition = "varchar(256)")
    private String pharmacyName;

    @Column(name = "added_by", columnDefinition = "varchar(256)")
    private String addedBy;

    @Column(name = "med_added_date")
    @CreatedDate
    private LocalDateTime medicineAddedDate;
}
