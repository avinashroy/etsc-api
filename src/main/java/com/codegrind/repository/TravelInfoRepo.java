package com.codegrind.repository;

import com.codegrind.model.TravelInfo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelInfoRepo extends CrudRepository<TravelInfo, String> {
	
	Optional<List<TravelInfo>> findByEmpId(String empId);
}
