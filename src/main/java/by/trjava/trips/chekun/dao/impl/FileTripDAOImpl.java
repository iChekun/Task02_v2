package by.trjava.trips.chekun.dao.impl;

import by.trjava.trips.chekun.dao.TripDAO;
import by.trjava.trips.chekun.dao.configuration.DAOConfiguration;
import by.trjava.trips.chekun.dao.exception.*;

import by.trjava.trips.chekun.dao.validator.TripInputValidator;
import by.trjava.trips.chekun.dao.validator.impl.TripInputValidatorImpl;
import by.trjava.trips.chekun.domain.specification.TripSpecification;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Implementation of TripDAO
 * Using for work with tripStorage
 *
 * @see TripInputValidator
 * @see DAOConfiguration
 * @see by.trjava.trips.chekun.dao.factory.DAOFactory
 */
public class FileTripDAOImpl implements TripDAO {

    private final Path workFilePath;

    /**
     * Using for validate received strings
     */
    private final TripInputValidator validator = new TripInputValidatorImpl();

    /*standard encoding for work */
    private static final Charset UTF_8 = StandardCharsets.UTF_8;

    private static final String SPACE = "\n";
    ////////////////////////////////////////////////////////////////////////////

    /**
     * Base constructor. It use DAOConfiguration for workFilePath.
     *
     * @see DAOConfiguration
     */
    public FileTripDAOImpl() {

        final DAOConfiguration daoConfiguration = DAOConfiguration.getInstance();
        daoConfiguration.read();

        final String filePath = daoConfiguration.getTripStoragePath();
        this.workFilePath = Paths.get(filePath);

        if(!Files.exists(workFilePath)) // if we don`t have with file  it will be create
            try { Files.createFile(workFilePath); } catch (IOException ignore) { }
    }

    ////////////////////////////////////////////////////////////////////////////

    /**
     * Save trip in file
     *
     * @param trip
     * @throws NoDataStorageDAOException throws if problems with file
     * @throws WriteDAOException         throws if can`t write in file
     */
    @Override
    public void saveTrip(final String trip) throws NoDataStorageDAOException,
                                                   WriteDAOException {

        if (isFileCorrect()) {
            try {
                 Files.write(workFilePath, trip.concat(SPACE).getBytes(UTF_8), StandardOpenOption.WRITE,
                                                                               StandardOpenOption.APPEND,
                                                                               StandardOpenOption.SYNC);
            } catch (NullPointerException | IOException e) {
                throw new WriteDAOException("Can`t save trip! " + e.getMessage());
            }
//            try (FileWriter fileWriter = new FileWriter(workFilePath.toFile(),true)) {
//                fileWriter.write(trip.concat("\n"));
//            } catch (NullPointerException | IOException e) {
//                throw new WriteDAOException("Can`t save trip! " + e.getMessage());
//            }
        } else {
            throw new NoDataStorageDAOException("no file exc");
        }
    }

    /**
     * Delete trip from file storage
     *
     * @param trip
     * @throws DAOException throws if can`t delete trip from file, will give more info why
     */
    @Override
    public void deleteTrip(final String trip) throws DAOException {

        try (Stream<String> line = Files.lines(workFilePath, UTF_8)) {

            final List<String> newLinesFile = line.filter(s -> !s.equals(trip)).collect(Collectors.toList());

            deleteFile();
            writeListInFile(newLinesFile, StandardOpenOption.CREATE,
                                          StandardOpenOption.SYNC);
        } catch (IOException | DAOStorageException |  WriteDAOException e) {
            throw new DAOException("Can`n delete trip: " + e.getMessage());
        }
    }


    @Override
    public void updateTrip(final int id, final String updatedTrip) throws DAOException {

        final String searchedID = "ID=" + id;

        try (Stream<String> lines = Files.lines(workFilePath, UTF_8 )) {

            final List<String> listAfterFirstValidation = lines.filter(validator::validate)
                                                               .filter(p -> !p.contains(searchedID))
                                                               .collect(Collectors.toList());
            listAfterFirstValidation.add(updatedTrip);

            deleteFile();
            writeListInFile(listAfterFirstValidation, StandardOpenOption.CREATE,
                                                      StandardOpenOption.SYNC);

        } catch (IOException | DAOStorageException | WriteDAOException e) {
            throw new DAOException("Can`t update trip! " + e.getMessage());
        }


    }

    /**
     * Find info if file with received criteria
     *
     * @param tripSpecification
     * @return {@code List<String>} with trips parameters
     * @throws NoDataStorageDAOException throws if have problems with file
     * @throws ReadDAOException          throws if can`t reading info from file
     * @see TripSpecification
     */
    @Override
    public List<String> query(TripSpecification tripSpecification) throws NoDataStorageDAOException,
                                                                          ReadDAOException {

        try (Stream<String> lines = Files.lines(workFilePath, UTF_8)) {

            List<String> tripsParametersList = lines.filter(validator::validate)
                                                    .filter(tripSpecification::isSatisfiedBy)
                                                    .collect(Collectors.toList());

            if (tripsParametersList.size() > 0) {
                return tripsParametersList;
            }

        } catch (NullPointerException | IOException e) {
            throw new ReadDAOException("Can`t open file storage with path: " + workFilePath + ". Problem: " + e.getMessage());
        }
        throw new NoDataStorageDAOException("File storage with path: " + workFilePath + " does not contain searched info!!");
    }


    /**
     * Used for clearing file
     *
     * @throws DAOStorageException throws if can`t clear file
     */
    @Override
    public void clear() throws DAOStorageException {
        try {
            deleteFile();
            createNewFile();
        } catch (DAOStorageException e) {
            throw new DAOStorageException("Can`t clear file storage! Problem: " + e.getMessage());
        }
    }


    private boolean isFileCorrect() {
        return Files.exists(workFilePath);
    }

    private void createNewFile() throws DAOStorageException {
        try {
            Files.createFile(workFilePath);
        } catch (IOException e) {
            throw new DAOStorageException("Can`t create file with path: " + workFilePath + ".  Problem: " + e.getMessage());
        }
    }

    private void deleteFile() throws DAOStorageException {
        try {
            Files.deleteIfExists(workFilePath);
        } catch (IOException e) {
            throw new DAOStorageException("Can`t delete file with path: " + workFilePath + ".  Problem:" + e.getMessage());
        }
    }

    private void writeListInFile(final List<String> tripsList,
                                 final StandardOpenOption... openOptions)
                                 throws WriteDAOException {
        try {
            Files.write(workFilePath, tripsList, UTF_8, openOptions);
        } catch (IOException e) {
            throw new WriteDAOException("Can`t write in file : " + e.getMessage());
        }
    }


}
