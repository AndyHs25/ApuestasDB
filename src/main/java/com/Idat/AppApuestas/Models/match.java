package com.Idat.AppApuestas.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "matches")
public class match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_team_home", nullable = false)
    @JsonManagedReference
    private team teamHome;

    @ManyToOne
    @JoinColumn(name = "id_team_away", nullable = false)
    @JsonManagedReference
    private team teamAway;

    @Column(length = 15, nullable = false)
    private String date;

    @Column(length = 20, nullable = false)
    private String status;

    @Column(length = 2)
    private String goalHome;

    @Column(length = 2)
    private String goalAway;

    @Column(length = 20)
    private String result;

    @OneToMany(mappedBy = "match")
    @JsonBackReference
    private List<odd> odds; // Relación con Odd

    @OneToMany(mappedBy = "match")
    @JsonBackReference
    private List<bet> bets; // Relación con Bet


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public team getTeamHome() {
        return teamHome;
    }

    public void setTeamHome(team teamHome) {
        this.teamHome = teamHome;
    }

    public team getTeamAway() {
        return teamAway;
    }

    public void setTeamAway(team teamAway) {
        this.teamAway = teamAway;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGoalHome() {
        return goalHome;
    }

    public void setGoalHome(String goalHome) {
        this.goalHome = goalHome;
    }

    public String getGoalAway() {
        return goalAway;
    }

    public void setGoalAway(String goalAway) {
        this.goalAway = goalAway;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<odd> getOdds() {
        return odds;
    }

    public void setOdds(List<odd> odds) {
        this.odds = odds;
    }

    public List<bet> getBets() {
        return bets;
    }

    public void setBets(List<bet> bets) {
        this.bets = bets;
    }

    public match(Long id, team teamHome, team teamAway, String date, String status, String goalHome, String goalAway, String result, List<odd> odds, List<bet> bets) {
        this.id = id;
        this.teamHome = teamHome;
        this.teamAway = teamAway;
        this.date = date;
        this.status = status;
        this.goalHome = goalHome;
        this.goalAway = goalAway;
        this.result = result;
        this.odds = odds;
        this.bets = bets;
    }

    public match(team teamHome, team teamAway, String date, String status, String goalHome, String goalAway, String result) {
        this.teamHome = teamHome;
        this.teamAway = teamAway;
        this.date = date;
        this.status = status;
        this.goalHome = goalHome;
        this.goalAway = goalAway;
        this.result = result;
    }

    public match() {}


}
