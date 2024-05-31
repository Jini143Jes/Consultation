package com.HospitalManagement.Consultation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HospitalManagement.Consultation.Entity.Patient;
import com.HospitalManagement.Consultation.Repository.PatientRepository;

@Service

public class PatientService {
	@Autowired
    private PatientRepository patientRepository;

    public void registerPatient(Patient patient) {
        // Perform validation and save the patient
        patientRepository.save(patient);
    }

    public boolean loginPatient(String username, String password) {
        Patient patient = patientRepository.findByUsername(username);
        return patient != null && patient.getPassword().equals(password);
    }

}
