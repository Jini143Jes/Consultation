package com.HospitalManagement.Consultation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HospitalManagement.Consultation.Entity.Patient;
import com.HospitalManagement.Consultation.Service.PatientService;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
	 @Autowired
	    private PatientService patientService;

	    @PostMapping("/register")
	    public ResponseEntity<String> register(@RequestBody Patient patient) {
	        // Perform validation if needed
	        patientService.registerPatient(patient);
	        return ResponseEntity.ok("Patient registered successfully");
	    }

	    @PostMapping("/login")
	    public ResponseEntity<String> login(@RequestBody Patient patient) {
	        String username = patient.getUsername();
	        String password = patient.getPassword();
	        
	        if (patientService.loginPatient(username, password)) {
	            return ResponseEntity.ok("Login successful");
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
	        }
	    }
}
