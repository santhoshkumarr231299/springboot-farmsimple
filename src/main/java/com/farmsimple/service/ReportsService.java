package com.farmsimple.service;

import com.farmsimple.model.ReportModel;
import com.farmsimple.repository.ReportsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportsService {
    private ReportsRepository reportsRepository;

    ReportsService(ReportsRepository reportsRepository) {
        this.reportsRepository = reportsRepository;
    }

    public List<ReportModel> getAllReports(String pharmacyName) {
        return reportsRepository.getReportModelByPharmacyName(pharmacyName);
    }
    public void createReport(ReportModel reportModel) {
        reportsRepository.save(reportModel);
    }
}
