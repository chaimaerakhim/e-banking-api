package com.chaimae.restapi.ebankingapi.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "operations")
public class Operation {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="source")
    private int source;

    @Column(name="destination")
    private int destination;


    @Column(name="montant")
    private double	montant;

    @Column(name="date")
    private Date date;

    public Operation(int id, int source, int destination, double montant, Date date) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.montant = montant;
        this.date = date;
    }

    public Operation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", source=" + source +
                ", destination=" + destination +
                ", montant=" + montant +
                ", date=" + date +
                '}';
    }
}
