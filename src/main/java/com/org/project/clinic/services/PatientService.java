package com.org.project.clinic.services;

import com.org.project.clinic.entities.Patient;
import com.org.project.clinic.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository repository;


    public String addPatient(Patient patient) {
         repository.save(patient);
        return "patient Added to System  Successfully";
    }

    public Patient getPatient(int id) {
        return repository.findById(id).orElse(null);
    }

    public Patient getPatientByName(String name){
        return repository.findByName(name);
    }

    public String deletePatientById(int id){
        repository.deleteById(id);
       return "Patient with Id "+id+" Removed";
    }

    public Patient updatePatient(Patient patient){
        Patient existing =repository.findById(patient.getId()).orElse(null);
        existing.setId(patient.getId());
        existing.setName(patient.getName());
        existing.setPhoneNumber(patient.getPhoneNumber());
        existing.setDisease(patient.getDisease());
        return existing;
    }


    public void addMultiplePatients(List<Patient> patient) {
        repository.saveAll(patient);
    }
}
