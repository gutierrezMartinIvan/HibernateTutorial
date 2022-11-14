package org.beniko.hibernateConnection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveClientTest {
    public static void main(String[] args) {

        SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clients.class)
                .buildSessionFactory();

        Session mySession = myFactory.openSession();

        try {
            Clients client1 = new Clients("asas", "dfdf", "eeee");
            mySession.beginTransaction();
            mySession.persist(client1);
            mySession.getTransaction().commit();

            mySession.beginTransaction();
            Clients savedClient = mySession.get(Clients.class, client1.getId());
            System.out.println(savedClient);
            mySession.close();
        }
        finally {
            myFactory.close();
        }
    }
}
