package com.farmsimple.controller;

import com.farmsimple.model.PasswordModel;
import com.farmsimple.service.PasswordService;
import com.farmsimple.utils.JsonResponse;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public class PasswordController {
    private JsonResponse jsonResponse;
    private PasswordService passwordService;

    @Autowired
    PasswordController(JsonResponse jsonResponse, PasswordService passwordService) {
        this.jsonResponse = jsonResponse;
        this.passwordService = passwordService;
    }

    @PostMapping("/update-pass")
    public ResponseEntity changePassword(@RequestBody PasswordModel passwordModel) {
        return null;
    }

    @PostMapping("/forgot-pass-change")
    public ResponseEntity forgotPasswordChange(@RequestBody PasswordModel passwordModel) {
        return null;
    }
}
