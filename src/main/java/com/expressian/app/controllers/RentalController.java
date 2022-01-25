package com.expressian.app.controllers;

import com.expressian.app.models.Customer;
import com.expressian.app.models.Rental;
import com.expressian.app.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {
    @Autowired
    private RentalRepository repository;

    @GetMapping
    public @ResponseBody List<Rental> getRentals() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Rental> createRental(@RequestBody Rental newRental) {
        return new ResponseEntity<>(repository.save(newRental), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public @ResponseBody Rental updateRental(@PathVariable Long id, @RequestBody Rental updates) {
        Rental rental = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (updates.getStartDate() != null) rental.setStartDate(updates.getStartDate());
        if (updates.getEndDate() != null) rental.setEndDate(updates.getEndDate());
        if (updates.getFuelLevel() != null) rental.setFuelLevel(updates.getFuelLevel());
        if (updates.getPrice() != null) rental.setPrice(updates.getPrice());

        return repository.save(rental);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
