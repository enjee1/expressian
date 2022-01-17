package com.expressian.app.controllers;

import com.expressian.app.models.Vehicle;
import com.expressian.app.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleRepository repository;

    @GetMapping
    public @ResponseBody List<Vehicle> getVehicles() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/makes/{make}")
    public ResponseEntity<List<Vehicle>> getVehiclesByMake(@PathVariable String make) {
        return new ResponseEntity<>(repository.findAllByMake(make, Sort.by("model")), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle newVehicle) {
        return new ResponseEntity<>(repository.save(newVehicle), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public @ResponseBody Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle updates) {
        Vehicle vehicle = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (updates.getMake() != null) vehicle.setMake(updates.getMake());
        if (updates.getModel() != null) vehicle.setModel(updates.getModel());
        if (updates.getColor() != null) vehicle.setColor(updates.getColor());

        return repository.save(vehicle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
