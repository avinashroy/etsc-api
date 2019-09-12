package com.codegrind.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Alerts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String alertId;
	private String travelId;
	private String empId;
	private String alertText;
	private String alertStatus;
	public String getAlertId() {
		return alertId;
	}
	public void setAlertId(String alertId) {
		this.alertId = alertId;
	}
	public String getTravelId() {
		return travelId;
	}
	public void setTravelId(String travelId) {
		this.travelId = travelId;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getAlertText() {
		return alertText;
	}
	public void setAlertText(String alertText) {
		this.alertText = alertText;
	}
	public String getAlertStatus() {
		return alertStatus;
	}
	public void setAlertStatus(String alertStatus) {
		this.alertStatus = alertStatus;
	}
	
	
}
