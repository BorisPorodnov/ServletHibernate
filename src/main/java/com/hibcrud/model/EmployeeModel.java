package com.hibcrud.model;

import java.util.List;

import org.hibernate.Session;

import com.hibcrud.entity.Employee;
import com.hibcrud.utility.HibDataSource;

public class EmployeeModel {
    public static Employee findBy(long id) {
        Session session = HibDataSource.getSession();
        session.beginTransaction();
        return (Employee) session.get(Employee.class, id);
    }

    public static void save(Employee emp) {
        Session session = HibDataSource.getSession();
        session.beginTransaction();
        session.persist(emp);
        session.getTransaction().commit();
    }


    public static void update(Employee emp) {
        Session session = HibDataSource.getSession();
        session.beginTransaction();
        session.merge(emp);
        session.getTransaction().commit();

    }

    public static List<Employee> getAll() {
        Session session = HibDataSource.getSession();
        session.beginTransaction();
        List<Employee> list = session.createQuery("from Employee").list();
        for (Employee employee : list) {
            System.out.println(employee.getUsername());
        }
        session.getTransaction().commit();
        return list;
    }

    public static void deleteEmp(long id) {
        Session session = HibDataSource.getSession();
        session.beginTransaction();
        Employee emp = (Employee) session.get(Employee.class, id);
        session.delete(emp);
        session.getTransaction().commit();
    }

}