package com.codegrind.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "travel_info")
public class TravelInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String travelId;
	private String travelDescription;
	private String locStart;
	private String locEnd;
	private String travelMedium;
	private String travelStartDatetime;
	private String travelFinishDatetime;
	private String travelStatus;
	private String empId;

	public String getTravelId() {
		return travelId;
	}

	public void setTravelId(String travelId) {
		this.travelId = travelId;
	}

	public String getTravelDescription() {
		return travelDescription;
	}

	public void setTravelDescription(String travelDescription) {
		this.travelDescription = travelDescription;
	}

	public String getLocStart() {
		return locStart;
	}

	public void setLocStart(String locStart) {
		this.locStart = locStart;
	}

	public String getLocEnd() {
		return locEnd;
	}

	public void setLocEnd(String locEnd) {
		this.locEnd = locEnd;
	}

	public String getTravelMedium() {
		return travelMedium;
	}

	public void setTravelMedium(String travelMedium) {
		this.travelMedium = travelMedium;
	}

	public String getTravelStartDatetime() {
		return travelStartDatetime;
	}

	public void setTravelStartDatetime(String travelStartDatetime) {
		this.travelStartDatetime = travelStartDatetime;
	}

	public String getTravelFinishDatetime() {
		return travelFinishDatetime;
	}

	public void setTravelFinishDatetime(String travelFinishDatetime) {
		this.travelFinishDatetime = travelFinishDatetime;
	}

	public String getTravelStatus() {
		return travelStatus;
	}

	public void setTravelStatus(String travelStatus) {
		this.travelStatus = travelStatus;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}
}
