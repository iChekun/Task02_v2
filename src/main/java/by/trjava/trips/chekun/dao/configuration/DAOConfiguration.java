package by.trjava.trips.chekun.dao.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class DAOConfiguration {

    private static DAOConfiguration instance = new DAOConfiguration();

    public static DAOConfiguration getInstance() {
        return instance;
    }

    private DAOConfiguration() {
    }
    /////////////////////////////////////////////////////////////////

    private String tripStoragePath;

    private static final String DAO_CONFIGURATION_PATH = "src/main/resources/daoConfiguration.properties";

    private static final String DEFAULT_FILE_PATH = "src/main/resources/trips.txt";


    public void read() {
        try {
            final InputStream fileInputStream = new FileInputStream(DAO_CONFIGURATION_PATH);
            final Properties properties = new Properties();
            properties.load(fileInputStream);

            final String key = "trip_storage_path"; //change here

            this.tripStoragePath = properties.getProperty(key, DEFAULT_FILE_PATH);
        } catch (IOException ignore) {/*NOP*/}
    }

    public String getTripStoragePath() {
        return tripStoragePath;
    }


}
