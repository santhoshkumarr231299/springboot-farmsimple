package com.farmsimple.repository;

import com.farmsimple.model.PharmacistModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PharmacistRepository extends JpaRepository<PharmacistModel, String> {
    List<PharmacistModel> getAllByPharmacyName(String pharmacyName);
}
