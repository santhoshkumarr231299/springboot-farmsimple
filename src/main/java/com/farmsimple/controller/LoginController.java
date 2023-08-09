package com.farmsimple.controller;

import com.farmsimple.model.UserModel;
import com.farmsimple.service.LoginService;
import com.farmsimple.utils.JsonResponse;
import com.farmsimple.utils.ValidationUtil;
import com.farmsimple.utils.Validators;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

@RestController
@ResponseBody
public class LoginController {
    private JsonResponse jsonResponse;
    private LoginService loginService;
    private ValidationUtil validationUtil;

    @Autowired
    LoginController(JsonResponse jsonResponse, LoginService loginService, ValidationUtil validationUtil) {
        this.jsonResponse = jsonResponse;
        this.loginService = loginService;
        this.validationUtil = validationUtil;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity loginUser(@RequestBody UserModel userModel) {
        userModel = loginService.loginUser(userModel);
        if(userModel != null) {
            return  jsonResponse.createJsonResponseSuccess(userModel, "Logged In Successfully");
        }
        return jsonResponse.createJsonResponseFailure(null, "Username does not exists");
    }

    @RequestMapping(value = "/new-user", method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody UserModel userModel) {
        List<Validators> validatorsList = Arrays.asList(Validators.USERNAME, Validators.PASSWORD, Validators.EMAIL, Validators.MOBILE_NUMBER);
        if(userModel.getPharmacyName() != null && userModel.getPharmacyName().length() > 0) {
            userModel.setPharmacyName(userModel.getPharmacyName().trim());
            validatorsList.add(Validators.PHARMACY_NAME);
        }
        String validationMessage = "";
        if(!(validationMessage = validationUtil.validateUserModel(userModel, validatorsList)).equals("")) {
            return jsonResponse.createJsonResponseFailure(null, validationMessage);
        } else if(loginService.isUserNameExists(userModel.getUsername())) {
            return  jsonResponse.createJsonResponseFailure(null, "Username name already exists");
        } else if (loginService.isEmailExists(userModel.getEmail())) {
            return  jsonResponse.createJsonResponseFailure(null, "Email already exists");
        } else if(loginService.isMobileNumberExists(userModel.getMobileNumber())) {
            return  jsonResponse.createJsonResponseFailure(null, "Mobile Number already exists");
        } else if(loginService.isPharmacyNameExists(userModel.getPharmacyName())) {
            return  jsonResponse.createJsonResponseFailure(null, "Pharmacy name already exists");
        }
        userModel = loginService.createUser(userModel);
        if(userModel != null) {
            return  jsonResponse.createJsonResponseSuccess(null, "New User Created Successfully");
        }
        return jsonResponse.createJsonResponseFailure(null, "Failed to create New User");
    }

    @RequestMapping(value = "/check-username", method = RequestMethod.POST)
    public ResponseEntity checkUserDuplicateDetails(@RequestBody UserModel userModel) {
        if(loginService.isUserNameExists(userModel.getUsername())) {
            return jsonResponse.createJsonResponseFailure(null, "Username already Exists");
        } else if(loginService.isEmailExists(userModel.getEmail())) {
            return jsonResponse.createJsonResponseFailure(null, "Email already Exists");
        } else if(loginService.isMobileNumberExists(userModel.getMobileNumber())) {
            return jsonResponse.createJsonResponseFailure(null, "Mobile Number already Exists");
        }
        return jsonResponse.createJsonResponseSuccess(null, "User Details aer unique");
    }

    @RequestMapping(value = "/update-last-accessed", method = RequestMethod.POST)
    public ResponseEntity updateLastAccessedScreenForUser(@RequestBody UserModel userModel) {
        loginService.updateLastAccessedScreenForUser(userModel);
        return jsonResponse.createJsonResponseSuccess(null, null);
    }
}
