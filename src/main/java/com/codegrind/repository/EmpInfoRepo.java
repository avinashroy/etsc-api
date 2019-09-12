package com.codegrind.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codegrind.model.EmpInfo;

@Repository
public interface EmpInfoRepo extends CrudRepository<EmpInfo, String> {

	@Query("SELECT e FROM EmpInfo e WHERE e.managerAppId= :managerAppId OR e.emergencyAppId=  :emergencyAppId")
	public List<EmpInfo> getAlert(@Param("managerAppId") String managerAppId,
			@Param("emergencyAppId") String emergencyAppId);
}
