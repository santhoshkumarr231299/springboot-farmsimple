package com.farmsimple.repository;

import com.farmsimple.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, String> {
    boolean existsByEmail(String email);
    boolean existsByPharmacyName(String pharmacyName);
    boolean existsByMobileNumber(String mobileNumber);

    @Query("update UserModel set lastAccessed = :lastAccessed where username = :username")
    boolean updateLastAccessedForUser(@Param("username") String username,@Param("lastAccessed") int lastAccessed);

    @Query("update UserModel set email = :email, mobileNumber = :mobileNumber, branchId = :branchId, pharmacyName = :pharmacyName where username = :username")
    void updateUserModelBySettings(@Param("username") String username, @Param("email") String email, @Param("mobileNumber") String mobileNumber, @Param("branchId") int branchId, @Param("pharmacyName") String pharmacyName);

    UserModel getUserModelByUsername(String username);

}
