package com.farmsimple.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SettingsModel {
    private String username;
    private String email;
    private String mobileNumber;
    private String pharmacyName;
    private int branchId;
}
