package org.example.databasesproject1.controller;

import org.example.databasesproject1.AirportFilter;
import org.example.databasesproject1.dtos.AirportT1OutputDTO;
import org.example.databasesproject1.model.Country;
import org.example.databasesproject1.repository.Repository;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
public class Controller {
    private final Repository repository;

    public Controller(Repository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/v0/airports")
    public ResponseEntity<List<AirportT1OutputDTO>> getAllAirports() {
        List<AirportT1OutputDTO> airports = this.repository.getAllAirports();

        return ResponseEntity.ok(airports);
    }
//
//    @PostMapping("api/v0/airports/filter")
//    public ResponseEntity<List<?>> getFilteredAirports(@RequestParam boolean countryAsRoot, @RequestBody AirportFilter airportFilter) {
//        List<?> airports = this.repository.getFilteredAirports(countryAsRoot, airportFilter);
//
//        return ResponseEntity.ok(airports);
//    }

    @PostMapping("api/v0/airports/filter")
    public ResponseEntity<List<?>> getFilteredAirportsPageable(@RequestParam boolean countryAsRoot, @RequestParam int page, @RequestParam int size, @RequestBody AirportFilter airportFilter) {
        List<?> airports = this.repository.getFilteredAirportsPageable(countryAsRoot, airportFilter, PageRequest.of(page, size));

        return ResponseEntity.ok(airports);
    }
}
