package at.htlwienwest.rezept_tracker.data.repository;

import at.htlwienwest.rezept_tracker.data.entity.Zutat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ZutatRepository extends CrudRepository<Zutat, Long> {
    Optional<Zutat> findByName(String name);
}
