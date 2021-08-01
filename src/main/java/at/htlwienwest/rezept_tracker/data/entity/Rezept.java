package at.htlwienwest.rezept_tracker.data.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Rezept {
    @Id
    @GeneratedValue
    private Long id;

    private String titel;

    private String beschreibung;

    @OneToMany(mappedBy = "rezept", cascade = CascadeType.ALL)
    private Set<RezeptZutat> zutaten;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Bewertung> bewertungen;

    public Rezept() {
    }

    public Rezept(String titel, String beschreibung) {
        this.titel = titel;
        this.beschreibung = beschreibung;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public Set<RezeptZutat> getZutaten() {
        return zutaten;
    }

    public void setZutaten(Set<RezeptZutat> zutaten) {
        this.zutaten = zutaten;
    }

    public Set<Bewertung> getBewertungen() {
        return bewertungen;
    }

    public void setBewertungen(Set<Bewertung> bewertungen) {
        this.bewertungen = bewertungen;
    }
}
