package com.HospitalManagement.Consultation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HospitalManagement.Consultation.Entity.Appointment;
import com.HospitalManagement.Consultation.Entity.OnlineConsultation;
import com.HospitalManagement.Consultation.Entity.Patient;
import com.HospitalManagement.Consultation.Entity.Prescription;
import com.HospitalManagement.Consultation.Service.OnlineConsultationService;
import com.HospitalManagement.Consultation.Service.PatientService;

@RestController
@RequestMapping("/api/consultation")
public class OnlineConsultationController {
	@Autowired
    private OnlineConsultationService onlineConsultationService;

    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<OnlineConsultation> getAllConsultations() {
        return onlineConsultationService.getAllConsultations();
    }

    @GetMapping("/{id}")
    public OnlineConsultation getConsultationById(@PathVariable Long id) {
        return onlineConsultationService.getConsultationById(id);
    }

    @PostMapping
    public OnlineConsultation createConsultation(@RequestBody OnlineConsultation consultation) {
        return onlineConsultationService.createConsultation(consultation);
    }

    @PostMapping("/{consultationId}/appointments")
    public OnlineConsultation createAppointment(
            @PathVariable("consultationId") Long consultationId,
            @RequestBody Appointment appointment) {
        return onlineConsultationService.createAppointment(consultationId, appointment);
    }

    @PostMapping("/{consultationId}/prescriptions")
    public OnlineConsultation createPrescription(
            @PathVariable("consultationId") Long consultationId,
            @RequestBody Prescription prescription) {
        return onlineConsultationService.createPrescription(consultationId, prescription);
    }

    @PutMapping("/{id}")
    public OnlineConsultation updateConsultation(@PathVariable Long id, @RequestBody OnlineConsultation consultation) {
        return onlineConsultationService.updateConsultation(id, consultation);
    }

    @DeleteMapping("/{id}")
    public void deleteConsultation(@PathVariable Long id) {
        onlineConsultationService.deleteConsultation(id);
    }

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