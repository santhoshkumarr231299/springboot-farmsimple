package com.farmsimple.repository;

import com.farmsimple.model.CartItemsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartsRepository extends JpaRepository<CartItemsModel, String> {
    List<CartItemsModel> findAllByUsername(String username);
    int countAllByUsername(String username);

    @Query("update CartItemsModel set quantity = :quantity where username = :username and id = :id")
    void updateQuantityByUsernameAndId(String username, int id, int quantity);
    void deleteCartItemsModelByUsernameAndId(String username, int id);
    boolean existsByUsernameAndIdAndMedNameAndIsOrdered(String username, int id, String medName, int isOrdered);
}
