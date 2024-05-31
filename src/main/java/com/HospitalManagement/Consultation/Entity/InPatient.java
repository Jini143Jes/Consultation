package com.HospitalManagement.Consultation.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inpatients")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InPatient {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    private String admissionDate;
	    private String dischargeDate;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAdmissionDate() {
			return admissionDate;
		}
		public void setAdmissionDate(String admissionDate) {
			this.admissionDate = admissionDate;
		}
		public String getDischargeDate() {
			return dischargeDate;
		}
		public void setDischargeDate(String dischargeDate) {
			this.dischargeDate = dischargeDate;
		}


}
