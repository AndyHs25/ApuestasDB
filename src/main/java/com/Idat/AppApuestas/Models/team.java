package com.Idat.AppApuestas.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "teams")
public class team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column
    private String logo;

    @OneToMany(mappedBy = "teamHome")
    @JsonBackReference
    private List<match> homeMatches;

    @OneToMany(mappedBy = "teamAway")
    @JsonBackReference
    private List<match> awayMatches;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<match> getAwayMatches() {
        return awayMatches;
    }

    public void setAwayMatches(List<match> awayMatches) {
        this.awayMatches = awayMatches;
    }

    public List<match> getHomeMatches() {
        return homeMatches;
    }

    public void setHomeMatches(List<match> homeMatches) {
        this.homeMatches = homeMatches;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
