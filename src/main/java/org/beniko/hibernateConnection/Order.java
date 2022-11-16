package org.beniko.hibernateConnection;

import jakarta.persistence.*;
import java.util.Date;
import java.util.GregorianCalendar;

@Entity
@Table(name = "PEDIDO")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "FECHA")
    private GregorianCalendar date;

    @Column(name = "FORMA_PAGO")
    private String paymentMethod;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "CLIENTE_ID")
    private Client client;

    public Order(GregorianCalendar date, String paymentMethod, Client client) {
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.client = client;
    }

    public Order(GregorianCalendar date) {
        this.date = date;
    }

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", date=" + date +
                ", paymentMethod='" + paymentMethod;
    }


}