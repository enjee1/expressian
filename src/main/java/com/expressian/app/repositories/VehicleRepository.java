package com.expressian.app.repositories;

import com.expressian.app.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

//    Vehicle findByVehicle_id(Long id);
}
