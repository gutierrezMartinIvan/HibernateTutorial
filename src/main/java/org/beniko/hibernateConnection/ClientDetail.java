package org.beniko.hibernateConnection;

import jakarta.persistence.*;

@Entity
@Table(name = "detalles_cliente")
public class ClientDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "web")
    private String web;

    @Column(name = "tfno")
    private String tfno;

    @Column(name = "comentarios")
    private String comentarios;

    public ClientDetail() {
    }

    public ClientDetail(String web, String tfno, String comentarios) {
        this.web = web;
        this.tfno = tfno;
        this.comentarios = comentarios;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getTfno() {
        return tfno;
    }

    public void setTfno(String tfno) {
        this.tfno = tfno;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}
