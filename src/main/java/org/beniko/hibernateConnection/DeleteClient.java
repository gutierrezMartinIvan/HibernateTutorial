package org.beniko.hibernateConnection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteClient {
    public static void main(String[] args) {
        SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(ClientDetail.class)
                .buildSessionFactory();
        Session mySession = myFactory.openSession();

        try {
            mySession.beginTransaction();
            Client client = mySession.get(Client.class, 2);
            if (client != null)
                mySession.remove(client);
            mySession.getTransaction().commit();
            mySession.close();
        }finally {
            myFactory.close();
        }

    }
}
