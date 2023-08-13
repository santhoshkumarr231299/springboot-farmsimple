package com.farmsimple.controller;

import com.farmsimple.model.ManagerModel;
import com.farmsimple.model.UserModel;
import com.farmsimple.service.LoginService;
import com.farmsimple.service.ManagerService;
import com.farmsimple.utils.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
public class ManagerController {
    private JsonResponse jsonResponse;
    private ManagerService managerService;

    @Autowired
    ManagerController(JsonResponse jsonResponse, ManagerService managerService) {
        this.jsonResponse = jsonResponse;
        this.managerService = managerService;
    }

    @GetMapping("/get-managers")
    public ResponseEntity getAllManagers() {
        String username = ""; //get username from session
        List<ManagerModel> managerModelList = managerService.getAllManagers(username);
        return jsonResponse.createJsonResponseSuccess(managerModelList, "Got managers");
    }

    @PostMapping("post-new-manager")
    public ResponseEntity createNewManager(@RequestBody ManagerModel managerModel) {
        String username = ""; //get username from session
        managerService.createNewManager(managerModel, username);
        return jsonResponse.createJsonResponseSuccess(null, "Manager created successfully");
    }

}
