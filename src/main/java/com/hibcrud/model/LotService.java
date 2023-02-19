package com.hibcrud.model;

import com.hibcrud.entity.Employee;
import com.hibcrud.entity.Lot;
import com.hibcrud.utility.HibDataSource;
import org.hibernate.Session;

import java.util.List;

public class LotService {
    public static Lot FindById(long id) {
        Session session = HibDataSource.getSession();
        session.beginTransaction();
        Lot lot = (Lot) session.get(Lot.class, id);
        return lot;
    }
    public static long SignUp(Lot lot) {

        Session session = HibDataSource.getSession();
        session.beginTransaction();
        Long id = (Long) session.save(lot);
        session.getTransaction().commit();
        return id;
    }

    public static List<Lot> getLotsList() {

        Session session = HibDataSource.getSession();
        session.beginTransaction();
        List<Lot> list = session.createQuery("from lot").list();
        for (Lot lot : list) {
            System.out.println(lot.getNote());
        }
        session.getTransaction().commit();
        return list;
    }

}
