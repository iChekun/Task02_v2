package by.trjava.trips.chekun.dao.exception;

public class WriteDAOException extends Exception {

    public WriteDAOException() {
        super();
    }

    public WriteDAOException(String message) {
        super(message);
    }

    public WriteDAOException(Throwable cause) {
        super(cause);
    }

    public WriteDAOException(String message, Throwable cause) {
        super(message, cause);
    }
}