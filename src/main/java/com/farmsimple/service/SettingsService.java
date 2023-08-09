package com.farmsimple.service;

import com.farmsimple.model.SettingsModel;
import com.farmsimple.model.UserModel;
import com.farmsimple.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SettingsService {
    UserRepository userRepository;

    @Autowired
    SettingsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public SettingsModel getUserDetailsForSettings(String username) {
        Optional<UserModel> userModelList = userRepository.findById(username);
        if(userModelList.isEmpty()) {
            return null;
        } else {
            SettingsModel settingsModel = new SettingsModel();
            settingsModel.setUsername(userModelList.get().getUsername());
            settingsModel.setEmail(userModelList.get().getEmail());
            settingsModel.setMobileNumber(userModelList.get().getMobileNumber());
            settingsModel.setPharmacyName(userModelList.get().getPharmacyName());
            settingsModel.setBranchId(userModelList.get().getBranchId());
            return settingsModel;
        }
    }
    public SettingsModel updateUserDetailsForSettings(SettingsModel settingsModel) {
        userRepository.updateUserModelBySettings(settingsModel.getUsername(), settingsModel.getEmail(), settingsModel.getMobileNumber(), settingsModel.getBranchId(), settingsModel.getPharmacyName());
        return settingsModel;
    }
}
