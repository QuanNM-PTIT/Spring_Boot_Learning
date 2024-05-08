package com.SpringBoot.HibernateCRUDDemo.dao;

import com.SpringBoot.HibernateCRUDDemo.entity.Student;

import java.util.List;

public interface StudentDAO
{
    void saveStudent(Student student);

    Student findStudentById(int id);

    List<Student> findAllStudents();

    List<Student> findStudentsByLastName(String lastName);

    void updateStudent(Student student);

    void deleteStudent(int id);

    int deleteAllStudents();
}
