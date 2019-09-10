package com.codegrind.controller;

import com.codegrind.model.EmpInfo;
import com.codegrind.repository.EmpInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EmpInfoController {

    @Autowired
    private EmpInfoRepo empInfoRepo;

    @GetMapping("employees")
    public Iterable<EmpInfo> getEmployees() {
        return empInfoRepo.findAll();
    }

    @GetMapping("employees/{id}")
    public Optional<EmpInfo> getEmployeeById(@PathVariable("id") String id) {
        return empInfoRepo.findById(id);
    }

    @PostMapping(path="employees", consumes="application/json", produces="application/json")
    public ResponseEntity<EmpInfo> setEmployee(@RequestBody EmpInfo empInfo) {
        empInfoRepo.save(empInfo);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(path="employees/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<EmpInfo> updateEmployeeById(@RequestBody EmpInfo empInfo, @PathVariable("id") String id) {
        Optional<EmpInfo> emp = empInfoRepo.findById(id);

        if(!emp.isPresent())
            return ResponseEntity.notFound().build();

        empInfo.setEmpId(id);
        empInfoRepo.save(empInfo);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("employees/{id}")
    public ResponseEntity<EmpInfo> deleteEmployeeById(@PathVariable("id") String id) {
        Optional<EmpInfo> emp = empInfoRepo.findById(id);

        if(!emp.isPresent())
            return ResponseEntity.notFound().build();

        empInfoRepo.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
