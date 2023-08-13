package com.farmsimple.controller;

import com.farmsimple.model.ReportModel;
import com.farmsimple.service.ReportsService;
import com.farmsimple.utils.JsonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
public class ReportsController {
    private JsonResponse jsonResponse;
    private ReportsService reportsService;

    ReportsController(JsonResponse jsonResponse, ReportsService reportsService) {
        this.jsonResponse = jsonResponse;
        this.reportsService = reportsService;
    }

    @GetMapping("/get-reports")
    public ResponseEntity getAllReports() {
        String pharmacyName = ""; //get pharmacy name from session
        List<ReportModel> reportModelList = reportsService.getAllReports(pharmacyName);
        return jsonResponse.createJsonResponseSuccess(reportModelList, "Got Report Models");
    }

    @PostMapping("/post-report")
    public ResponseEntity createReport(@RequestBody ReportModel reportModel) {
        String username = ""; //get username from session
        String pharmacyName = ""; //get pharmacy name from session
        reportModel.setUsername(username);
        reportModel.setPharmacyName(pharmacyName);
        reportsService.createReport(reportModel);
        return jsonResponse.createJsonResponseSuccess(null, "Report created successfully");
    }
}
