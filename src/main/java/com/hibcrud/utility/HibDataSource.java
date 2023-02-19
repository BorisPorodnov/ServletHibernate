package com.hibcrud.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibDataSource {

    public static SessionFactory factory;

    //Get Factory
    public static SessionFactory getSessionFactory() {
        if(factory == null) {
            factory = new Configuration().configure().buildSessionFactory();
        }
        return factory;
    }

    //Get Session
    public static Session getSession() {
        Session session = getSessionFactory().openSession();
        return session;
    }

    //Get Session
    public static void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }





}