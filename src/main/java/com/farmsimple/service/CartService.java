package com.farmsimple.service;

import com.farmsimple.model.CartItemsModel;
import com.farmsimple.model.UserModel;
import com.farmsimple.repository.CartsRepository;
import com.farmsimple.repository.MedicineRepository;
import com.farmsimple.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    private CartsRepository cartsRepository;
    private UserRepository userRepository;
    private MedicineRepository medicineRepository;

    @Autowired
    CartService(CartsRepository cartsRepository, UserRepository userRepository, MedicineRepository medicineRepository) {
        this.cartsRepository = cartsRepository;
        this.userRepository = userRepository;
        this.medicineRepository = medicineRepository;
    }
    public List<CartItemsModel> getCartItems(String username) {
        return cartsRepository.findAllByUsername(username);
    }
    public int getCartItemsCount(String username) {
        return cartsRepository.countAllByUsername(username);
    }
    public void updateCartItemQuantity(CartItemsModel cartItemsModel) {
        cartsRepository.updateQuantityByUsernameAndId(cartItemsModel.getUsername(), cartItemsModel.getId(), cartItemsModel.getQuantity());
    }
    public void deleteCartItem(CartItemsModel cartItemsModel) {
        cartsRepository.deleteCartItemsModelByUsernameAndId(cartItemsModel.getUsername(), cartItemsModel.getId());
    }
    public void addToCart(CartItemsModel cartItemsModel) {
        cartItemsModel.setPharmacyName(userRepository.getUserModelByUsername(cartItemsModel.getUsername()).getPharmacyName());
        cartItemsModel.setPrice(medicineRepository.getMedicineModelById(cartItemsModel.getId()).getMedRate());
        cartsRepository.save(cartItemsModel);
    }
    public CartItemsModel getOrderedCartItemOfUserById(String username, String medName, int id) {
        return cartsRepository.getCartItemsModelByUsernameAndIdAndMedNameAndIsOrdered(username, id, medName, 1);
    }
    public void deleteCartItem(String username, int id, String medName) {
        cartsRepository.deleteCartItemsModelByUsernameAndIdAndMedName(username, id, medName);
    }
    public void declineOrder(String username, int id, String medName) {
//        cartsRepository.updateCartItemsModelByUsernameAndIdAndMedNameAndIsOrdered(username, id, medName, 1);
    }
    public List<CartItemsModel> getOrderedItemsForApproval(String username) {
        UserModel userModel = userRepository.getUserModelByUsername(username);
        if(userModel != null) {
            return cartsRepository.getAllByPharmacyNameAndIsOrdered(userModel.getPharmacyName(), 1);
        }
        return new ArrayList<>();
    }
}
