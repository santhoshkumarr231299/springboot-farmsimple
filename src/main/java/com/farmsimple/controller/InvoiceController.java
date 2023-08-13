package com.farmsimple.controller;

import com.farmsimple.model.InvoicesModel;
import com.farmsimple.service.InvoiceService;
import com.farmsimple.utils.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
public class InvoiceController {
    private JsonResponse jsonResponse;
    private InvoiceService invoiceService;

    @Autowired
    InvoiceController(JsonResponse jsonResponse,InvoiceService invoiceService) {
        this.jsonResponse = jsonResponse;
        this.invoiceService = invoiceService;
    }

    @GetMapping("/get-invoices")
    public ResponseEntity getAllInvoices() {
        String username = ""; //get username from session
        return jsonResponse.createJsonResponseSuccess(invoiceService.getAllInvoices(username), "Got Invoices");
    }

    @PostMapping("/post-invoice")
    public ResponseEntity createInvoice(@RequestBody InvoicesModel invoicesModel) {
        String username = ""; //get username from session
        String pharmacyName = ""; //get Pharmacy name from session
        invoiceService.createInvoice(invoicesModel);
        return jsonResponse.createJsonResponseSuccess(null, "Invoice created successfully");
    }
}
