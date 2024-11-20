package com.Idat.AppApuestas.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "bets")
public class bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Relación con User
    @JsonManagedReference
    private user user;

    @ManyToOne
    @JoinColumn(name = "match_id", nullable = false) // Relación con Match
    @JsonManagedReference
    private match match;

    @Column(nullable = false)
    private String typeBet;

    @Column(nullable = false)
    private Float odd;

    @Column(nullable = false)
    private Float amount;

    @Column(nullable = false)
    private String dateBet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public user getUser() {
        return user;
    }

    public void setUser(user user) {
        this.user = user;
    }

    public match getMatch() {
        return match;
    }

    public void setMatch(match match) {
        this.match = match;
    }

    public String getTypeBet() {
        return typeBet;
    }

    public void setTypeBet(String typeBet) {
        this.typeBet = typeBet;
    }

    public Float getOdd() {
        return odd;
    }

    public void setOdd(Float odd) {
        this.odd = odd;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getDateBet() {
        return dateBet;
    }

    public void setDateBet(String dateBet) {
        this.dateBet = dateBet;
    }

    public bet(Long id, user user, match match, String typeBet, Float odd, Float amount, String dateBet) {
        this.id = id;
        this.user = user;
        this.match = match;
        this.typeBet = typeBet;
        this.odd = odd;
        this.amount = amount;
        this.dateBet = dateBet;
    }

    public bet(user user, match match, String typeBet, Float odd, Float amount, String dateBet) {
        this.user = user;
        this.match = match;
        this.typeBet = typeBet;
        this.odd = odd;
        this.amount = amount;
        this.dateBet = dateBet;
    }

    public bet() {}
}
