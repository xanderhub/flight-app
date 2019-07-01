package com.xanderhub.flightapp.repository;

import com.xanderhub.flightapp.model.CheckIn;
import org.springframework.data.repository.CrudRepository;

public interface CheckInRepository extends CrudRepository<CheckIn, Integer> {
}
