package by.trjava.trips.chekun.domain.service.exception;

public class TripServiceException extends Exception {

    public TripServiceException() {
        super();
    }

    public TripServiceException(String message) {
        super(message);
    }

    public TripServiceException(Throwable cause) {
        super(cause);
    }

    public TripServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
