package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.entity.Apartment;
import com.klef.soa.service.ApartmentService;

@RestController
@RequestMapping("/apartment")
public class ApartmentController
{
    @Autowired
    private ApartmentService service;

    @GetMapping("/")
    public String demo()
    {
        return "Spring Boot Project";
    }

    // Add Apartment
    @PostMapping("/add")
    public ResponseEntity<Apartment> addApartment(@RequestBody Apartment apartment)
    {
        Apartment a = service.addApartment(apartment);
        return ResponseEntity.status(201).body(a);
    }

    // Display All Apartments
    @GetMapping("/displayall")
    public ResponseEntity<List<Apartment>> displayAllApartments()
    {
        List<Apartment> apartments = service.displayAllApartments();
        return ResponseEntity.status(200).body(apartments);
    }

    // Display Apartment By ID
    @GetMapping("/display")
    public ResponseEntity<?> displayApartmentById(@RequestParam Long id)
    {
        Apartment apartment = service.displayApartmentByID(id);

        if (apartment != null)
        {
            return ResponseEntity.status(200).body(apartment);
        }
        else
        {
            return ResponseEntity.status(404).body("Apartment ID Not Found");
        }
    }

    // Update Apartment
    @PutMapping("/update")
    public ResponseEntity<?> updateApartment(@RequestBody Apartment apartment)
    {
        Apartment a = service.updateApartment(apartment);

        if (a != null)
        {
            return ResponseEntity.ok(a);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Apartment ID Not Found");
        }
    }

    // Delete Apartment
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteApartmentById(@PathVariable Long id)
    {
        String message = service.deleteApartmentById(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    // Display Apartments By Name
    @GetMapping("/displaybyname/{name}")
    public ResponseEntity<List<Apartment>> displayApartmentsByName(@PathVariable String name)
    {
        List<Apartment> apartments = service.displayApartmentsByName(name);
        return ResponseEntity.status(200).body(apartments);
    }

    // Display Apartments By Type
    @GetMapping("/displaybytype/{type}")
    public ResponseEntity<List<Apartment>> displayApartmentsByType(@PathVariable String type)
    {
        List<Apartment> apartments = service.displayApartmentsByType(type);
        return ResponseEntity.status(200).body(apartments);
    }
}