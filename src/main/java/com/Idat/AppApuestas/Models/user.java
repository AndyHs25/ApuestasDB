package com.Idat.AppApuestas.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(unique = true, nullable = false, length = 8)
    private String document;

    @Column(nullable = false , length = 15)
    private String dateNac;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true, length = 9)
    private String phone;

    @Column(nullable = false, length = 150)
    private String address;

    @Column(nullable = false, length = 50)
    private String city;

    @Column(length = 16)
    private String card;

    @Column(length = 15)
    private String dateCard;

    @Column(length = 3)
    private String codCard;

    @Column
    private Float cash;

    @Column
    private String role;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<bet> bets; // Relación con Bet

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getDateNac() {
        return dateNac;
    }

    public void setDateNac(String dateNac) {
        this.dateNac = dateNac;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDateCard() {
        return dateCard;
    }

    public void setDateCard(String dateCard) {
        this.dateCard = dateCard;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getCodCard() {
        return codCard;
    }

    public void setCodCard(String codCard) {
        this.codCard = codCard;
    }

    public Float getCash() {
        return cash;
    }

    public void setCash(Float cash) {
        this.cash = cash;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<bet> getBets() {
        return bets;
    }

    public void setBets(List<bet> bets) {
        this.bets = bets;
    }

    public user(Long id, String name, String lastName, String document, String dateNac, String email, String password, String phone, String address, String city, String card, String dateCard, String codCard, Float cash, String role, List<bet> bets) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.document = document;
        this.dateNac = dateNac;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.card = card;
        this.dateCard = dateCard;
        this.codCard = codCard;
        this.cash = cash;
        this.role = role;
        this.bets = bets;
    }

    public user(String name, String lastName, String document, String dateNac, String email, String password, String phone, String address, String city, String card, String dateCard, String codCard, Float cash, String role, List<bet> bets) {
        this.name = name;
        this.lastName = lastName;
        this.document = document;
        this.dateNac = dateNac;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.card = card;
        this.dateCard = dateCard;
        this.codCard = codCard;
        this.cash = cash;
        this.role = role;
        this.bets = bets;
    }

    public user(String name, String lastName, String document, String dateNac, String email, String password, String phone, String address, String city, String card, String dateCard, String codCard, Float cash, String role) {
        this.name = name;
        this.lastName = lastName;
        this.document = document;
        this.dateNac = dateNac;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.card = card;
        this.dateCard = dateCard;
        this.codCard = codCard;
        this.cash = cash;
        this.role = role;
    }

    public user() {}

}

