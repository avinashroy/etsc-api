package com.codegrind.controller;

import com.codegrind.model.GpsInfo;
import com.codegrind.repository.GpsInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class GpsInfoController {

    @Autowired
    private GpsInfoRepo gpsInfoRepo;

    @GetMapping("gps/{infoId}")
    public Optional<GpsInfo> getGpsInfoByTravelId(@PathVariable("infoId") String infoId) {

        return gpsInfoRepo.findById(infoId);
    }

    @PostMapping(path="gps", consumes="application/json", produces="application/json")
    public ResponseEntity<GpsInfo> setGpsInfo(@RequestBody GpsInfo gpsInfo) {
        gpsInfoRepo.save(gpsInfo);

        return ResponseEntity.noContent().build();
    }
}
