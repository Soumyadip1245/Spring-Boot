package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DaoImpl implements Dao{
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student insert(Student student) {
        studentRepository.save(student);
        return student;
       
    }

    @Override
    public List<Student> fetch() {
        List<Student> student = studentRepository.findAll();

        return student;
    }

    @Override
    public Student update(Student student) {
        Student estudent = studentRepository.findById(student.getId()).orElse(null);
        estudent.setName(student.getName());
        studentRepository.save(estudent);
        return estudent;
    }

    @Override
    public Student fetchId(long id) {
        Student student =  studentRepository.findById(id).orElse(null);
        System.out.print(student);
        // Laptop laptop = laptopRepository.findById(student.getLaptop().getLaptopId()).orElse(null);
        // System.out.print(laptop);
        // student.setLaptop(laptop);
        return student;
    }
    
    @Override
    public Student findName(String name){
        Student student = studentRepository.findByName(name);
        return student;
    }

     // EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.example.demo");
        // EntityManager e = emf.createEntityManager();
        // e.getTransaction().begin();
        // Student s = new Student();
        // s.setName("Hi");
        // List<Laptop> laptop = new ArrayList<>();
        // Laptop l1 = new Laptop();
        // l1.setLaptopName("Laptop");
        // laptop.add(l1);
        // s.setLaptop(laptop);
        // e.persist(s);
        // e.getTransaction().commit();
        // e.close();
}
