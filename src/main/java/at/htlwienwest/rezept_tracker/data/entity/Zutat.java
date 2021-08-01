package at.htlwienwest.rezept_tracker.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Zutat {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Zutat() {
    }

    public Zutat(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
