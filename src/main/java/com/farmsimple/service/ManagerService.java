package com.farmsimple.service;

import com.farmsimple.model.ManagerModel;
import com.farmsimple.model.UserModel;
import com.farmsimple.repository.ManagerRepository;
import com.farmsimple.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerService {
    private ManagerRepository managerRepository;
    private UserRepository userRepository;

    @Autowired
    ManagerService(ManagerRepository managerRepository, UserRepository userRepository) {
        this.managerRepository = managerRepository;
        this.userRepository = userRepository;
    }

    public List<ManagerModel> getAllManagers(String username) {
        UserModel userModel = userRepository.getUserModelByUsername(username);
        if(userModel != null) {
            return managerRepository.getAllByPharmacyName(userModel.getPharmacyName());
        }
        return new ArrayList<>();
    }
    public void createNewManager(ManagerModel managerModel, String username) {
        UserModel userModel1 = userRepository.getUserModelByUsername(username);
        String pharmacyName = userModel1.getPharmacyName();

        UserModel userModel = new UserModel();
        userModel.setUsername(managerModel.getUsername());
        userModel.setEmail(managerModel.getEmail());
        userModel.setBranchId(managerModel.getBranchId());
        userModel.setPharmacyName(pharmacyName);
        userModel.setPassword("manager");
        userModel.setRole(4);
        userModel.setLastAccessed(1);
        userModel.setBranchId(1);
        userModel.setHaveAccessTo("[1][2][4][6][7][9]");
        userModel.setSubscriptionPack(userModel1.getSubscriptionPack());
        userModel.setDateOfSubscription(userModel1.getDateOfSubscription());

        managerModel.setPharmacyName(pharmacyName);

        userRepository.save(userModel);
        managerRepository.save(managerModel);
    }
}
