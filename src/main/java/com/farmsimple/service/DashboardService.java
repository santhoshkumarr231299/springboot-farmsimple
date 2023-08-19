package com.farmsimple.service;

import com.farmsimple.model.DashboardModel;
import com.farmsimple.model.UserModel;
import com.farmsimple.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {
    private ManagerRepository managerRepository;
    private PharmacistRepository pharmacistRepository;
    private DeliveryManRepository deliveryManRepository;
    private MedicineRepository medicineRepository;
    private UserRepository userRepository;

    @Autowired
    DashboardService(ManagerRepository managerRepository, PharmacistRepository pharmacistRepository, DeliveryManRepository deliveryManRepository, MedicineRepository medicineRepository, UserRepository userRepository) {
        this.managerRepository = managerRepository;
        this.pharmacistRepository = pharmacistRepository;
        this.deliveryManRepository = deliveryManRepository;
        this.medicineRepository = medicineRepository;
        this.userRepository = userRepository;
    }

    public DashboardModel getDashboardDetails(String username) {
        UserModel userModel = userRepository.getUserModelByUsername(username);
        if(userModel != null) {
            String pharmacyName = userModel.getPharmacyName();

            DashboardModel dashboardModel = new DashboardModel();
            int managersCount = managerRepository.countAllByPharmacyName(pharmacyName);
            int pharmacistsCount = pharmacistRepository.countAllByPharmacyName(pharmacyName);
            int deliveryMenCount = deliveryManRepository.countAllByPharmacyName(pharmacyName);
            int medicinesCount = medicineRepository.countAllByPharmacyName(pharmacyName);

            dashboardModel.setManagersCount(managersCount);
            dashboardModel.setPharmacistsCount(pharmacistsCount);
            dashboardModel.setDeliveryMenCount(deliveryMenCount);
            dashboardModel.setMedicinesCount(medicinesCount);

            return dashboardModel;
        }
        return new DashboardModel();
    }


}
