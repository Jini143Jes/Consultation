package com.HospitalManagement.Consultation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HospitalManagement.Consultation.Entity.OutPatient;
import com.HospitalManagement.Consultation.Service.OutPatientService;

@RestController
@RequestMapping("/api/outpatients")
public class OutPatientController {
	 @Autowired
	    private OutPatientService outPatientService;

	 @GetMapping
	    public List<OutPatient> getAllOutPatients() {
	        return outPatientService.getAllOutPatients();
	    }

	    @GetMapping("/{id}")
	    public OutPatient getOutpatientById(@PathVariable Long id) {
	        return outPatientService.getOutPatientById(id);
	    }

	    @PostMapping
	    public OutPatient createOutpatient(@RequestBody OutPatient outPatient) {
	        return outPatientService.saveOutPatient(outPatient);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteOutPatient(@PathVariable Long id) {
	        outPatientService.deleteOutPatient(id);
	    }


}
