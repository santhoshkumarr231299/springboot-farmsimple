package com.farmsimple.service;

import com.farmsimple.model.InvoicesModel;
import com.farmsimple.model.UserModel;
import com.farmsimple.repository.InvoiceRepository;
import com.farmsimple.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceService {
    private InvoiceRepository invoiceRepository;
    private UserRepository userRepository;

    @Autowired
    InvoiceService(InvoiceRepository invoiceRepository, UserRepository userRepository) {
        this.invoiceRepository = invoiceRepository;
        this.userRepository = userRepository;
    }
    public List<InvoicesModel> getAllInvoices(String username) {
        UserModel userModel = userRepository.getUserModelByUsername(username);
        String pharmacyName = "";
        if (userModel != null) {
            pharmacyName = userModel.getPharmacyName();
            return invoiceRepository.findAllByPharmacyName(pharmacyName);
        }
        return new ArrayList<>();
    }
    public void createInvoice(InvoicesModel invoicesModel) {
        invoiceRepository.save(invoicesModel);
    }
}
