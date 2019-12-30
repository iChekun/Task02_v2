package by.trjava.trips.chekun.dao.exception;

public class DAOStorageException extends Exception {

    public DAOStorageException() {
        super();
    }

    public DAOStorageException(String message) {
        super(message);
    }

    public DAOStorageException(Throwable cause) {
        super(cause);
    }

    public DAOStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
