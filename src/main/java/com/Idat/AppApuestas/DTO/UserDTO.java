package com.Idat.AppApuestas.DTO;

import com.Idat.AppApuestas.Models.bet;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

public class UserDTO {

    private Long id;
    private String name;
    private String lastName;
    private String document;
    private String dateNac;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String city;
    private String card;
    private String dateCard;
    private String codCard;
    private Float cash;
    private String role;
    private Long bets;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getDateCard() {
        return dateCard;
    }

    public void setDateCard(String dateCard) {
        this.dateCard = dateCard;
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

    public Long getBets() {
        return bets;
    }

    public void setBets(Long bets) {
        this.bets = bets;
    }

    public UserDTO(Long id, String name, String lastName, String document, String dateNac, String email, String password, String phone, String address, String city, String card, String dateCard, String codCard, Float cash, String role, Long bets) {
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

    public UserDTO(String name, String lastName, String document, String dateNac, String email, String password, String phone, String address, String city, String card, String dateCard, String codCard, Float cash, String role, Long bets) {
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

    public UserDTO(String name, String lastName, String document, String dateNac, String email, String password, String phone, String address, String city, String card, String dateCard, String codCard, Float cash, String role) {
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

    public UserDTO() {}
}
