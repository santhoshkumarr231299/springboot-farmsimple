package com.farmsimple.controller;

import com.farmsimple.model.ApprovedItemsModel;
import com.farmsimple.model.CartItemsModel;
import com.farmsimple.model.PharmacistModel;
import com.farmsimple.service.CartService;
import com.farmsimple.service.LoginService;
import com.farmsimple.service.PharmacistService;
import com.farmsimple.utils.JsonResponse;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
public class PharmacistController {
    private JsonResponse jsonResponse;
    private PharmacistService pharmacistService;
    private CartService cartService;

    @Autowired
    PharmacistController(JsonResponse jsonResponse, PharmacistService pharmacistService, CartService cartService) {
        this.jsonResponse = jsonResponse;
        this.pharmacistService = pharmacistService;
        this.cartService = cartService;
    }

    @GetMapping("/get-pharmacists-details")
    public ResponseEntity getPharmacistDetails() {
        String username = ""; //get username from session
        return jsonResponse.createJsonResponseSuccess(pharmacistService.getPharmacistDetails(username), "Got Pharmacists");
    }

    @PostMapping("/post-pharmacist-details")
    public ResponseEntity createNewPharmacist(@RequestBody PharmacistModel pharmacistModel) {
        //validations
        String username = ""; //get username from session
        pharmacistService.createNewPharmacist(username, pharmacistModel);
        return jsonResponse.createJsonResponseSuccess(null, "Pharmcist created successfully");
    }

    // is ordered - 0 -> not bought by the customer
    // is ordered - 1 -> bought by the customer and waiting for pharmacist approval
    // is ordered - 2 -> declined by pharmacist

    @PostMapping("/approve-order")
    public ResponseEntity approveOrder(@RequestBody ApprovedItemsModel approvedItemsModel) {
        String username = ""; //get username from session
        CartItemsModel cartItemsModel = cartService.getOrderedCartItemOfUserById(username, approvedItemsModel.getMedName(), approvedItemsModel.getId());
        pharmacistService.approveOrder(cartItemsModel);
        cartService.deleteCartItem(username, approvedItemsModel.getId(), approvedItemsModel.getMedName());
        return jsonResponse.createJsonResponseSuccess(null, "Order approved successfully");
    }

    @PostMapping("/decline-orders")
    public ResponseEntity declineOrders(@RequestBody List<ApprovedItemsModel> approvedItemsModelList) {
        String username = ""; //get username from session
        approvedItemsModelList.forEach(approvedItemsModel -> cartService.declineOrder(username, approvedItemsModel.getId(), approvedItemsModel.getMedName()));
        return jsonResponse.createJsonResponseSuccess(null, "Order declined successfully");
    }

    @GetMapping("/get-ordered-items-for-approval")
    public ResponseEntity getOrderedItemsForApproval() {
        String username = ""; //get username from session
        List<CartItemsModel> cartItemsModelList = cartService.getOrderedItemsForApproval(username);
        return jsonResponse.createJsonResponseSuccess(cartItemsModelList, "Got the cart items for approval");
    }
}
