package com.Idat.AppApuestas.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "odds")
public class odd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_match", nullable = false) // Relación con Match
    @JsonManagedReference
    private match match;

    @Column(nullable = false)
    private Float homeOdd;

    @Column(nullable = false)
    private Float awayOdd;

    @Column(nullable = false)
    private Float drawOdd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public match getMatch() {
        return match;
    }

    public void setMatch(match match) {
        this.match = match;
    }

    public Float getHomeOdd() {
        return homeOdd;
    }

    public void setHomeOdd(Float homeOdd) {
        this.homeOdd = homeOdd;
    }

    public Float getAwayOdd() {
        return awayOdd;
    }

    public void setAwayOdd(Float awayOdd) {
        this.awayOdd = awayOdd;
    }

    public Float getDrawOdd() {
        return drawOdd;
    }

    public void setDrawOdd(Float drawOdd) {
        this.drawOdd = drawOdd;
    }

    public odd(Long id, match match, Float homeOdd, Float awayOdd, Float drawOdd) {
        this.id = id;
        this.match = match;
        this.homeOdd = homeOdd;
        this.awayOdd = awayOdd;
        this.drawOdd = drawOdd;
    }

    public odd(match match, Float homeOdd, Float awayOdd, Float drawOdd) {
        this.match = match;
        this.homeOdd = homeOdd;
        this.awayOdd = awayOdd;
        this.drawOdd = drawOdd;
    }

    public odd() {}
}
