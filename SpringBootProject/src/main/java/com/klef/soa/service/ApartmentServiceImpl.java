package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.Apartment;
import com.klef.soa.repository.ApartmentRepository;

@Service
public class ApartmentServiceImpl implements ApartmentService
{
    @Autowired
    private ApartmentRepository repo;

    @Override
    public Apartment addApartment(Apartment apartment)
    {
        return repo.save(apartment);
    }

    @Override
    public Apartment updateApartment(Apartment apartment)
    {
        Optional<Apartment> optional = repo.findById(apartment.getApartmentId());

        if(optional.isPresent())
        {
            Apartment apt = optional.get();

            apt.setName(apartment.getName());
            apt.setType(apartment.getType());
            apt.setStatus(apartment.getStatus());
            apt.setLocation(apartment.getLocation());

            return repo.save(apt); // save() performs update
        }
        else
        {
            return null;
        }
    }

    @Override
    public List<Apartment> displayAllApartments()
    {
        return repo.findAll();
    }

    @Override
    public Apartment displayApartmentByID(Long apartmentId)
    {
        return repo.findById(apartmentId).orElse(null);
    }

    @Override
    public String deleteApartmentById(Long apartmentId)
    {
        boolean flag = repo.existsById(apartmentId);

        if(flag)
        {
            repo.deleteById(apartmentId);
            return "Apartment Deleted Successfully";
        }
        else
        {
            return "Apartment ID Not Found";
        }
    }

    @Override
    public List<Apartment> displayApartmentsByName(String name)
    {
        return repo.findByName(name);
    }

    @Override
    public List<Apartment> displayApartmentsByType(String type)
    {
        return repo.findByType(type);
    }
}