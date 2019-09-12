package com.codegrind.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codegrind.model.Alerts;
import com.codegrind.model.EmpInfo;
import com.codegrind.repository.AlertsRepo;
import com.codegrind.service.AlertsService;

@RestController
public class AlertInfoController {

	@Autowired
	private AlertsRepo alertsRepo;

	@Autowired
	private AlertsService alertsService;

	@GetMapping("customers/{customerId}/alerts")
	public Iterable<Alerts> getAlerts(@PathVariable("customerId") String customerId) {
		return alertsService.findAlertOfEmployee(customerId);
	}

	@PutMapping(path = "customers/{customerId}/alerts/{alertId}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<EmpInfo> updateEmployeeByIdemp(@PathVariable("customerId") String customerId,
			@PathVariable("alertId") String alertId) {
		Optional<Alerts> alerts = alertsRepo.findById(alertId);
		
		if (!alerts.isPresent())
			return ResponseEntity.notFound().build();
		
		Alerts t = alerts.get();
		t.setAlertStatus("DONE");
		alertsRepo.save(t);

		return ResponseEntity.noContent().build();
	}
}
