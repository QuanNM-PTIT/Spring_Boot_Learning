package com.SpringBoot.HibernateCRUDDemo;

import com.SpringBoot.HibernateCRUDDemo.dao.StudentDAO;
import com.SpringBoot.HibernateCRUDDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateCrudDemoApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(HibernateCrudDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO)
    {
        return runner -> {
            // createStudent(studentDAO);
            // getStudent(studentDAO);
            // getAllStudents(studentDAO);
            // updateStudent(studentDAO);
            // deleteStudent(studentDAO);
            // deleteAllStudents(studentDAO);
        };
    }

    private void deleteAllStudents(StudentDAO studentDAO)
    {
        System.out.println("Deleting all students...");
        int deleteCount = studentDAO.deleteAllStudents();
        System.out.println("Deleted " + deleteCount + " students.");
    }

    private void deleteStudent(StudentDAO studentDAO)
    {
        System.out.println("Deleting student...");
        studentDAO.deleteStudent(2);
        System.out.println("Student deleted successfully.");
        System.out.println("Retrieving all students...");
        studentDAO.findAllStudents().forEach(System.out::println);
    }

    private void updateStudent(StudentDAO studentDAO)
    {
        System.out.println("Retrieving student...");
        Student student = studentDAO.findStudentById(1);
        System.out.println("Student retrieved:\n" + student);
        System.out.println("Updating student...");
        student.setFirstName("Jimmy");
        student.setEmail("jimmydoe@gmail.com");
        studentDAO.updateStudent(student);
        System.out.println("Student updated successfully.");
        System.out.println("Retrieving student...");
        Student updatedStudent = studentDAO.findStudentById(1);
        System.out.println("Student retrieved:\n" + updatedStudent);
    }

    private void getAllStudents(StudentDAO studentDAO)
    {
        System.out.println("Retrieving all students...");
        studentDAO.findAllStudents().forEach(System.out::println);
    }

    private void getStudent(StudentDAO studentDAO)
    {
        System.out.println("Creating student...");
        Student student = new Student("Tim", "Buchalka", "timbuchalka@gmail.com");
        System.out.println("Saving student...");
        studentDAO.saveStudent(student);
        System.out.println("Student saved successfully. Generated ID: " + student.getId());
        System.out.println("Retrieving student...");
        Student retrievedStudent = studentDAO.findStudentById(student.getId());
        System.out.println("Student retrieved:\n" + retrievedStudent);
    }

    private void createStudent(StudentDAO studentDAO)
    {
        System.out.println("Creating student...");
        Student student = new Student("John", "Doe", "johndoe@gmail.com");
        System.out.println("Saving student...");
        studentDAO.saveStudent(student);
        System.out.println("Student saved successfully. Generated ID: " + student.getId());
    }

}
