package com.SpringBoot.HibernateCRUDDemo.dao;

import com.SpringBoot.HibernateCRUDDemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImp implements StudentDAO
{
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImp(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void saveStudent(Student student)
    {
        entityManager.persist(student);
    }

    @Override
    public Student findStudentById(int id)
    {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAllStudents()
    {
        return entityManager.createQuery("FROM Student ORDER BY lastName ASC", Student.class).getResultList();
    }

    @Override
    public List<Student> findStudentsByLastName(String lastName)
    {
        return entityManager.createQuery("FROM Student WHERE lastName = :lastName", Student.class).setParameter("lastName", lastName).getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student student)
    {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudent(int id)
    {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAllStudents()
    {
        int deletedCount = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return deletedCount;
    }


}
