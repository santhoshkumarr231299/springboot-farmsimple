package com.farmsimple.controller;

import com.farmsimple.model.SettingsModel;
import com.farmsimple.model.UserModel;
import com.farmsimple.service.SettingsService;
import com.farmsimple.utils.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
public class SettingsController {
    private JsonResponse jsonResponse;
    private SettingsService settingsService;

    @Autowired
    SettingsController(JsonResponse jsonResponse, SettingsService settingsService) {
        this.jsonResponse = jsonResponse;
        this.settingsService = settingsService;
    }

    @GetMapping("/get-user-details")
    public ResponseEntity getUserDetailsForSettings(@RequestBody SettingsModel settingsModel) {
        settingsModel = settingsService.getUserDetailsForSettings(settingsModel.getUsername());
        if(settingsModel != null) {
            return jsonResponse.createJsonResponseFailure(settingsModel, "Got the User Details");
        }
        return jsonResponse.createJsonResponseFailure(null, "Failed to get User Detail");
    }

    @PostMapping("/update-user-details")
    public ResponseEntity updateUserDetails(@RequestBody SettingsModel settingsModel) {
        settingsModel = settingsService.updateUserDetailsForSettings(settingsModel);
        if(settingsModel != null) {
            return jsonResponse.createJsonResponseSuccess(null, "Details updated successfully");
        }
        return jsonResponse.createJsonResponseFailure(null, "Failed to update the user details");
    }
}
