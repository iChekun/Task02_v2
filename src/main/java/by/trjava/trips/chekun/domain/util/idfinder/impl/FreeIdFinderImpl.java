package by.trjava.trips.chekun.domain.util.idfinder.impl;


import by.trjava.trips.chekun.domain.util.idfinder.FreeIdFinder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;


public class FreeIdFinderImpl implements FreeIdFinder {

    private static final Logger logger = LogManager.getLogger(FreeIdFinderImpl.class);

//    private DAOFactory factory = DAOFactory.getINSTANCE();
//
//    private TripRepository tripRepository = factory.getTripRepository();

    public int find() {
        logger.debug("freeIdFinder start working");

        final Random random = new Random();
//        List<Trip> trips = null;
//        try {
//            trips = tripRepository.query(new TripSpecificationGetAllTrips());
//        } catch (RepositoryException ignore) {
//            /*NOP*/
//        }
//
//        final Random random = new Random();
//        boolean notFound = true;
//
//        //int id = random.nextInt(5005) * 10_000;
//
//        while (notFound) {
//            notFound = false;
//            for (Trip trip : trips) {
//                if (trip.getId() == currectID) {
//                    notFound = true;
//                }
//            }
//            currectID = random.nextInt(5005) * 10_000;
//        }

        int id = random.nextInt(5005) * 10_000;
        logger.debug("Id has found! Id = " + id);
        return id;
    }
}
