package at.htlwienwest.rezept_tracker.data.repository;

import at.htlwienwest.rezept_tracker.data.entity.Bewertung;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BewertungRepository extends CrudRepository<Bewertung, Long> {
}
