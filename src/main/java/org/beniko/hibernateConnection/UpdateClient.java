package org.beniko.hibernateConnection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateClient {

    public static void main(String[] args) {

        SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clients.class)
                .buildSessionFactory();

        Session mySession = myFactory.openSession();

        try {
            mySession.beginTransaction();
            mySession.createQuery("delete Clients where address = 'Anasoaos'").executeUpdate();
            mySession.getTransaction().commit();
            System.out.println("Client updated successfully in the database");
            mySession.close();
        }finally {
            myFactory.close();
        }
    }
}