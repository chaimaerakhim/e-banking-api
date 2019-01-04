package com.chaimae.restapi.ebankingapi.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="clients")
public class Client implements Serializable {

    @Id
    @Column(name="cin")
    private String cin;

    @Column(name="nom")
    private String nom;

    @Column(name="prenom")
    private String prenom;

    @Column(name="login")
    private int login;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    @Column(name="adresse")
    private String addresse;

    @Column(name="tel")
    private int tel;

    @Column(name="solde")
    private double solde;

    @Column(name="id_compte")
    private int id_compte;

    public Client() {
    }

    public Client(String cin) {
        this.cin = cin;
    }

    public Client(String cin, String nom, String prenom, int login, String password, String email, String addresse, int tel, int solde,int id_compte) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.email = email;
        this.addresse = addresse;
        this.tel = tel;
        this.solde = solde;
        this.id_compte=id_compte;
    }

    public Client(String cin, String nom, String prenom) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
    }


    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public int getId_compte() {
        return id_compte;
    }

    public void setId_compte(int id_compte) {
        this.id_compte = id_compte;
    }

    @Override
    public String toString() {
        return "Client{" +
                "cin='" + cin + '\'' +
                '}';
    }
}
