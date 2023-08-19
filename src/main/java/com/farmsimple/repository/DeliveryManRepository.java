package com.farmsimple.repository;

import com.farmsimple.model.DeliveryManModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryManRepository extends JpaRepository<DeliveryManModel, String> {
    List<DeliveryManModel> getDeliveryManModelsByPharmacyName(String username);
    int countAllByPharmacyName(String pharmacyName);
}
