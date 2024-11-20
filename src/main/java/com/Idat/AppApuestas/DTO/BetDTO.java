package com.Idat.AppApuestas.DTO;

import com.Idat.AppApuestas.Models.match;
import com.Idat.AppApuestas.Models.user;
import jakarta.persistence.*;

public class BetDTO {

    private Long id;

    private Long user;

    private Long match;

    private String typeBet;

    private Float odd;

    private Float amount;

    private String dateBet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public Long getMatch() {
        return match;
    }

    public void setMatch(Long match) {
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

    public BetDTO(Long id, Long user, Long match, String typeBet, Float odd, Float amount, String dateBet) {
        this.id = id;
        this.user = user;
        this.match = match;
        this.typeBet = typeBet;
        this.odd = odd;
        this.amount = amount;
        this.dateBet = dateBet;
    }

    public BetDTO(Long user, Long match, String typeBet, Float odd, Float amount, String dateBet) {
        this.user = user;
        this.match = match;
        this.typeBet = typeBet;
        this.odd = odd;
        this.amount = amount;
        this.dateBet = dateBet;
    }

    public BetDTO() {

    }
}
