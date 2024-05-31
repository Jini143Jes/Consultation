package com.HospitalManagement.Consultation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HospitalManagement.Consultation.Entity.OutPatient;
@Repository
public interface OutPatientRepository extends JpaRepository<OutPatient, Long> {
}
