package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LaptopController {
    @Autowired
    private DaoService daoService;

    @RequestMapping(value="/laptop",method=RequestMethod.POST)
    public Laptop laptop(@RequestBody String name){
        return daoService.getLaptop(name);
    }
}
