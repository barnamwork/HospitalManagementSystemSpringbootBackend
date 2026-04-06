package com.bridgelabz.hms.service;

import com.bridgelabz.hms.entity.Patient;
import com.bridgelabz.hms.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        return patient.orElse(null);
    }

    public Patient updatePatient(Long id, Patient updatedPatient) {
        Optional<Patient> existing = patientRepository.findById(id);

        if (existing.isPresent()) {
            Patient patient = existing.get();
            patient.setName(updatedPatient.getName());
            patient.setAge(updatedPatient.getAge());
            patient.setGender(updatedPatient.getGender());
            patient.setDisease(updatedPatient.getDisease());
            patient.setAddress(updatedPatient.getAddress());
            patient.setPhoneNumber(updatedPatient.getPhoneNumber());

            return patientRepository.save(patient);
        }

        return null;
    }

    public String deletePatient(Long id) {
        patientRepository.deleteById(id);
        return "Patient deleted successfully";
    }
}