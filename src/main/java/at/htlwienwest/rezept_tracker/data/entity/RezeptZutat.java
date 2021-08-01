package at.htlwienwest.rezept_tracker.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class RezeptZutat {
    @EmbeddedId
    @JsonIgnore
    private RezeptZutatKey id;

    @ManyToOne
    @MapsId("rezeptId")
    @JsonIgnore
    private Rezept rezept;

    @ManyToOne
    @MapsId("zutatId")
    private Zutat zutat;

    private Integer menge;

    private String einheit;

    public RezeptZutat() {
    }

    public RezeptZutat(Rezept rezept, Zutat zutat, Integer menge, String einheit) {
        this.id = new RezeptZutatKey(rezept.getId(), zutat.getId());

        this.rezept = rezept;
        this.zutat = zutat;
        this.menge = menge;
        this.einheit = einheit;
    }

    public RezeptZutatKey getId() {
        return id;
    }

    public void setId(RezeptZutatKey id) {
        this.id = id;
    }

    public Rezept getRezept() {
        return rezept;
    }

    public void setRezept(Rezept rezept) {
        this.rezept = rezept;
    }

    public Zutat getZutat() {
        return zutat;
    }

    public void setZutat(Zutat zutat) {
        this.zutat = zutat;
    }

    public Integer getMenge() {
        return menge;
    }

    public void setMenge(Integer menge) {
        this.menge = menge;
    }

    public String getEinheit() {
        return einheit;
    }

    public void setEinheit(String einheit) {
        this.einheit = einheit;
    }
}
