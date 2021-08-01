package at.htlwienwest.rezept_tracker.exception;

public class RezeptNotFoundException extends RuntimeException {
    public RezeptNotFoundException(Long id) {
        super(String.format("Rezept mit der ID [%d] nicht gefunden werden.", id));
    }
}
