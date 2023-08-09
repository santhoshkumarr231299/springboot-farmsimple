package com.farmsimple.repository;

import com.farmsimple.model.ReportModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportsRepository extends JpaRepository<ReportModel, Integer> {
    List<ReportModel> getReportModelByPharmacyName(String pharmacyName);
}
