package com.farmsimple.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordModel {
    private String currentPass;
    private String newPassword;
    private String confirmNewPassword;
}
