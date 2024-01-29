package com.org.project.clinic.repositories;

import com.org.project.clinic.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
    Patient findByName(String name);
}
