package com.codegrind.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp_info")
public class EmpInfo {

    @Id
    private String empId;
    private String empName;
    private String empPassword;
    private String empContactNo;
    private String managerName;
    private String managerAppId;
    private String managerContactNo;
    private String emergencyName;
    private String emergencyContactNo;
    private String emergencyAppId;
    
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpPassword() {
		return empPassword;
	}
	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}
	public String getEmpContactNo() {
		return empContactNo;
	}
	public void setEmpContactNo(String empContactNo) {
		this.empContactNo = empContactNo;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerAppId() {
		return managerAppId;
	}
	public void setManagerAppId(String managerAppId) {
		this.managerAppId = managerAppId;
	}
	public String getManagerContactNo() {
		return managerContactNo;
	}
	public void setManagerContactNo(String managerContactNo) {
		this.managerContactNo = managerContactNo;
	}
	public String getEmergencyName() {
		return emergencyName;
	}
	public void setEmergencyName(String emergencyName) {
		this.emergencyName = emergencyName;
	}
	public String getEmergencyContactNo() {
		return emergencyContactNo;
	}
	public void setEmergencyContactNo(String emergencyContactNo) {
		this.emergencyContactNo = emergencyContactNo;
	}
	public String getEmergencyAppId() {
		return emergencyAppId;
	}
	public void setEmergencyAppId(String emergencyAppId) {
		this.emergencyAppId = emergencyAppId;
	}

}
