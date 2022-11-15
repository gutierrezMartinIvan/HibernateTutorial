package org.beniko.hibernateConnection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class getClient {

    public static void main(String[] args) {
        SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(ClientDetail.class)
                .buildSessionFactory();
        Session mySession = myFactory.openSession();

        try {
            mySession.beginTransaction();
            ClientDetail clientDetail = mySession.get(ClientDetail.class, 1);
            System.out.println(clientDetail);
            System.out.println(clientDetail.getClient());
            mySession.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            mySession.close();
            myFactory.close();
        }
    }
}