package com.example.demo;

import java.util.List;

public interface Dao {
    Student insert(Student student);
    List<Student> fetch();
    Student update(Student student);
    Student fetchId(long id);
    Student findName(String name);
}
