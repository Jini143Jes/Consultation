package com.HospitalManagement.Consultation.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HospitalManagement.Consultation.Entity.InPatient;
import com.HospitalManagement.Consultation.Repository.InPatientRepository;

import lombok.Builder;

@Service
@Builder
public class InPatientService {
	@Autowired
    private InPatientRepository inpatientRepository;

    public List<InPatient> getAllInpatients() {
        return inpatientRepository.findAll();
    }

    public InPatient getInpatientById(Long id) {
        return inpatientRepository.findById(id).orElse(null);
    }

    public InPatient saveInpatient(InPatient inpatient) {
        return inpatientRepository.save(inpatient);
    }

    public void deleteInpatient(Long id) {
        inpatientRepository.deleteById(id);
    }


}
