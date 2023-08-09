package com.farmsimple.utils;

import com.farmsimple.model.MedicineModel;
import com.farmsimple.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidationUtil {
    public String validateUserModel(UserModel userModel, List<Validators> validatorsList) {
        String message = "";
        if(validatorsList.contains(Validators.USERNAME) && !"".equals(message = validateUsername(userModel.getUsername())));
        else if(validatorsList.contains(Validators.PASSWORD) && !"".equals(message = validatePassword(userModel.getUsername())));
        else if(validatorsList.contains(Validators.EMAIL) && !"".equals(message = validateEmail(userModel.getEmail())));
        else if(validatorsList.contains(Validators.MOBILE_NUMBER) && !"".equals(message = validateMobilNumber(userModel.getMobileNumber())));
        else if(validatorsList.contains(Validators.PHARMACY_NAME) && !"".equals(message = validatePharmacyName(userModel.getPharmacyName())));
        return message;
    }
    public String validateMedicineModel(MedicineModel medicineModel, List<Validators> validatorsList) {
        String message = "";
        if(validatorsList.contains(Validators.MEDICINE_NAME) && !"".equals(message = validateMedicineName(medicineModel.getMedName())));
        else if(validatorsList.contains(Validators.MANUFACTURER_NAME) && !"".equals(message = validateMedicineManufacturerName(medicineModel.getManufacturer())));
        else if(validatorsList.contains(Validators.PHARMACY_NAME) && !"".equals(message = validatePharmacyName(medicineModel.getPharmacyName())));
        else if(validatorsList.contains(Validators.USERNAME) && !"".equals(message = validateUsername(medicineModel.getAddedBy())));
        return message;
    }
    public String validateUsername(String username) {
        if(username == null || username.length() == 0) {
            return "Username should not be empty";
        } else if(username.contains(" ")) {
            return "Enter a Valid Username (Spaces are not allowed)";
        } else if(username.length() < 6) {
            return "Username should have more than 5 letters";
        } else if(username.toLowerCase().equals(username)) {
            return "Password should only contain Lower Case letters";
        }
        return "";
    }
    public String validatePassword(String password) {
        if(password == null || password.length() == 0) {
            return "Password should not be empty";
        } else if(password.length() < 8) {
            return "Password should have Atleast 8 Characters";
        } else if(!password.matches("/[a-z]/g") || !password.matches("/[A-Z]/g") || !password.matches("/[0-9]/g")) {
            return "Password should contain a Lower Case, Upper Case and a Number";
        }
        return "";
    }
    public String validateMobilNumber(String mobileNumber) {
        if(mobileNumber == null || mobileNumber.length() == 0) {
            return "Mobile Number should not Empty";
        } else if(mobileNumber.length() > 15 || mobileNumber.length() < 7 || mobileNumber.matches("/^[0-9]/g")) {
            return "Enter a valid Mobile Number";
        }
        return "";
    }
    public String validateEmail(String email) {
        if(email == null || email.length() == 0) {
            return "Email should not be empty";
        } else if(!email.equals("/^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$/")) {
            return "Enter a valid email";
        }
        return "";
    }
    public String validatePharmacyName(String pharmacyName) {
        if(pharmacyName == null || pharmacyName.length() == 0) {
            return "Pharmacy name should not be empty";
        } else if(pharmacyName.length() < 5) {
            return "Pharmacy name should have atleast 5 letters";
        } else if(pharmacyName.matches("/^[a-z]/g")) {
            return "Pharmacy name should only contain Lower Case Letters";
        }
        return "";
    }
    public String validateMedicineManufacturerName(String medManuName) {
        if(medManuName == null || medManuName.length() == 0) {
            return "Manufacturer name should not be empty";
        } else if (medManuName.length() < 5) {
            return "Manufacturer should have atleast 5 characters";
        } else if(medManuName.matches("/^[a-z]/g]")) {
            return "Manufacturer name should only contain Lower Case Letters";
        }
        return "";
    }
    public String validateQuantity(int quantity, int min, int max) {
        if(quantity == 0) {
            return "Quantity should not be 0";
        } else if(quantity < min ) {
            return "Quantity should be more than " + min;
        } else if(quantity > max) {
            return "Quantity should be less than " + max;
        }
        return "";
    }
    public String validateAadharNumber(String aadhar) {
        if(aadhar == null || aadhar.length() == 0) {
            return "Aadhar Number should not be empty";
        } else if(aadhar.length() != 12) {
            return "Enter a valid Aadhar Number";
        }
        return "";
    }
    public String validateReports(String field, String value, int min, int max) {
        if(value == null || value.length() == 0) {
            return field + " should not be empty";
        } else if (value.length() < min) {
            return field + " should have atleast " + min + " characters";
        } else if(value.length() > max) {
            return field + " should not be more than " + max + " characters";
        }
        return "";
    }
    public String validateMedicineName(String medicineName) {
        if(medicineName == null || medicineName.length() == 0) {
            return "Medicine name should not be empty";
        } else if(medicineName.length() < 5) {
            return "Medicine name should have atleast 5 characters";
        } else if(medicineName.matches("/^[a-z]/g]")) {
            return "Medicine name only contain Lower Case Letters";
        }
        return "";
    }
}
