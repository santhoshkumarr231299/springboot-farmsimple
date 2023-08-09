package com.farmsimple.controller;

import com.farmsimple.model.MedicineModel;
import com.farmsimple.service.MedicineService;
import com.farmsimple.utils.JsonResponse;
import com.farmsimple.utils.ValidationUtil;
import com.farmsimple.utils.Validators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@ResponseBody
public class MedicineController {
    private JsonResponse jsonResponse;
    private MedicineService medicineService;
    private ValidationUtil validationUtil;

    @Autowired
    MedicineController(MedicineService medicineService, JsonResponse jsonResponse, ValidationUtil validationUtil) {
        this.jsonResponse = jsonResponse;
        this.medicineService = medicineService;
        this.validationUtil = validationUtil;
    }

    @RequestMapping(value = "/get-medicines", method = RequestMethod.GET)
    public ResponseEntity getAllActiveMedicines() {
        return jsonResponse.createJsonResponseSuccess(medicineService.getAllActiveMedicines(1, ""), "Got medicines successfully");
    }

    @RequestMapping(value = "/post-medicine", method = RequestMethod.POST)
    public ResponseEntity createNewMedicine(@RequestBody MedicineModel medicineModel) {
        String validationMessage = "";
        List<Validators> validatorsList = Arrays.asList(Validators.MEDICINE_NAME, Validators.MANUFACTURER_NAME, Validators.PHARMACY_NAME, Validators.USERNAME);
        if(!(validationMessage = validationUtil.validateMedicineModel(medicineModel, validatorsList)).equals("")) {
            return jsonResponse.createJsonResponseFailure(null, validationMessage);
        }
        medicineModel = medicineService.createNewMedicine(medicineService.createNewMedicine(medicineModel));
        if(medicineModel != null) {
            return jsonResponse.createJsonResponseSuccess(null, "Medicine Created Successfully");
        } else {
            return jsonResponse.createJsonResponseSuccess(null, "Failed to create medicine");
        }
    }

    @RequestMapping(value = "/get-search-medicines", method = RequestMethod.GET)
    public ResponseEntity getSearchMedicines(@RequestParam(name = "search") String search) {
        // getting purchase page medicines
        return jsonResponse.createJsonResponseSuccess(medicineService.getSearchMedicines(search), "Got medicines successfully");
    }
}
