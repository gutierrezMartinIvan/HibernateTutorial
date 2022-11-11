package org.beniko.hibernateConnection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveClientTest {
    public static void main(String[] args) {

        SessionFactory session = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clients.class)
                .buildSessionFactory();

    }
}
