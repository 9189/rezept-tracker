package at.htlwienwest.rezept_tracker.data.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RezeptZutatKey implements Serializable {
    private Long rezeptId;
    private Long zutatId;

    public RezeptZutatKey() {
    }

    public RezeptZutatKey(Long rezeptId, Long zutatId) {
        this.rezeptId = rezeptId;
        this.zutatId = zutatId;
    }

    public Long getRezeptId() {
        return rezeptId;
    }

    public void setRezeptId(Long rezeptId) {
        this.rezeptId = rezeptId;
    }

    public Long getZutatId() {
        return zutatId;
    }

    public void setZutatId(Long zutatId) {
        this.zutatId = zutatId;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;

        if(obj == null || getClass() != obj.getClass()) {
            return false;
        }

        RezeptZutatKey that = (RezeptZutatKey) obj;
        return Objects.equals(getRezeptId(), that.getRezeptId()) &&
                Objects.equals(getZutatId(), that.getZutatId());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
