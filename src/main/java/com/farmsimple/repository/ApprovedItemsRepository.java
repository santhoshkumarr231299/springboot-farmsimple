package com.farmsimple.repository;

import com.farmsimple.model.ApprovedItemsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApprovedItemsRepository extends JpaRepository<ApprovedItemsModel, Integer> {
    List<ApprovedItemsModel> getApprovedItemsModelsByPharmacyName(String pharmacyName);
    List<ApprovedItemsModel> getApprovedItemsModelsByDeliveryMan(String deliveryMan);

    @Query("update ApprovedItemsModel set deliveryMan = :deliveryMan where username = :username and medName = :medName and pharmacyName = :pharmacyName")
    void assignDeliveryManForOrder(String username, String deliveryMan, String medName, String pharmacyName);
}
