package com.farmsimple.repository;

import com.farmsimple.model.InvoicesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoicesModel, Integer> {
    List<InvoicesModel> findAllByPharmacyName(String pharmacyName);
}
