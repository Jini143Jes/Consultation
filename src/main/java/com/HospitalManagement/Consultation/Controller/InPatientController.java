package com.HospitalManagement.Consultation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HospitalManagement.Consultation.Entity.InPatient;
import com.HospitalManagement.Consultation.Service.InPatientService;
@RestController
@RequestMapping("/api/inpatients")
public class InPatientController {

    @Autowired
    private InPatientService inPatientService;

    @GetMapping
    public ResponseEntity<List<InPatient>> getAllInpatients() {
        List<InPatient> inpatients = inPatientService.getAllInpatients();
        return new ResponseEntity<>(inpatients, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<InPatient> getInpatientById(@PathVariable Long id) {
        InPatient inpatient = inPatientService.getInpatientById(id);
        if (inpatient != null) {
            return new ResponseEntity<>(inpatient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<InPatient> createInpatient(@RequestBody InPatient inpatient) {
        InPatient createdInpatient = inPatientService.saveInpatient(inpatient);
        return new ResponseEntity<>(createdInpatient, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInpatient(@PathVariable Long id) {
        InPatient inpatient = inPatientService.getInpatientById(id);
        if (inpatient != null) {
        	inPatientService.deleteInpatient(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
