package com.farmsimple.controller;

import com.farmsimple.model.ApprovedItemsModel;
import com.farmsimple.model.DeliveryManModel;
import com.farmsimple.service.DeliveryManService;
import com.farmsimple.utils.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
public class DeliveryManController {
    private JsonResponse jsonResponse;
    private DeliveryManService deliveryManService;

    @Autowired
    DeliveryManController(JsonResponse jsonResponse, DeliveryManService deliveryManService) {
        this.jsonResponse = jsonResponse;
        this.deliveryManService = deliveryManService;
    }
    @GetMapping("/get-delivery-men-details")
    public ResponseEntity getDeliveryMenDetails() {
        String username = ""; //get username from session
        List<DeliveryManModel> deliveryManModelList = deliveryManService.getDeliveryMenDetails(username);
        return jsonResponse.createJsonResponseSuccess(deliveryManModelList, "Got the Delivery Man Details");
    }

    @PostMapping("/post-delivery-man-details")
    public ResponseEntity createNewDeliveryMan(@RequestBody DeliveryManModel deliveryManModel) {
        String username = ""; // get username from session
        deliveryManService.createNewDeliveryMan(username, deliveryManModel);
        return jsonResponse.createJsonResponseSuccess(null, "New Delivery Man created successfully");
    }

    @GetMapping("/get-approved-items")
    public ResponseEntity getApprovedItems() {
        String username = "";
        List<ApprovedItemsModel> approvedItemsModelList = deliveryManService.getApprovedItems(username);
        return jsonResponse.createJsonResponseSuccess(approvedItemsModelList, "Got the approved Items");
    }

    @PostMapping("/pickup-order")
    public ResponseEntity pickupOrder(@RequestBody ApprovedItemsModel approvedItemsModel) {
        String username = ""; //get username from session
        deliveryManService.PickupOrder(username, approvedItemsModel);
        return jsonResponse.createJsonResponseSuccess(null, "Order picked up");
    }

    @GetMapping("/get-delivery-orders")
    public ResponseEntity getDeliveryOrders() {
        String username = ""; // get username from session
        List<ApprovedItemsModel> approvedItemsModelList = deliveryManService.getDeliveryOrders(username);
        return jsonResponse.createJsonResponseSuccess(approvedItemsModelList, "Got the delivery orders");
    }
}
