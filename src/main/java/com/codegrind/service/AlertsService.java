package com.codegrind.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegrind.model.Alerts;
import com.codegrind.model.EmpInfo;
import com.codegrind.repository.AlertsRepo;
import com.codegrind.repository.EmpInfoRepo;

@Service
public class AlertsService {

	@Autowired
	EmpInfoRepo empInfoRepo;
	@Autowired
	AlertsRepo alertsRepo;
	
	public List<Alerts> findAlertOfEmployee(String empId) {
		
		List<Alerts> alertList = new ArrayList<>();
		List<EmpInfo> empList = empInfoRepo.getAlert(empId, empId);
		empList.forEach((e) -> {
			alertList.addAll(alertsRepo.findByEmpId(e.getEmpId()));
		});
		return alertList;
	}
}
