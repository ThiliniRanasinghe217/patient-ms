package com.example.patientms.Controller;

import com.example.patientms.Data.Patient;
import com.example.patientms.Service.PatientService;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class PatientController {
private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping(path = "/patients")
    public Patient createPatient(@RequestBody Patient patient){
        return patientService.createPatient(patient);
    }

    @GetMapping(path = "/patients/{patient_id}")
    public Patient getPatientById(@PathVariable int patient_id) {
        return patientService.getPatientById(patient_id);
    }

    @PutMapping(path = "/patients")
    public Patient updatePatient(@RequestBody Patient patient){
        return patientService.updatePatient(patient);
    }

    @DeleteMapping(path = "/patients/{patient_id}")
    public void deletePatientById(@PathVariable int patient_id){
        patientService.deletePatientById(patient_id);
    }
    @PatchMapping(path = "/patients/{patient_id}")
    public Patient updateMedicalHistoryById(@PathVariable int patient_id,@RequestBody Map<String,String> requestBody){
        String medical_history = requestBody.get("medical_history");
        return patientService.updateMedicalHistoryById(patient_id,medical_history);
    }
}
