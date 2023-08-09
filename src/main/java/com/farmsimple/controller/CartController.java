package com.farmsimple.controller;

import com.farmsimple.model.CartItemsModel;
import com.farmsimple.service.CartService;
import com.farmsimple.utils.JsonResponse;
import com.farmsimple.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
public class CartController {
    private JsonResponse jsonResponse;
    private CartService cartService;
    private ValidationUtil validationUtil;

    @Autowired
    CartController(JsonResponse jsonResponse, CartService cartService, ValidationUtil validationUtil) {
        this.jsonResponse = jsonResponse;
        this.cartService = cartService;
        this.validationUtil = validationUtil;
    }

    @RequestMapping(value = "/get-cart-items", method = RequestMethod.GET)
    public ResponseEntity getCartItems() {
        String username = ""; //get username from session
        return jsonResponse.createJsonResponseSuccess(cartService.getCartItems(username), "Got the Cart Items");
    }

    @RequestMapping(value = "/get-cart-items-count", method = RequestMethod.GET)
    public ResponseEntity getCartItemsCount() {
        String username = ""; //get username from session
        return jsonResponse.createJsonResponseSuccess(cartService.getCartItemsCount(username), "Got the Cart Items Count");
    }

    @RequestMapping(value = "/update-cart-items", method = RequestMethod.POST)
    public ResponseEntity updateCartItemQuantity(@RequestBody CartItemsModel cartItemsModel) {
        if(cartItemsModel.getUsername() == null || "".equals(cartItemsModel.getUsername())) {
            return jsonResponse.createJsonResponseFailure(null, "Missing required fields");
        }
        if(cartItemsModel.getQuantity() == 0) {
            jsonResponse.createJsonResponseFailure(null, "Quantity should be zero");
        }
        cartService.updateCartItemQuantity(cartItemsModel);
        return jsonResponse.createJsonResponseSuccess(null, "Quantity updated");
    }

    @RequestMapping(value = "/delete-cart-items", method = RequestMethod.POST)
    public ResponseEntity deleteCartItem(@RequestBody CartItemsModel cartItemsModel) {
        if(cartItemsModel.getUsername() == null || "".equals(cartItemsModel.getUsername())) {
            return jsonResponse.createJsonResponseFailure(null, "Missing required fields");
        }
        cartService.deleteCartItem(cartItemsModel);
        return jsonResponse.createJsonResponseSuccess(null, "Item deleted successfully");
    }

    @RequestMapping(value = "/add-to-cart", method = RequestMethod.POST)
    public ResponseEntity addItemToCart(@RequestBody CartItemsModel cartItemsModel) {
        if(cartItemsModel.getMedName() != null && "".equals(validationUtil.validateMedicineName(cartItemsModel.getMedName()))) {
            String username = ""; //get username from session
            cartItemsModel.setUsername(username);
            cartService.addToCart(cartItemsModel);
            return jsonResponse.createJsonResponseSuccess(null, "Item added to cart");
        }
        return jsonResponse.createJsonResponseFailure(null, "Missing required fields");
    }
}
