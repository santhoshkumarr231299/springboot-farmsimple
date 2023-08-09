package com.farmsimple.controller;

import com.farmsimple.model.UserModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public class LogoutController {
    public ResponseEntity logoutUser(@RequestBody UserModel userModel) {
        //logout User
        return null;
    }
}
