package by.trjava.trips.chekun.view;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Printer {


    private static final Logger logger = LogManager.getLogger(Printer.class);

    public static void print(String message) {
        logger.info(message);
    }

    public static void print(Exception ex) {
        logger.error(ex.getMessage());
    }

    public static void print(Object object) {
        logger.info(object.toString());
    }

    private Printer() {
    }

}
