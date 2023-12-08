package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
public class Controller {
    @Autowired
    private DaoImpl dao;
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping(value="/insert",method = RequestMethod.POST)
    public Student insertRecord(@RequestBody Student student){
        dao.insert(student);
        return student;
    }


    @GetMapping("/getAll")
    public List<Student> getAllStudentInDB() {
        List<Student> student = dao.fetch();
        return  student;
    }

    @GetMapping("/getName/{name}")
    public Response getName(@PathVariable("name") String name) {
       Student student = dao.findName(name);
       ResponseEntity<Laptop> laptop = restTemplate.postForEntity("http://localhost:8080/laptop", name, Laptop.class);
       Response r = new Response();
       r.setLaptop(laptop.getBody());
       r.setStudent(student);
       if(student == null) throw new StudentNotFoundException("HeLLEW Dude your resource is not available");
        return r;
    }

    @PostMapping("/getId/{id}")
    public Student fetchById(@PathVariable("id") long id) {
        return dao.fetchId(id);
    }


    @PostMapping("/updateId")
    public Student updateById(@RequestBody Student student) {
        return dao.update(student);
    }
    
  
    
}
