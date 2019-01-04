package com.chaimae.restapi.ebankingapi.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "comptes")
public class Compte implements Serializable {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="type")
    private String type;

    @Column(name="solde")
    private double solde;

    public Compte(int id, String type, double solde) {
        this.id = id;
        this.type = type;
        this.solde = solde;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", solde=" + solde +
                '}';
    }
}
