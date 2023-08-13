package com.farmsimple.repository;

import com.farmsimple.model.ManagerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<ManagerModel, String> {
    List<ManagerModel> getAllByPharmacyName(String pharmacyName);
}
