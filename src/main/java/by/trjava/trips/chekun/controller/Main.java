package by.trjava.trips.chekun.controller;

import by.trjava.trips.chekun.domain.comparator.TripComparatorByCost;
import by.trjava.trips.chekun.domain.entity.RestTrip;
import by.trjava.trips.chekun.domain.entity.Trip;
import by.trjava.trips.chekun.domain.entity.fields.TripField;
import by.trjava.trips.chekun.domain.entity.fieldsrestriction.trip.TripLocation;
import by.trjava.trips.chekun.domain.entity.fieldsrestriction.trip.TripTransportType;
import by.trjava.trips.chekun.domain.entity.type.TripType;
import by.trjava.trips.chekun.domain.service.ServiceFactory;
import by.trjava.trips.chekun.domain.service.TripService;

import by.trjava.trips.chekun.domain.service.exception.TripServiceException;
import by.trjava.trips.chekun.domain.specification.AbstractTripSpecification;
import by.trjava.trips.chekun.domain.specification.TripSpecification;
import by.trjava.trips.chekun.domain.specification.impl.*;
import by.trjava.trips.chekun.domain.specification.impl.rest.RestTripSpecificationByHotelLevel;
import by.trjava.trips.chekun.domain.specification.impl.shoppingtrip.ShoppingTripSpecificationByBaggageWeightRange;
import by.trjava.trips.chekun.view.Printer;

import java.util.Comparator;
import java.util.List;


public class Main {


    /**
     * UI
     * |
     * controller
     * |
     * DOMAIN ( BUSINESS LOGIC LAYER)
     * |
     * DAO
     */


    private static final ServiceFactory serviceFactory = ServiceFactory.getInstance();

    private static final TripService tripService = serviceFactory.getTripService();

    public static void main(String[] argc) {


        {
            Trip trip = null;
            Trip trip2 = null;
            Trip trip3 = null;
            try {
                trip = tripService
                        .createTrip("RestTrip : ID=17, TRANSPORT_TYPE=BUS, TYPE_OF_FOOD=Not-Available, TRIP_LOCATION=USA_NEW_YORK, DAY_COUNT=61, COST=95000.5, HOTEL_NAME=Concorde_Hotel, HOTEL_LEVEL=1");
                trip2 = tripService
                        .createTrip("ExcursionTrip : ID=18, TRANSPORT_TYPE=plane, TYPE_OF_FOOD=Room-Only, TRIP_LOCATION=CANADA_VANCOUVER, DAY_COUNT=12, COST=215000.0, COUNT_OF_EXCURSIONS=5, EXCURSION_PLACE_NAME=BELARUS_NESVIZH_CASTLE;");
                trip3 = tripService.
                        createTrip("MedicalTrip : ID=19, TRANSPORT_TYPE=car, TYPE_OF_FOOD=Bed&Breakfast, TRIP_LOCATION=USA_NEW_YORK, DAY_COUNT=14, COST=18100.0," +
                                " TYPE_OF_INHALATION_TREATMENT=HALOTHERAPY, VISIT_SWIMMIN_POOL_TIMES_TIMES_PER_RELAX_PERIOD=14, ELECTRO_THERAPY_COUNT_PER_RELAX_PERIOD=21, " +
                                "PHYSIOTHERAPY_TYPE=MECHANOTHERAPY, MANUAL_MASSAGE_TYPE=HYDROMASSAGE, BALNEOTHERAPY_TYPE=SOULS, HEAT_MUD_THERAPY_TYPE=PHYTOAPPLICANTION;");

            } catch (TripServiceException e) {
                Printer.print(e);
            }


            try {
                tripService.saveTrip(trip);
                tripService.saveTrip(trip2);
                tripService.saveTrip(trip3);
            } catch (TripServiceException e) {
                Printer.print(e);
            }

            Trip trip4 = null;
            try {
                trip4 = tripService.createTrip("RestTrip : ID=17, TRANSPORT_TYPE=PLANE, TYPE_OF_FOOD=Not-Available, TRIP_LOCATION=USA_NEW_YORK, DAY_COUNT=61, COST=2000, HOTEL_NAME=Concorde_Hotel, HOTEL_LEVEL=2");
            } catch (TripServiceException e) {
                Printer.print(e);
            }

            try {
                tripService.updateTrip(trip4);
            } catch (TripServiceException e) {
                Printer.print(e);
            }


            Trip trip5 = null;
            try {
                trip5 = tripService
                        .createTrip("RestTrip : ID=20, TRANSPORT_TYPE=BUS, TYPE_OF_FOOD=Not-Available, TRIP_LOCATION=USA_NEW_YORK, DAY_COUNT=61, COST=95000.5, HOTEL_NAME=Concorde_Hotel, HOTEL_LEVEL=1");
            } catch (TripServiceException e) {
                Printer.print(e);
            }

            try {
                tripService.saveTrip(trip5);
            } catch (TripServiceException e) {
                Printer.print(e);
            }

            {
                Printer.print("-----------------------------------------------------");
                Printer.print("get all trips:\n");
                TripSpecification specification = new TripSpecificationGetAllTrips();


                try {
                    List<Trip> trips = tripService.query(specification);
                    trips.forEach(Printer::print);
                } catch (TripServiceException e) {
                    Printer.print(e);
                }
                Printer.print("-----------------------------------------------------\n");
            }


            {
                Printer.print("-----------------------------------------------------");
                Printer.print("get rest trips with cost between 1000 and 3000 and hotel level is 2\n");

                TripSpecification specificationByRestTrip = new TripSpecificationByTripName(TripType.RestTrip.name());

                TripSpecification specificationByCost = new TripSpecificationByCostRange(1000, 3000);

                TripSpecification specificationByHotelLevel = new RestTripSpecificationByHotelLevel(2);

                TripSpecification finalSpecification = specificationByRestTrip.and(specificationByCost).and(specificationByHotelLevel);

                try {
                    List<Trip> trips = tripService.query(finalSpecification);
                    trips.forEach(Printer::print);
                } catch (TripServiceException e) {
                    Printer.print(e);
                }
                Printer.print("-----------------------------------------------------\n");
            }


            {
                Printer.print("-----------------------------------------------------");
                Printer.print("get SHOPPING trip  with DAYCOUNT=4 , WTH_LOCATION=ITALY_ROME, WITH TRANSPORT_TYPE=HELICOPTER, WITH BAGGAGE_WEIGHT_LIMIT between 20 and 25 \n");

                TripSpecification specificationByRestTrip = new TripSpecificationByTripName(TripType.ShoppingTrip.name());

                TripSpecification specificationByDayCount = new TripSpecificationByDayCount(4);

                TripSpecification specificationWithTransportType = new TripSpecificationByTransportType(TripTransportType.HELICOPTER.toString());

                TripSpecification specificationWithLocation = new TripSpecificationByLocation(TripLocation.ITALY_ROME.toString());

                TripSpecification specificationWithBaggageWeightRange = new ShoppingTripSpecificationByBaggageWeightRange(20, 25);

                TripSpecification finalSpecification = specificationByRestTrip
                        .and(specificationByDayCount)
                        .and(specificationWithTransportType)
                        .and(specificationWithLocation)
                        .and(specificationWithBaggageWeightRange);

                try {
                    List<Trip> trips = tripService.query(finalSpecification);
                    trips.forEach(Printer::print);
                } catch (TripServiceException e) {
                    Printer.print(e);
                }
                Printer.print("-----------------------------------------------------\n");
            }


            Printer.print("-----------------------------------------------------");
            Printer.print("after search by hotel level (2) range:\n");
            {

                AbstractTripSpecification specification = new RestTripSpecificationByHotelLevel(2);
                // AbstractTripSpecification specification1 = new TripSpecificationByTripName("RestTrip");
                TripSpecification finalSpecification = specification;//.and(specification1);

                List<Trip> trips = null;
                try {
                    trips = tripService.query(finalSpecification);
                } catch (TripServiceException e) {
                    Printer.print(e);
                }

                if (trips != null) {
                    trips.forEach(Printer::print);
                }
            }


            Printer.print("-----------------------------------------------------");
            Printer.print("after compare by cost:\n");
            {

                Comparator comparator = new TripComparatorByCost();
                List<Trip> trips = null;
                try {
                    trips = tripService.sort(comparator);
                } catch (TripServiceException e) {
                    Printer.print(e);
                }

                if (trips != null) {
                    trips.forEach(Printer::print);
                }
            }
        }
    }


}
