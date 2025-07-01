package com.example.patientms.Service;

import com.example.patientms.Data.Patient;
import com.example.patientms.Data.PatientRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient createPatient(Patient patient)
    {
        return patientRepository.save(patient);
    }

    public Patient getPatientById(int patient_id)
    {
        Optional<Patient> patient=patientRepository.findById(patient_id);
        return patient.orElse(null);
    }

    public Patient updatePatient(Patient patient)
    {
        return patientRepository.save(patient);
    }

    public void deletePatientById(int patient_id)
    {
        patientRepository.deleteById(patient_id);
    }


    public Patient updateMedicalHistoryById(int patient_id, String medical_history){
        Patient patient= patientRepository.findById(patient_id).orElse(null);
        if(patient==null){
            return null;
        }
        patient.setMedical_history(medical_history);
        return patientRepository.save(patient);
    }
}
