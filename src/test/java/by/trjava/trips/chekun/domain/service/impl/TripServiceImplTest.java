package by.trjava.trips.chekun.domain.service.impl;

import by.trjava.trips.chekun.domain.comparator.TripComparatorByCost;
import by.trjava.trips.chekun.domain.entity.ExcursionTrip;
import by.trjava.trips.chekun.domain.entity.RestTrip;
import by.trjava.trips.chekun.domain.entity.ShoppingTrip;
import by.trjava.trips.chekun.domain.entity.Trip;
import by.trjava.trips.chekun.domain.entity.fieldsrestriction.excursiontrip.ExcursionTripPlaceName;
import by.trjava.trips.chekun.domain.entity.fieldsrestriction.resttrip.RestTripHotelName;
import by.trjava.trips.chekun.domain.entity.fieldsrestriction.shoppingtrip.ShoppingTripShopCentreName;
import by.trjava.trips.chekun.domain.entity.fieldsrestriction.trip.TripLocation;
import by.trjava.trips.chekun.domain.entity.fieldsrestriction.trip.TripTransportType;
import by.trjava.trips.chekun.domain.entity.fieldsrestriction.trip.TripTypeOfFood;
import by.trjava.trips.chekun.domain.entity.type.TripType;
import by.trjava.trips.chekun.domain.service.ServiceFactory;
import by.trjava.trips.chekun.domain.service.TripService;
import by.trjava.trips.chekun.domain.service.exception.TripServiceException;
import by.trjava.trips.chekun.domain.specification.TripSpecification;
import by.trjava.trips.chekun.domain.specification.impl.*;
import by.trjava.trips.chekun.domain.specification.impl.rest.RestTripSpecificationByHotelName;
import by.trjava.trips.chekun.domain.specification.impl.shoppingtrip.ShoppingTripSpecificationByBaggageWeightRange;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.*;

public class TripServiceImplTest {


    private TripService tripService = ServiceFactory.getInstance().getTripService();

    @BeforeMethod
    public void beforeMethod() throws TripServiceException {

        tripService.clearRepository();

        Trip trip1 = new RestTrip(1, TripTransportType.HELICOPTER.toString(), TripTypeOfFood.AI.toString(), TripLocation.SPAIN_MAJORCA.toString(), 15, 25555,
                RestTripHotelName.IBISA_HACIENDA_NA_XAMENA.toString(), 2);


        Trip trip2 = new ExcursionTrip(2, TripTransportType.BUS.toString(), TripTypeOfFood.НВ.toString(), TripLocation.SPAIN_MAJORCA.toString(), 25, 17000,
                5, ExcursionTripPlaceName.ROMAX_FORUM.toString());


        Trip trip3 = new ShoppingTrip(3, TripTransportType.HELICOPTER.toString(), TripTypeOfFood.AI.toString(), TripLocation.SPAIN_MAJORCA.toString(), 5, 7000,
                ShoppingTripShopCentreName.GYM.toString(), 15);

        tripService.saveTrip(trip1);
        tripService.saveTrip(trip2);
        tripService.saveTrip(trip3);
    }


    //////////////////////////


    @Test
    public void testSaveTrip_true() throws TripServiceException {

        List<Trip> expected = Arrays.asList(
                new RestTrip(1, TripTransportType.HELICOPTER.toString(), TripTypeOfFood.AI.toString(), TripLocation.SPAIN_MAJORCA.toString(), 15, 25555,
                        RestTripHotelName.IBISA_HACIENDA_NA_XAMENA.toString(), 2),

                new ExcursionTrip(2, TripTransportType.BUS.toString(), TripTypeOfFood.НВ.toString(), TripLocation.SPAIN_MAJORCA.toString(), 25, 17000,
                        5, ExcursionTripPlaceName.ROMAX_FORUM.toString()),

                new ShoppingTrip(3, TripTransportType.HELICOPTER.toString(), TripTypeOfFood.AI.toString(), TripLocation.SPAIN_MAJORCA.toString(), 5, 7000,
                        ShoppingTripShopCentreName.GYM.toString(), 15),

                new RestTrip(4, TripTransportType.PLANE.toString(), TripTypeOfFood.AI.toString(), TripLocation.SPAIN_MAJORCA.toString(),
                        5, 6863, RestTripHotelName.NEW_YORK_CONCORDE_HOTEL.toString(), 5)
        );

        Trip trip = new RestTrip(4, TripTransportType.PLANE.toString(), TripTypeOfFood.AI.toString(), TripLocation.SPAIN_MAJORCA.toString(),
                5, 6863, RestTripHotelName.NEW_YORK_CONCORDE_HOTEL.toString(), 5);

        tripService.saveTrip(trip);

        TripSpecification tripSpecification1 = new TripSpecificationGetAllTrips();

        List<Trip> actual = tripService.query(tripSpecification1);

        assertEquals(expected, actual);
    }

    @Test(expectedExceptions = TripServiceException.class)
    public void testSaveTrip_false_null() throws TripServiceException {

        Trip trip = null;

        tripService.saveTrip(trip);
    }


    @Test(expectedExceptions = TripServiceException.class)
    public void testSaveTrip_false_badTrip() throws TripServiceException {

        Trip trip = new RestTrip();

        tripService.saveTrip(trip);
    }


    @Test(expectedExceptions = TripServiceException.class)
    public void testSaveTrip_false_badTrip_2() throws TripServiceException {

        Trip trip = new RestTrip(1, "asdf", "asdf", "asdf", 5, 5, "asdf", 5);

        tripService.saveTrip(trip);
    }


    //////////////////////////

    @Test
    public void testDeleteTrip_true() throws TripServiceException {

        List<Trip> expected = Arrays.asList(
                new RestTrip(1, TripTransportType.HELICOPTER.toString(), TripTypeOfFood.AI.toString(), TripLocation.SPAIN_MAJORCA.toString(), 15, 25555,
                        RestTripHotelName.IBISA_HACIENDA_NA_XAMENA.toString(), 2),

                new ExcursionTrip(2, TripTransportType.BUS.toString(), TripTypeOfFood.НВ.toString(), TripLocation.SPAIN_MAJORCA.toString(), 25, 17000,
                        5, ExcursionTripPlaceName.ROMAX_FORUM.toString())
        );


        Trip trip = new ShoppingTrip(3, TripTransportType.HELICOPTER.toString(), TripTypeOfFood.AI.toString(), TripLocation.SPAIN_MAJORCA.toString(), 5, 7000,
                ShoppingTripShopCentreName.GYM.toString(), 15);

        tripService.deleteTrip(trip);

        TripSpecification tripSpecification1 = new TripSpecificationGetAllTrips();

        List<Trip> actual = tripService.query(tripSpecification1);

        assertEquals(expected, actual);

    }

    @Test(expectedExceptions = TripServiceException.class)
    public void testDeleteTrip_false() throws TripServiceException {

        Trip trip = null;

        tripService.deleteTrip(trip);
    }


    //////////////////////////

    @Test
    public void testUpdateTrip_true() throws TripServiceException {

        List<Trip> expected = Arrays.asList(
                new RestTrip(1, TripTransportType.HELICOPTER.toString(), TripTypeOfFood.AI.toString(), TripLocation.SPAIN_MAJORCA.toString(), 15, 25555,
                        RestTripHotelName.IBISA_HACIENDA_NA_XAMENA.toString(), 2),

                new ExcursionTrip(2, TripTransportType.BUS.toString(), TripTypeOfFood.НВ.toString(), TripLocation.SPAIN_MAJORCA.toString(), 25, 17000,
                        5, ExcursionTripPlaceName.ROMAX_FORUM.toString()),

                new ShoppingTrip(3, TripTransportType.SHIP.toString(), TripTypeOfFood.AI.toString(), TripLocation.SPAIN_MAJORCA.toString(), 5, 7000,
                        ShoppingTripShopCentreName.GYM.toString(), 55)

        );
        Trip trip = new ShoppingTrip(3, TripTransportType.SHIP.toString(), TripTypeOfFood.AI.toString(), TripLocation.SPAIN_MAJORCA.toString(), 5, 7000,
                ShoppingTripShopCentreName.GYM.toString(), 55);


        tripService.updateTrip(trip);


        TripSpecification tripSpecification1 = new TripSpecificationGetAllTrips();

        List<Trip> actual = tripService.query(tripSpecification1);

        assertEquals(expected, actual);
    }

    @Test(expectedExceptions = TripServiceException.class)
    public void testUpdateTrip_false() throws TripServiceException {

        Trip trip = null;

        tripService.updateTrip(trip);

    }

    @Test(expectedExceptions = TripServiceException.class)
    public void testUpdateTrip_false_bad_trip() throws TripServiceException {

        Trip trip = new RestTrip();

        tripService.updateTrip(trip);

    }

    //////////////////////////

    @Test
    public void testCreateTrip() throws TripServiceException {
        String parameters = "RestTrip : ID=16, TRANSPORT_TYPE=PLANE, TYPE_OF_FOOD=Not-Available, TRIP_LOCATION=USA_NEW_YORK, DAY_COUNT=61, COST=2000.0, HOTEL_NAME=Concorde_Hotel, HOTEL_LEVEL=2;";

        Trip expected = new RestTrip(16, TripTransportType.PLANE.toString(), TripTypeOfFood.NA.toString(), TripLocation.USA_NEW_YORK.toString(), 61, 2000
                , RestTripHotelName.NEW_YORK_CONCORDE_HOTEL.toString(), 2);


        Trip actual = tripService.createTrip(parameters);


        assertEquals(expected, actual);
    }

    @Test(expectedExceptions = TripServiceException.class)
    public void testCreateTrip_false_notValidTrip() throws TripServiceException {
        String line = "RestTrip : ID=16, TRANSPORT_TYPE=PLANE, TYPE_OF_FOOD=Not-Available, TRIP_LOCATION=USA_NEW_YORK, DAY_COUNT=61, COST=2000.0, ";

        tripService.createTrip(line);

    }


    @Test(expectedExceptions = TripServiceException.class)
    public void testCreateTrip_false_null() throws TripServiceException {
        String line = null;

        tripService.createTrip(line);

    }


    @Test(expectedExceptions = TripServiceException.class)
    public void testCreateTrip_false_clearParameters() throws TripServiceException {
        String line = "";

        tripService.createTrip(line);

    }

    //////////////////////////

    @Test
    public void testQuery() throws TripServiceException {

        List<Trip> expected = Arrays.asList(new ShoppingTrip(3, TripTransportType.HELICOPTER.toString(), TripTypeOfFood.AI.toString(), TripLocation.SPAIN_MAJORCA.toString(), 5, 7000,
                ShoppingTripShopCentreName.GYM.toString(), 15));

        TripSpecification tripSpecByTransportType = new TripSpecificationByTransportType(TripTransportType.HELICOPTER.toString());
        TripSpecification tripSpecByTypeOfFOod = new TripSpecificationByTypeOfFood(TripTypeOfFood.AI.toString());
        TripSpecification TripSpecByBaggageWeightRange = new ShoppingTripSpecificationByBaggageWeightRange(14, 16);
        TripSpecification tripSpecByDayCount = new TripSpecificationByDayCount(5);

        TripSpecification finalTripSpecification = tripSpecByTransportType.and(tripSpecByTypeOfFOod).and(TripSpecByBaggageWeightRange).and(tripSpecByDayCount);

        List<Trip> actual = tripService.query(finalTripSpecification);


        assertEquals(expected, actual);

    }

    @Test(expectedExceptions = TripServiceException.class)
    public void testQuery_null() throws TripServiceException {
        TripSpecification tripSpecification = null;

        tripService.query(tripSpecification);
    }


    @Test(expectedExceptions = TripServiceException.class)
    public void testQuery_nothingInFile() throws TripServiceException {
        TripSpecification tripSpecification = new TripSpecificationByDayCount(-1);

        tripService.query(tripSpecification);
    }


    //////////////////////////
    @Test
    public void testSort() throws TripServiceException {

        List<Trip> expected = Arrays.asList(

                new ShoppingTrip(3, TripTransportType.HELICOPTER.toString(), TripTypeOfFood.AI.toString(), TripLocation.SPAIN_MAJORCA.toString(), 5, 7000,
                        ShoppingTripShopCentreName.GYM.toString(), 15),

                new ExcursionTrip(2, TripTransportType.BUS.toString(), TripTypeOfFood.НВ.toString(), TripLocation.SPAIN_MAJORCA.toString(), 25, 17000,
                        5, ExcursionTripPlaceName.ROMAX_FORUM.toString()),

                new RestTrip(1, TripTransportType.HELICOPTER.toString(), TripTypeOfFood.AI.toString(), TripLocation.SPAIN_MAJORCA.toString(), 15, 25555,
                        RestTripHotelName.IBISA_HACIENDA_NA_XAMENA.toString(), 2)


        );

        Comparator comparator = new TripComparatorByCost();


        List<Trip> actual = tripService.sort(comparator);

        assertEquals(expected, actual);

    }

    @Test()
    public void testClearRepository() throws TripServiceException {
        tripService.clearRepository();
        //look file
    }
}