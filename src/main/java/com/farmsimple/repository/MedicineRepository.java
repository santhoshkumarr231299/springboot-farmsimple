package com.farmsimple.repository;

import com.farmsimple.model.MedicineModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineRepository extends JpaRepository<MedicineModel, Integer> {
    List<MedicineModel> findAllByStatusAndPharmacyName(int status, String pharmacyName);
    List<MedicineModel> findAllByMedNameLike(String search);
    MedicineModel getMedicineModelById(int id);
    int countAllByPharmacyName(String pharmacyName);
}
