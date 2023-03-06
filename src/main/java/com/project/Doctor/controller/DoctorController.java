package com.project.Doctor.controller;

import com.project.Doctor.model.Doctor;
import com.project.Doctor.service.DoctorService;
import com.project.Doctor.util.Validation;
import jakarta.annotation.Nullable;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("api/v1/doctor")
public class DoctorController {
    @Autowired
    DoctorService service;
    @GetMapping("get")
    private List<Doctor> findAll(@Nullable @RequestParam Integer id, @Nullable @RequestParam String exp){
        return service.findAll(id, exp);
    }

    @PostMapping("add")
    private ResponseEntity<String> save(@RequestBody String doctor){
        List<String> errors= Validation.validate(doctor);
        if(errors.size() == 0) {
            service.save(new JSONObject(doctor));
            return new ResponseEntity<String>("Doctor Added Successfully!!", HttpStatus.CREATED);
        }else {
            return new ResponseEntity<String>("Plz enter following mandatory parameters!! " + errors.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete/")
    private ResponseEntity<String> deleteById(@RequestParam Integer id){
        if(service.deleteById(id)){
            return new ResponseEntity<>("No such Doctor found", HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>("Doctor Delete Successfully!!", HttpStatus.OK);
        }
    }

    @PutMapping("update")
    private ResponseEntity<String> update(@RequestBody Doctor doctor){
        if(service.update(doctor)){
            return new ResponseEntity<>("No such Doctor found", HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>("Doctor Updated Successfully!!", HttpStatus.OK);
        }
    }
}
