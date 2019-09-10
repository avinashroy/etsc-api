package com.codegrind.repository;

import com.codegrind.model.EmpInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpInfoRepo extends CrudRepository<EmpInfo, String> {
}
