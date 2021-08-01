package at.htlwienwest.rezept_tracker;

import at.htlwienwest.rezept_tracker.data.entity.Rezept;
import at.htlwienwest.rezept_tracker.data.entity.RezeptZutat;
import at.htlwienwest.rezept_tracker.data.entity.Zutat;
import at.htlwienwest.rezept_tracker.data.repository.RezeptRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(RezeptRepository repository) {
        return args -> {
            Zutat mehl = new Zutat("Mehl");
            Zutat eier = new Zutat("Eier");
            Zutat milch = new Zutat("Milch");
            Zutat backpulver = new Zutat("Backpulver");

            Rezept rezept1 = new Rezept("Pancakes", "Pancakes sind ein beliebtes Frühstück in Nordamerika und werden dort mit Butter und Ahornsirup oder mit Speck gegessen. Ein flaumiges Rezept.");
            Rezept rezept2 = new Rezept("Palatschinken", "Von diesem Einfachen Palatschinken können Ihre Lieben nicht genug bekommen. Überzeugen Sie sich doch selbst von dem Rezept.");

            Set<RezeptZutat> zutaten1 = new HashSet<>();
            zutaten1.add(new RezeptZutat(rezept1, mehl, 150, "g"));
            zutaten1.add(new RezeptZutat(rezept1, eier, 2, "Stück"));
            zutaten1.add(new RezeptZutat(rezept1, milch, 150, "ml"));
            zutaten1.add(new RezeptZutat(rezept1, backpulver, 1, "Packung"));
            rezept1.setZutaten(zutaten1);

            Set<RezeptZutat> zutaten2 = new HashSet<>();
            zutaten1.add(new RezeptZutat(rezept2, mehl, 250, "g"));
            zutaten1.add(new RezeptZutat(rezept2, eier, 2, "Stück"));
            zutaten1.add(new RezeptZutat(rezept2, milch, 500, "ml"));
            rezept2.setZutaten(zutaten2);

            log.info("Preloading " + repository.save(rezept1));
            log.info("Preloading " + repository.save(rezept2));
        };
    }
}

