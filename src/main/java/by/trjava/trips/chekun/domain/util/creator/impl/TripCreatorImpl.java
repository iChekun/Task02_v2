package by.trjava.trips.chekun.domain.util.creator.impl;

import by.trjava.trips.chekun.domain.entity.Trip;
import by.trjava.trips.chekun.domain.util.UtilFactory;
import by.trjava.trips.chekun.domain.entity.type.TripType;
import by.trjava.trips.chekun.domain.util.creator.TripCreator;
import by.trjava.trips.chekun.domain.util.exception.WrongTripArgumentsUtilException;
import by.trjava.trips.chekun.domain.util.factory.manager.FactoryManager;
import by.trjava.trips.chekun.domain.util.factory.manager.impl.FactoryManagerImpl;
import by.trjava.trips.chekun.domain.util.factory.TripFactory;
import by.trjava.trips.chekun.domain.util.idfinder.FreeIdFinder;
import by.trjava.trips.chekun.domain.util.validator.TripValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.trjava.trips.chekun.domain.configuration.TripConfiguration.ID_POSITION;
import static by.trjava.trips.chekun.domain.configuration.TripConfiguration.TRIP_TYPE_POSITION;
import static by.trjava.trips.chekun.domain.util.parser.Parser.parseStringIntoArgsArray;

public class TripCreatorImpl implements TripCreator {

    private static final Logger logger = LogManager.getLogger(TripCreatorImpl.class);


    public Trip create(String tripValues) throws WrongTripArgumentsUtilException {
        logger.debug("TripCreatorImpl start working. Received trip fields: " + tripValues);

        final UtilFactory utilFactory = UtilFactory.getInstance();

        final TripValidator tripValidator = utilFactory.getTripValidator();

        if (tripValues != null && tripValidator.validate(tripValues)) {


            final String[] tripParameters = parseStringIntoArgsArray(tripValues);

//            {
//                final FreeIdFinder freeIdFinder = utilFactory.getFreeIdFinder();
//                final int id = freeIdFinder.find();
//                tripParameters[ID_POSITION] = "" + id;
//            }

            final TripType tripType = TripType.valueOf(tripParameters[TRIP_TYPE_POSITION]);

            final FactoryManager factoryManager = FactoryManagerImpl.getInstance();

            final TripFactory tripFactory = factoryManager.getFactory(tripType);

            if (tripFactory != null) {
                final Trip trip = tripFactory.createTrip(tripParameters);
                return trip;
            }
        }
        logger.debug("TripCreator received wrong trip fields!! Received: " + tripValues);
        throw new WrongTripArgumentsUtilException("TripCreator received wrong trip fields!! Received: " + tripValues);
    }


}
