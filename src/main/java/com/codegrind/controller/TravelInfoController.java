package com.codegrind.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codegrind.model.TravelInfo;
import com.codegrind.repository.TravelInfoRepo;

@RestController
public class TravelInfoController {

    @Autowired
    private TravelInfoRepo travelInfoRepo;
    
    @GetMapping("employees/{empId}/travels")
    public Optional<List<TravelInfo>> getTravelInfoByEmployeeId(@PathVariable("empId") String empId) {

        return travelInfoRepo.findByEmpId(empId);
    }

    @GetMapping("employees/{empId}/travels/{travelId}")
    public Optional<TravelInfo> getTravelInfoById(@PathVariable("empId") String empId, @PathVariable("travelId") String travelId) {

        return travelInfoRepo.findById(travelId);
    }

    @PostMapping(path = "employees/{empId}/travels", consumes = "application/json", produces = "application/json")
    public ResponseEntity<TravelInfo> setTravelInfo(@PathVariable("empId") String empId, @RequestBody TravelInfo travelInfo) {

    	travelInfo.setEmpId(empId);
        travelInfoRepo.save(travelInfo);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "employees/{empId}/travels/{travelId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<TravelInfo> updateTravelInfo(@RequestBody TravelInfo travelInfo, @PathVariable("empId") String empId, @PathVariable("travelId") String travelId) {

        Optional<TravelInfo> travelInfoOptional = travelInfoRepo.findById(travelId);

        if(!travelInfoOptional.isPresent())
            return ResponseEntity.notFound().build();

        travelInfo.setTravelId(travelId);
        travelInfoRepo.save(travelInfo);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("employees/{empId}/travels/{travelId}")
    public ResponseEntity<TravelInfo> deleteTravelInfoById(@PathVariable("empId") String empId, @PathVariable("travelId") String travelId) {

        Optional<TravelInfo> travelInfoOptional = travelInfoRepo.findById(travelId);

        if(!travelInfoOptional.isPresent())
            return ResponseEntity.notFound().build();

        travelInfoRepo.deleteById(travelId);
        return ResponseEntity.noContent().build();
    }
}
