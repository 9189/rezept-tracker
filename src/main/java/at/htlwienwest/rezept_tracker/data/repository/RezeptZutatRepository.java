package at.htlwienwest.rezept_tracker.data.repository;

import at.htlwienwest.rezept_tracker.data.entity.Rezept;
import at.htlwienwest.rezept_tracker.data.entity.RezeptZutat;
import at.htlwienwest.rezept_tracker.data.entity.RezeptZutatKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RezeptZutatRepository extends CrudRepository<RezeptZutat, RezeptZutatKey> {
    @Transactional
    void deleteAllByRezept(Rezept rezept);
}
