package com.farmsimple.service;

import com.farmsimple.model.UserModel;
import com.farmsimple.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class LoginService {

    private UserRepository userRepository;

    @Autowired
    LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserModel loginUser(UserModel userModel) {
        if(userModel == null || userModel.getUsername() == null || userModel.getPassword() == null) return null;
        Optional<UserModel> users = userRepository.findById(userModel.getUsername());
        if(users.isEmpty()) {
            return null;
        }

        return userModel;
    }
    public UserModel createUser(UserModel userModel) {
        if(userModel == null || userModel.getUsername() == null || userModel.getPassword() == null) return null;
        if(userModel.getPharmacyName() != null && !"".equals(userModel.getPharmacyName())) {
            userModel.setHaveAccessTo("[1][2][3][4][5][6][7][9][10]");
            userModel.setRole(1);
            userModel.setLastAccessed(1);
            userModel.setBranchId(1);
        } else {
            userModel.setHaveAccessTo("[8]");
            userModel.setRole(2);
            userModel.setLastAccessed(8);
            userModel.setBranchId(-1);
        }
        String rawPassword = userModel.getPassword();
//        String hashedPassword
//        userModel.setPassword(hashedPassword);
        userRepository.save(userModel);
        return userModel;
    }
    public void updateLastAccessedScreenForUser(UserModel userModel) {
        userRepository.updateLastAccessedForUser(userModel.getUsername(), userModel.getLastAccessed());
    }
    public boolean isUserNameExists(String username) {
        return userRepository.existsById(username);
    }
    public boolean isEmailExists(String email) {
        return userRepository.existsByEmail(email);
    }
    public boolean isMobileNumberExists(String mobileNumber) {
        return userRepository.existsByMobileNumber(mobileNumber);
    }
    public boolean isPharmacyNameExists(String pharmacyName) {
        return userRepository.existsByPharmacyName(pharmacyName);
    }
}
