package com.Idat.AppApuestas.DTO;

public class OddDTO {

    private Long id;
    private Long match;
    private Float homeOdd;
    private Float awayOdd;
    private Float drawOdd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMatch() {
        return match;
    }

    public void setMatch(Long match) {
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

    public OddDTO(Long id, Long match, Float homeOdd, Float awayOdd, Float drawOdd) {
        this.id = id;
        this.match = match;
        this.homeOdd = homeOdd;
        this.awayOdd = awayOdd;
        this.drawOdd = drawOdd;
    }

    public OddDTO(Long match, Float homeOdd, Float awayOdd, Float drawOdd) {
        this.match = match;
        this.homeOdd = homeOdd;
        this.awayOdd = awayOdd;
        this.drawOdd = drawOdd;
    }
    public OddDTO() {}
}
