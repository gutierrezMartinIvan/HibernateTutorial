package org.beniko.hibernateConnection;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellido")
    private String surname;

    @Column(name = "direccion")
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private ClientDetail clientDetail;

    @OneToMany(mappedBy = "client", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Order> orders;

    public Client() {
    }

    public Client(String name, String surname, String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ClientDetail getClientDetail() {
        return clientDetail;
    }

    public void setClientDetail(ClientDetail clientDetail) {
        this.clientDetail = clientDetail;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
     if (orders == null) orders = new ArrayList<>();
     orders.add(order);
     order.setClient(this);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
