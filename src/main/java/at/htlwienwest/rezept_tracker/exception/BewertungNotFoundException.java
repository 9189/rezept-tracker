package at.htlwienwest.rezept_tracker.exception;

public class BewertungNotFoundException extends RuntimeException {
    public BewertungNotFoundException(Long id) {
        super(String.format("Bewertung mit der ID [%d] nicht gefunden werden.", id));
    }
}
