package com.farmsimple.service;

import com.farmsimple.model.PasswordModel;
import com.farmsimple.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {
    private UserRepository userRepository;

    @Autowired
    PasswordService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void changePassword(String username, PasswordModel passwordModel) {
        String hashedPassword = ""; // passwordModel.getNewPassword();
        userRepository.updatePassword(hashedPassword, username);
    }
    public boolean comparePassword(String username, PasswordModel passwordModel) {
        String hashedPassword = ""; // passwordModel.getNewPassword();

        return true; // bcrypt compare password
    }
}
