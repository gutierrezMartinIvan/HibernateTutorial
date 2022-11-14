package org.beniko.hibernateConnection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryClients {
    public static void main(String[] args) {

        SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clients.class)
                .buildSessionFactory();

        Session mySession = myFactory.openSession();

        try {
            mySession.beginTransaction();
            List<Clients> clients = mySession.createQuery("from Clients cl where cl.surname='dfdf'", Clients.class).getResultList();
            for (Clients client: clients) {
                System.out.println(client);
            }
            mySession.getTransaction().commit();
            mySession.close();
        }finally {
            myFactory.close();
        }
    }
}
