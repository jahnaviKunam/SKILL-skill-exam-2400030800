package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.Apartment;

public interface ApartmentService
{
    Apartment addApartment(Apartment apartment);

    Apartment updateApartment(Apartment apartment);

    List<Apartment> displayAllApartments();

    Apartment displayApartmentByID(Long apartmentId);

    String deleteApartmentById(Long apartmentId);

    List<Apartment> displayApartmentsByName(String name);

    List<Apartment> displayApartmentsByType(String type);
}