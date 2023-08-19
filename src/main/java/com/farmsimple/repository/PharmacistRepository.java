package com.farmsimple.repository;

import com.farmsimple.model.PharmacistModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PharmacistRepository extends JpaRepository<PharmacistModel, String> {
    List<PharmacistModel> getAllByPharmacyName(String pharmacyName);
    int countAllByPharmacyName(String pharmacyName);
}
