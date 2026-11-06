package com.klef.soa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.entity.Apartment;

public interface ApartmentRepository extends JpaRepository<Apartment, Long>
{
     List<Apartment>findByName(String name);
     
     List<Apartment> findByType(String type);
}
