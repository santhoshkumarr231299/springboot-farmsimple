package com.farmsimple.controller;

import com.farmsimple.service.PaymentService;
import com.farmsimple.utils.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ResponseBody
@RequestMapping("/payment")
public class PaymentController {
    private JsonResponse jsonResponse;
    private PaymentService paymentService;

    @Autowired
    PaymentController(JsonResponse jsonResponse, PaymentService paymentService) {
        this.jsonResponse = jsonResponse;
        this.paymentService = paymentService;
    }

    @PostMapping("/orders")
    public ResponseEntity purchaseCartItems(@RequestBody Object object) {
        return null;
    }

    @PostMapping("/success")
    public ResponseEntity paymentDone(@RequestBody Object object) {
        return null;
    }

    @PostMapping("/subscription")
    public ResponseEntity p(@RequestBody Object object) {
        return null;
    }
}
