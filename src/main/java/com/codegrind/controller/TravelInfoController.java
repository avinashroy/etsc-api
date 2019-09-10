package com.codegrind.controller;

import com.codegrind.model.TravelInfo;
import com.codegrind.repository.TravelInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TravelInfoController {

    @Autowired
    private TravelInfoRepo travelInfoRepo;

    @GetMapping("travel/{empId}")
    public Optional<TravelInfo> getTravelInfoByEmpId(@PathVariable("empId") String empId) {

        return travelInfoRepo.findById(empId);
    }

    @GetMapping("travel/{travelId}")
    public Optional<TravelInfo> getTravelInfoById(@PathVariable("travelId") String travelId) {

        return travelInfoRepo.findById(travelId);
    }

    @PostMapping(path = "travel", consumes = "application/json", produces = "application/json")
    public ResponseEntity<TravelInfo> setTravelInfo(@RequestBody TravelInfo travelInfo) {

        travelInfoRepo.save(travelInfo);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "travel/{travelId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<TravelInfo> updateTravelInfo(@RequestBody TravelInfo travelInfo, @PathVariable("travelId") String travelId) {

        Optional<TravelInfo> travelInfoOptional = travelInfoRepo.findById(travelId);

        if(!travelInfoOptional.isPresent())
            return ResponseEntity.notFound().build();

        travelInfo.setTravelId(travelId);
        travelInfoRepo.save(travelInfo);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("travel/{travelId}")
    public ResponseEntity<TravelInfo> deleteTravelInfoById(@PathVariable("travelId") String travelId) {

        Optional<TravelInfo> travelInfoOptional = travelInfoRepo.findById(travelId);

        if(!travelInfoOptional.isPresent())
            return ResponseEntity.notFound().build();

        travelInfoRepo.deleteById(travelId);
        return ResponseEntity.noContent().build();
    }
}
