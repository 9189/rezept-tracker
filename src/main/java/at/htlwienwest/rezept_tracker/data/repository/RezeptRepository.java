package at.htlwienwest.rezept_tracker.data.repository;

import at.htlwienwest.rezept_tracker.data.entity.Rezept;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RezeptRepository extends CrudRepository<Rezept, Long> {
}
