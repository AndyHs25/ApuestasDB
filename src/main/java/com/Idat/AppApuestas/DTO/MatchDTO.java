package com.Idat.AppApuestas.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;

public class MatchDTO {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("teamHome")
    private Long teamHome;
    @JsonProperty("teamAway")
    private Long teamAway;
    @JsonProperty("date")
    private String date;
    @JsonProperty("status")
    private String status;
    @JsonProperty("goalHome")
    private String goalHome;
    @JsonProperty("goalAway")
    private String goalAway;
    @JsonProperty("result")
    private String result;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeamHome() {
        return teamHome;
    }

    public void setTeamHome(Long teamHome) {
        this.teamHome = teamHome;
    }

    public Long getTeamAway() {
        return teamAway;
    }

    public void setTeamAway(Long teamAway) {
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

    public MatchDTO(Long id, Long teamHome, Long teamAway, String date, String status, String goalHome, String goalAway, String result) {
        this.id = id;
        this.teamHome = teamHome;
        this.teamAway = teamAway;
        this.date = date;
        this.status = status;
        this.goalHome = goalHome;
        this.goalAway = goalAway;
        this.result = result;
    }

    public MatchDTO(Long teamHome, Long teamAway, String date, String status, String goalHome, String goalAway, String result) {
        this.teamHome = teamHome;
        this.teamAway = teamAway;
        this.date = date;
        this.status = status;
        this.goalHome = goalHome;
        this.goalAway = goalAway;
        this.result = result;
    }

    public MatchDTO() {}
}
