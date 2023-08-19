package com.farmsimple.service;

import com.farmsimple.model.ApprovedItemsModel;
import com.farmsimple.model.DeliveryManModel;
import com.farmsimple.model.UserModel;
import com.farmsimple.repository.ApprovedItemsRepository;
import com.farmsimple.repository.DeliveryManRepository;
import com.farmsimple.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeliveryManService {
    private DeliveryManRepository deliveryManRepository;
    private UserRepository userRepository;
    private ApprovedItemsRepository approvedItemsRepository;

    @Autowired
    DeliveryManService(DeliveryManRepository deliveryManRepository, UserRepository userRepository, ApprovedItemsRepository approvedItemsRepository) {
        this.deliveryManRepository = deliveryManRepository;
        this.userRepository = userRepository;
        this.approvedItemsRepository = approvedItemsRepository;
    }
    public List<DeliveryManModel> getDeliveryMenDetails(String username) {
        UserModel userModel = userRepository.getUserModelByUsername(username);
        if(userModel != null) {
            String pharmacyName = userModel.getPharmacyName();
            return deliveryManRepository.getDeliveryManModelsByPharmacyName(pharmacyName);
        }
        return new ArrayList<>();
    }

    public void createNewDeliveryMan(String username, DeliveryManModel deliveryManModel) {
        UserModel userModel1 = userRepository.getUserModelByUsername(username);
        if(userModel1 == null) {
            return;
        }

        UserModel userModel = new UserModel();
        userModel.setUsername(deliveryManModel.getUsername());
        userModel.setPassword("pharmacist"); // need to hash and save
        userModel.setRole(4);
        userModel.setLastAccessed(12);
        userModel.setEmail(deliveryManModel.getEmail());
        userModel.setPharmacyName(userModel1.getPharmacyName());
        userModel.setBranchId(1);
        userModel.setMobileNumber(deliveryManModel.getMobileNumber());
        userModel.setHaveAccessTo("[12]");
        userModel.setSubscriptionPack(userModel1.getSubscriptionPack());
        userModel.setDateOfSubscription(userModel1.getDateOfSubscription());

        userRepository.save(userModel);

        deliveryManRepository.save(deliveryManModel);
    }

    public List<ApprovedItemsModel> getApprovedItems(String username) {
        UserModel userModel = userRepository.getUserModelByUsername(username);
        if(userModel != null) {
            String pharmacyName = userModel.getPharmacyName();
            return approvedItemsRepository.getApprovedItemsModelsByPharmacyName(pharmacyName);
        }
        return new ArrayList<>();
    }

    public void PickupOrder(String username, ApprovedItemsModel approvedItemsModel) {
        approvedItemsRepository.assignDeliveryManForOrder(approvedItemsModel.getUsername(), username, approvedItemsModel.getMedName(), approvedItemsModel.getPharmacyName());
    }

    public List<ApprovedItemsModel> getDeliveryOrders(String username) {
        return approvedItemsRepository.getApprovedItemsModelsByDeliveryMan(username);
    }
}
