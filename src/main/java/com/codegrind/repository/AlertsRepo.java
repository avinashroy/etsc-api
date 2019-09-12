package com.codegrind.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codegrind.model.Alerts;

@Repository
public interface AlertsRepo extends CrudRepository<Alerts, String> {


	public List<Alerts> findByEmpId(String empId);
}
