package com.bridgelabz.hms.repository;

import com.bridgelabz.hms.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}