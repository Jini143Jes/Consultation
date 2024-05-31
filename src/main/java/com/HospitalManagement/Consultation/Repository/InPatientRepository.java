package com.HospitalManagement.Consultation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HospitalManagement.Consultation.Entity.InPatient;

public interface InPatientRepository extends JpaRepository<InPatient, Long> {
}