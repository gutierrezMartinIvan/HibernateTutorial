package org.beniko.hibernateConnection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.GregorianCalendar;

public class GetClientOrder {
    public static void main(String[] args) {
        SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(ClientDetail.class)
                .addAnnotatedClass(Order.class)
                .buildSessionFactory();
        Session mySession = myFactory.openSession();

        try {
            Client client1 = mySession.get(Client.class, 1);

            mySession.beginTransaction();

            System.out.println(client1.getOrders());

            mySession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            myFactory.close();
            mySession.close();
        }

    }
}
