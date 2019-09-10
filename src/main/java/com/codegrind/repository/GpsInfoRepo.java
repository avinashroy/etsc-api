package com.codegrind.repository;

import com.codegrind.model.GpsInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GpsInfoRepo extends CrudRepository<GpsInfo, String> {
}
