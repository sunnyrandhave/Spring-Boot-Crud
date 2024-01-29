package com.org.project.clinic.controller;

import com.org.project.clinic.entities.Patient;
import com.org.project.clinic.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;


@RestController
@CrossOrigin                                   //Link of FrontEnd
public class PatientController {

    @Autowired
    private PatientService service;

    @GetMapping("/test")
    public String apiTest(){
        return "Get API Working Fine!";
    }

    @PostMapping("/patient/addpatient")          //Create Method
    public String addPatient(@RequestBody Patient patient) {
        service.addPatient(patient);
        return "Patient " + patient.getId() + " Added SuccessFully!";
//        return HttpStatus.OK;
    }
    @GetMapping("/patient/{name}")         //Read Method
    public Patient getPatientByName(@PathVariable String name){
        return service.getPatientByName(name);
    }


    @PutMapping("/patient/update")         //Update Method
    public String updatePatient(@RequestBody Patient patient){
        service.updatePatient(patient);
        return "Patient "+patient.getId()+" updated SuccessFully!";
    }

    @DeleteMapping("/patient/delete={id}")      //Delete Method
    public String deletePatientById(@PathVariable int id){
        service.deletePatientById(id);
        return "patient with Id "+id+" deleted!";
    }


}
