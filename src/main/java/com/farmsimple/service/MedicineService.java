package com.farmsimple.service;

import com.farmsimple.model.MedicineModel;
import com.farmsimple.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {
    private MedicineRepository medicineRepository;

    @Autowired
    MedicineService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }
    public List<MedicineModel> getAllActiveMedicines(int status, String pharmacyName) {
        return medicineRepository.findAllByStatusAndPharmacyName(status, pharmacyName);
    }
    public MedicineModel createNewMedicine(MedicineModel medicineModel) {
        if(medicineModel.getMedName() == null || medicineModel.getPharmacyName() == null) return null;
        medicineRepository.save(medicineModel);
        return medicineModel;
    }

    public List<MedicineModel> getSearchMedicines(String search) {
        return medicineRepository.findAllByMedNameLike(search);
    }
}
