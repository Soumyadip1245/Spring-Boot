package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface LaptopRepository extends JpaRepository<Laptop,Long>{
    @Query("select l from Laptop l where l.name = :name")
    public Laptop findByName(String name);
        
} 
