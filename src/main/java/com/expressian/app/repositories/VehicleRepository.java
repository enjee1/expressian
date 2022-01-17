package com.expressian.app.repositories;

import com.expressian.app.models.Vehicle;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

//    Vehicle findByVehicle_id(Long id);

    List<Vehicle> findAllByMake(String make, Sort sort);
}
