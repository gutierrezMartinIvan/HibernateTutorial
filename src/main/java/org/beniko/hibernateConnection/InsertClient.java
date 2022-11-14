package org.beniko.hibernateConnection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertClient {
    public static void main(String[] args) {
        SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(ClientDetail.class)
                .buildSessionFactory();
        Session mySession = myFactory.openSession();

        try {
            Client client1 = new Client("Martin", "Gutierrez", "Nose");
            ClientDetail clientDetail1 = new ClientDetail("www.beniko.com.ar", "121314", "No comments");
            client1.setClientDetail(clientDetail1);
            mySession.beginTransaction();
            mySession.persist(client1);
            mySession.getTransaction().commit();
            mySession.close();
        }finally {
            myFactory.close();
        }

    }
}
