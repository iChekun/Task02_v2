package by.trjava.trips.chekun.domain.repostitory.exception;

public class RepositoryException extends Exception {

    public RepositoryException() {
        super();
    }

    public RepositoryException(String message) {
        super(message);
    }

    public RepositoryException(Throwable cause) {
        super(cause);
    }

    public RepositoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
