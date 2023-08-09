package com.farmsimple.service;

import com.farmsimple.model.CartItemsModel;
import com.farmsimple.repository.CartsRepository;
import com.farmsimple.repository.MedicineRepository;
import com.farmsimple.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ResponseBody
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
}
