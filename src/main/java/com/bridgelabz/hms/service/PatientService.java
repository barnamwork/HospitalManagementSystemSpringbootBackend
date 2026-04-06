package com.bridgelabz.hms.service;

import com.bridgelabz.hms.entity.Patient;
import com.bridgelabz.hms.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public Patient updatePatient(Long id, Patient updatedPatient) {
        Patient existing = patientRepository.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(updatedPatient.getName());
            existing.setAge(updatedPatient.getAge());
            existing.setDisease(updatedPatient.getDisease());
            return patientRepository.save(existing);
        }

        return null;
    }

    public String deletePatient(Long id) {
        patientRepository.deleteById(id);
        return "Patient deleted";
    }
}