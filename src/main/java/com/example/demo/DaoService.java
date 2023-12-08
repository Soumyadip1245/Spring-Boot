package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DaoService {
    @Autowired
    private LaptopRepository laptopRepository;
    public Laptop getLaptop(String name){
        Laptop laptop = laptopRepository.findByName(name);
        return laptop;
    }
}
