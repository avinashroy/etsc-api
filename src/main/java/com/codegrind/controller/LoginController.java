package com.codegrind.controller;

import com.codegrind.exceptions.AuthenticationException;
import com.codegrind.model.EmpInfo;
import com.codegrind.model.EmpLoginInfo;
import com.codegrind.repository.EmpInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class LoginController {

    @Autowired
    private EmpInfoRepo empInfoRepo;

    @PostMapping(path = "/employees/login", consumes = "application/json", produces = "application/json")
    public Optional<EmpInfo> loginAuthentication(@RequestBody EmpLoginInfo empInfo) throws AuthenticationException {
        Optional<EmpInfo> empInfoOptional = empInfoRepo.findById(empInfo.getEmpId());

        if (empInfoOptional.isPresent() && empInfoOptional.get().getEmpPassword().equals(empInfo.getEmpPassword()))
            return empInfoRepo.findById(empInfo.getEmpId());

        throw new AuthenticationException("Wrong Id or Password");
    }
}
