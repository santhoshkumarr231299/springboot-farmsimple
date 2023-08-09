package com.farmsimple.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "reports")
public class ReportModel {
    @Id
    @Column(name = "id", columnDefinition = "int")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "username", columnDefinition = "varchar(256)")
    private String username;

    @Column(name = "pharmacy_name", columnDefinition = "varchar(256)")
    private String pharmacyName;

    @Column(name = "report_title", columnDefinition = "varchar(256)")
    private String reportTitle;

    @Column(name = "report_subject", columnDefinition = "varchar(256)")
    private String reportSubject;

    @Column(name = "report_desc", columnDefinition = "varchar(256)")
    private String reportDesc;

    @Column(name = "reported_date", columnDefinition = "date")
    private Date reportedDate;
}
