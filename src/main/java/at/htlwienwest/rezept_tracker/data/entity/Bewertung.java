package at.htlwienwest.rezept_tracker.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Bewertung {
    @Id
    @GeneratedValue
    private Long id;

    @Min(1)
    @Max(5)
    private int sterne;

    private String kommentar;

    public Bewertung() {
    }

    public Bewertung(Integer sterne, String kommentar) {
        this.sterne = sterne;
        this.kommentar = kommentar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSterne() {
        return sterne;
    }

    public void setSterne(Integer sterne) {
        this.sterne = sterne;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }
}
