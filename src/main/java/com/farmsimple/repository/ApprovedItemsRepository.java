package com.farmsimple.repository;

import com.farmsimple.model.ApprovedItemsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprovedItemsRepository extends JpaRepository<ApprovedItemsModel, Integer> {
}
