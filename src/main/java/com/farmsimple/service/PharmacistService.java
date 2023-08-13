package com.farmsimple.service;

import com.farmsimple.model.ApprovedItemsModel;
import com.farmsimple.model.CartItemsModel;
import com.farmsimple.model.PharmacistModel;
import com.farmsimple.model.UserModel;
import com.farmsimple.repository.ApprovedItemsRepository;
import com.farmsimple.repository.PharmacistRepository;
import com.farmsimple.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PharmacistService {
    private PharmacistRepository pharmacistRepository;
    private ApprovedItemsRepository approvedItemsRepository;
    private UserRepository userRepository;

    @Autowired
    PharmacistService(PharmacistRepository pharmacistRepository, ApprovedItemsRepository approvedItemsRepository, UserRepository userRepository) {
        this.pharmacistRepository = pharmacistRepository;
        this.approvedItemsRepository = approvedItemsRepository;
        this.userRepository = userRepository;
    }

    public List<PharmacistModel> getPharmacistDetails(String username) {
        UserModel userModel = userRepository.getUserModelByUsername(username);
        if(userModel != null) {
            return pharmacistRepository.getAllByPharmacyName(username);
        }
        return new ArrayList<>();
    }

    public void createNewPharmacist(String username, PharmacistModel pharmacistModel) {
        UserModel userModel1 = userRepository.getUserModelByUsername(username);
        if(userModel1 == null) {
            return;
        }

        UserModel userModel = new UserModel();
        userModel.setUsername(pharmacistModel.getUsername());
        userModel.setPassword("pharmacist"); // need to hash and save
        userModel.setRole(3);
        userModel.setLastAccessed(11);
        userModel.setEmail(pharmacistModel.getEmail());
        userModel.setPharmacyName(userModel1.getPharmacyName());
        userModel.setBranchId(1);
        userModel.setMobileNumber(pharmacistModel.getMobileNumber());
        userModel.setHaveAccessTo("[11]");
        userModel.setSubscriptionPack(userModel1.getSubscriptionPack());
        userModel.setDateOfSubscription(userModel1.getDateOfSubscription());

        userRepository.save(userModel);

        pharmacistRepository.save(pharmacistModel);
    }
    public void approveOrder(CartItemsModel cartItemsModel) {
        ApprovedItemsModel approvedItemsModel = new ApprovedItemsModel();
        approvedItemsModel.setUsername(cartItemsModel.getUsername());
        approvedItemsModel.setId(cartItemsModel.getId());
        approvedItemsModel.setMedName(cartItemsModel.getMedName());
        approvedItemsModel.setPrice(cartItemsModel.getPrice());
        approvedItemsModel.setPharmacyName(cartItemsModel.getPharmacyName());
        approvedItemsModel.setQuantity(cartItemsModel.getQuantity());

        approvedItemsRepository.save(approvedItemsModel);
    }
}
