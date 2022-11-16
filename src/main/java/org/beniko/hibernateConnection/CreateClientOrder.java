package org.beniko.hibernateConnection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.GregorianCalendar;

public class CreateClientOrder {
    public static void main(String[] args) {
        SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(ClientDetail.class)
                .addAnnotatedClass(Order.class)
                .buildSessionFactory();
        Session mySession = myFactory.openSession();

        try {
            Client client1 = mySession.get(Client.class, 1);
            Order order1 = new Order(new GregorianCalendar(120, 6, 4));
            Order order2 = new Order(new GregorianCalendar(1240, 3, 6));
            Order order3 = new Order(new GregorianCalendar(1205, 2, 8));

            client1.addOrder(order1);
            client1.addOrder(order2);
            client1.addOrder(order3);

            mySession.beginTransaction();

            mySession.persist(order1);
            mySession.persist(order2);
            mySession.persist(order3);

            mySession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            myFactory.close();
            mySession.close();
        }

    }
}
