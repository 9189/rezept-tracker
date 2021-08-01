package at.htlwienwest.rezept_tracker.dto;

import java.util.Set;

public class RezeptDTO {
    private String titel;
    private String beschreibung;
    private Set<ZutatDTO> zutaten;

    public RezeptDTO(String titel, String beschreibung, Set<ZutatDTO> zutaten) {
        this.titel = titel;
        this.beschreibung = beschreibung;
        this.zutaten = zutaten;
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

    public Set<ZutatDTO> getZutaten() {
        return zutaten;
    }

    public void setZutaten(Set<ZutatDTO> zutaten) {
        this.zutaten = zutaten;
    }
}
