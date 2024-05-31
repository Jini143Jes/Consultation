package com.HospitalManagement.Consultation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HospitalManagement.Consultation.Entity.OnlineConsultation;

@Repository
public interface OnlineConsultationRepository extends JpaRepository<OnlineConsultation, Long> {
}
