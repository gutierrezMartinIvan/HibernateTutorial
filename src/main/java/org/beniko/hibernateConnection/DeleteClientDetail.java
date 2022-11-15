package org.beniko.hibernateConnection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteClientDetail {
    public static void main(String[] args) {
        SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(ClientDetail.class)
                .buildSessionFactory();
        Session mySession = myFactory.openSession();

        try {
            mySession.beginTransaction();
            ClientDetail clientDetail = mySession.get(ClientDetail.class, 1);
            clientDetail.setClient(null);
            if (clientDetail != null)
                mySession.remove(clientDetail);
            mySession.getTransaction().commit();
            mySession.close();
        }finally {
            myFactory.close();
        }

    }
}
