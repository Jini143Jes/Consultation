package com.HospitalManagement.Consultation.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HospitalManagement.Consultation.Entity.OutPatient;
import com.HospitalManagement.Consultation.Repository.OutPatientRepository;

@Service
public class OutPatientService {
	@Autowired
    private OutPatientRepository outPatientRepository;

    public List<OutPatient> getAllOutPatients() {
        return outPatientRepository.findAll();
    }

    public OutPatient getOutPatientById(Long id) {
        return outPatientRepository.findById(id).orElse(null);
    }

    public OutPatient saveOutPatient(OutPatient outPatient) {
        return outPatientRepository.save(outPatient);
    }

    public void deleteOutPatient(Long id) {
        outPatientRepository.deleteById(id);
    }

}
