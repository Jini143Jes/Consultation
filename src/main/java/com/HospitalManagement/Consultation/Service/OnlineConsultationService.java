package com.HospitalManagement.Consultation.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HospitalManagement.Consultation.Entity.Appointment;
import com.HospitalManagement.Consultation.Entity.OnlineConsultation;
import com.HospitalManagement.Consultation.Entity.Prescription;
import com.HospitalManagement.Consultation.Repository.OnlineConsultationRepository;

@Service
public class OnlineConsultationService {
	@Autowired
    private OnlineConsultationRepository onlineConsultationRepository;

    public List<OnlineConsultation> getAllConsultations() {
        return onlineConsultationRepository.findAll();
    }

    public OnlineConsultation getConsultationById(Long id) {
        return onlineConsultationRepository.findById(id).orElse(null);
    }

    public OnlineConsultation createConsultation(OnlineConsultation consultation) {
        return onlineConsultationRepository.save(consultation);
    }

    public OnlineConsultation updateConsultation(Long id, OnlineConsultation consultation) {
        OnlineConsultation existingConsultation = onlineConsultationRepository.findById(id).orElse(null);
        if (existingConsultation != null) {
            existingConsultation.setPatientName(consultation.getPatientName());
            existingConsultation.setDoctorName(consultation.getDoctorName());
            existingConsultation.setAppointments(consultation.getAppointments());
            existingConsultation.setPrescriptions(consultation.getPrescriptions());
            return onlineConsultationRepository.save(existingConsultation);
        }
        return null; // Handle consultation not found scenario
    }

    public OnlineConsultation createAppointment(Long consultationId, Appointment appointment) {
        OnlineConsultation consultation = onlineConsultationRepository.findById(consultationId).orElse(null);
        if (consultation != null) {
            consultation.getAppointments().add(appointment);
            return onlineConsultationRepository.save(consultation);
        }
        return null; // Handle consultation not found scenario
    }

    public OnlineConsultation createPrescription(Long consultationId, Prescription prescription) {
        OnlineConsultation consultation = onlineConsultationRepository.findById(consultationId).orElse(null);
        if (consultation != null) {
            consultation.getPrescriptions().add(prescription);
            return onlineConsultationRepository.save(consultation);
        }
        return null; // Handle consultation not found scenario
    }

    public void deleteConsultation(Long id) {
        onlineConsultationRepository.deleteById(id);
    }
}
