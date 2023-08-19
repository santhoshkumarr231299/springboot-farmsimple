package com.farmsimple.controller;

import com.farmsimple.model.DashboardModel;
import com.farmsimple.service.DashboardService;
import com.farmsimple.utils.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public class DashboardController {
    private JsonResponse jsonResponse;
    private DashboardService dashboardService;

    @Autowired
    DashboardController(JsonResponse jsonResponse, DashboardService dashboardService) {
        this.jsonResponse = jsonResponse;
        this.dashboardService = dashboardService;
    }

    @GetMapping("/get-dashboard-details")
    public ResponseEntity getDashboardDetails() {
        String username = ""; // get username from session
        DashboardModel dashboardModel = dashboardService.getDashboardDetails(username);
        return jsonResponse.createJsonResponseSuccess(dashboardModel, "Got the dashboard details");
    }
}
