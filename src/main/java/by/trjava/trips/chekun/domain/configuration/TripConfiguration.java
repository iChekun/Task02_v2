package by.trjava.trips.chekun.domain.configuration;

import by.trjava.trips.chekun.domain.entity.fieldsrestriction.cruisetrip.CruiseTripShipName;
import by.trjava.trips.chekun.domain.entity.fieldsrestriction.cruisetrip.CruiseTripTypes;
import by.trjava.trips.chekun.domain.entity.fieldsrestriction.excursiontrip.ExcursionTripPlaceName;
import by.trjava.trips.chekun.domain.entity.fieldsrestriction.medicaltrip.*;
import by.trjava.trips.chekun.domain.entity.fieldsrestriction.resttrip.RestTripHotelName;
import by.trjava.trips.chekun.domain.entity.fieldsrestriction.shoppingtrip.ShoppingTripShopCentreName;
import by.trjava.trips.chekun.domain.entity.fieldsrestriction.trip.TripLocation;
import by.trjava.trips.chekun.domain.entity.fieldsrestriction.trip.TripTransportType;
import by.trjava.trips.chekun.domain.entity.fieldsrestriction.trip.TripTypeOfFood;
import by.trjava.trips.chekun.domain.util.exception.ReadRestrictionsException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

/**
 * Class with TripConfiguration.
 * <p>
 * Class contains nested class {@code RestrictionPropertyReader} which can read restrictions from property file.
 * It`s very comfortable for change something in runtime.
 * </p>
 * Class made by public way, but in all program u can use them only by ConfigurationService.
 * <p>
 * Also class contains places of elements in received array from storage.
 * Class contains static final String arrays with possible values of any trip parameters. They can not be change
 * </p>
 *
 * @see by.trjava.trips.chekun.domain.entity.fieldsrestriction;
 * @see by.trjava.trips.chekun.domain.service.TripConfigurationService;
 */
public final class TripConfiguration {

    public static void readRestrictions() throws ReadRestrictionsException {
        RestrictionPropertyReader.readRestrictions();
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static final int TRIP_TYPE_POSITION = 0;
    public static final int ID_POSITION = 2;
    //all trips
    public static final int TRANSPORT_TYPE = 4;
    public static final int TYPE_OF_FOOD = 6;
    public static final int TRIP_LOCATION = 8;
    public static final int DAY_COUNT = 10;
    public static final int COST = 12;


    //shopping TRIP_TYPES_OF_FOOD
    public static final int SHOP_CENTRE_NAME = 14;
    public static final int BAGGAGE_WEIGHT_LIMIT = 16;


    //rest TRIP_TYPES_OF_FOOD
    public static final int HOTEL_NAME = 14;
    public static final int HOTEL_LEVEL = 16;


    /// cruise TRIP_TYPES_OF_FOOD
    public static final int SHIP_NAME = 14;
    public static final int DAILY_TIPS = 16;
    public static final int NUMBER_OF_PORTS_TO_VISIT = 18;
    public static final int CRUISE_TYPE = 20;


    ///medical TRIP_TYPES_OF_FOOD
    public static final int TYPE_OF_INHALATION_TREATMENT = 14;
    public static final int VISIT_SWIMMIN_POOL_TIMES_TIMES_PER_RELAX_PERIOD = 16;
    public static final int ELECTRO_THERAPY_COUNT_PER_RELAX_PERIOD = 18;
    public static final int PHYSIOTHERAPY_TYPE = 20;
    public static final int MANUAL_MASSAGE_TYPE = 22;
    public static final int BALNEOTHERAPY_TYPE = 24;
    public static final int HEAT_MUD_THERAPY_TYPE = 26;


    //excursion TRIP_TYPES_OF_FOOD
    public static final int COUNT_OF_EXCURSIONS = 14;
    public static final int EXCURSION_PLACE_NAME = 16;


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // FOR ALL TRIP RESTRICTIONS

    public static final String[] TRIP_TRANSPORT_TYPES = Arrays.stream(TripTransportType.values()).map(Enum::name).toArray(String[]::new);
    public static final String[] TRIP_TYPES_OF_FOOD = Arrays.stream(TripTypeOfFood.values()).map(Enum::toString).toArray(String[]::new);
    public static final String[] TRIP_LOCATIONS = Arrays.stream(TripLocation.values()).map(Enum::name).toArray(String[]::new);

    ////////////////////////////


    public static double getMinCost() {
        return minCost;
    }

    public static double getMaxCost() {
        return maxCost;
    }
    ////////////////////////////


    public static int getMinDayCount() {
        return minDayCount;
    }

    public static int getMaxDayCount() {
        return maxDayCount;
    }
    ////////////////////////////

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////REST TRIP  restrictions

    public static final int REST_TRIP_ARGUMENTS_COUNT = 17;


    public static final String[] REST_TRIP_HOTELS_NAMES = Arrays.stream(RestTripHotelName.values()).map(Enum::toString).toArray(String[]::new);

    ////////////////////////////


    public static int getMinHotelLevel() {
        return minHotelLevel;
    }

    public static int getMaxHotelLevel() {
        return maxHotelLevel;
    }
    ////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///// SHOPPING TRIP RESTRICTIONS

    public static final int SHOPPING_TRIP_ARGUMENTS_COUNT = 17;


    public static final String[] SHOPPING_TRIP_CENTRE_NAMES = Arrays.stream(ShoppingTripShopCentreName.values()).map(Enum::name).toArray(String[]::new);

    ////////////////////////////

    public static double getMaxBaggageWeight() {
        return maxBaggageWeight;
    }
    ////////////////////////////

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //// CRUISE TRIP RESTRICTIONS

    public static final int CRUISE_TRIP_ARGUMENTS_COUNT = 21;


    public static final String[] CRUISE_TRIP_TYPES = Arrays.stream(CruiseTripTypes.values()).map(Enum::name).toArray(String[]::new);
    public static final String[] CRUISE_TRIP_SHIP_NAMES = Arrays.stream(CruiseTripShipName.values()).map(Enum::name).toArray(String[]::new);

    ////////////////////////////


    public static double getMinDailyTips() {
        return minDailyTips;
    }

    public static double getMaxDailyTips() {
        return maxDailyTips;
    }
    ////////////////////////////


    public static int getMinNumberPortsToVisit() {
        return minNumberPortsToVisit;
    }

    public static int getMaxNumberPortsToVisit() {
        return maxNumberPortsToVisit;
    }
    ////////////////////////////

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///MEDICAL TRIP RESTRICTIONS

    public static final int MEDICAL_TRIP_ARGUMENTS_COUNT = 27;


    public static final String[] MEDICAL_TRIP_BALNEOTHERAPY_TYPES = Arrays.stream(MedicalTripBalneotherapyType.values()).map(Enum::name).toArray(String[]::new);
    public static final String[] MEDICAL_TRIP_HEAT_MUD_THERAPY_TYPES = Arrays.stream(MedicalTripHeatMudTherapyType.values()).map(Enum::name).toArray(String[]::new);
    public static final String[] MEDICAL_TRIP_MANUAL_MASSAGE_TYPES = Arrays.stream(MedicalTripManualMassageType.values()).map(Enum::name).toArray(String[]::new);
    public static final String[] MEDICAL_TRIP_PHYSIO_THERAPY_TYPES = Arrays.stream(MedicalTripPhysiotherapyType.values()).map(Enum::name).toArray(String[]::new);
    public static final String[] MEDICAL_TRIP_TYPES_OF_INHALATION_TREATMET = Arrays.stream(MedicalTripTypeOfInhalationTreatment.values()).map(Enum::name).toArray(String[]::new);

    ////////////////////////////


    public static int getMinNumberOfVisitSwimmingPoolTimesPerRelaxPeriod() {
        return minNumberOfVisitSwimmingPoolTimesPerRelaxPeriod;
    }

    public static int getMaxNumberOfVisitSwimmingPoolTimesPerRelaxPeriod() {
        return maxNumberOfVisitSwimmingPoolTimesPerRelaxPeriod;
    }
    ////////////////////////////


    public static int getMinNumberOfElectrotherapyProcedurePerRelaxPeriod() {
        return minNumberOfElectrotherapyProcedurePerRelaxPeriod;
    }

    public static int getMaxNumberOfElectrotherapyProcedurePerRelaxPeriod() {
        return maxNumberOfElectrotherapyProcedurePerRelaxPeriod;
    }
    ////////////////////////////

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////EXCURSION TRIP RESTRICTIONS

    public static final int EXCURSION_TRIP_ARGUMENTS_COUNT = 17;

    public static final String[] EXCURSION_TRIP_PLACE_NAMES = Arrays.stream(ExcursionTripPlaceName.values()).map(Enum::name).toArray(String[]::new);

    ////////////////////////////


    public static int getMinCountOfExcursions() {
        return minCountOfExcursions;
    }

    public static int getMaxCountOfExcursions() {
        return maxCountOfExcursions;
    }
    ////////////////////////////


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    private TripConfiguration() {
    }

    /**
     * Class for read trip restriction from file.
     * This class encapsulation all property read logic.
     */
    private static final class RestrictionPropertyReader {

        /**
         * path to property file
         */
        private static final String RESTRICTIONS_PROPERTIES_PATH = "src/main/resources/restrictions.properties";

        private static void readRestrictions() throws ReadRestrictionsException {

            try {
                final InputStream fileInputStream = new FileInputStream(RESTRICTIONS_PROPERTIES_PATH);

                final Properties properties = new Properties();

                properties.load(fileInputStream);

                minCost = Double.parseDouble(properties.getProperty("minCost"));
                maxCost = Double.parseDouble(properties.getProperty("maxCost"));

                minDayCount = Integer.parseInt(properties.getProperty("minDayCount"));
                maxDayCount = Integer.parseInt(properties.getProperty("maxDayCount"));

                minHotelLevel = Integer.parseInt(properties.getProperty("minHotelLevel"));
                maxHotelLevel = Integer.parseInt(properties.getProperty("maxHotelLevel"));

                maxBaggageWeight = Double.parseDouble(properties.getProperty("maxBaggageWeight"));

                minDailyTips = Double.parseDouble(properties.getProperty("minDailyTips"));
                maxDailyTips = Double.parseDouble(properties.getProperty("maxDailyTips"));

                minNumberPortsToVisit = Integer.parseInt(properties.getProperty("minNumberPortsToVisit"));
                maxNumberPortsToVisit = Integer.parseInt(properties.getProperty("maxNumberPortsToVisit"));

                minNumberOfVisitSwimmingPoolTimesPerRelaxPeriod = Integer.parseInt(properties.getProperty("minNumberOfVisitSwimmingPoolTimesPerRelaxPeriod"));
                maxNumberOfVisitSwimmingPoolTimesPerRelaxPeriod = Integer.parseInt(properties.getProperty("maxNumberOfVisitSwimmingPoolTimesPerRelaxPeriod"));

                minNumberOfElectrotherapyProcedurePerRelaxPeriod = Integer.parseInt(properties.getProperty("minNumberOfElectrotherapyProcedurePerRelaxPeriod"));
                maxNumberOfElectrotherapyProcedurePerRelaxPeriod = Integer.parseInt(properties.getProperty("maxNumberOfElectrotherapyProcedurePerRelaxPeriod"));

                minCountOfExcursions = Integer.parseInt(properties.getProperty("minCountOfExcursions"));
                maxCountOfExcursions = Integer.parseInt(properties.getProperty("maxCountOfExcursions"));

            } catch (NumberFormatException ex) {
                throw new ReadRestrictionsException("File contains bad restriction! Try to fix it: " + ex.getMessage());
            } catch (IOException ex) {
                throw new ReadRestrictionsException("Can`t read restrictions from file path{" + RESTRICTIONS_PROPERTIES_PATH + "}. " + ex.getMessage());
            }
        }
    }


    private static double minCost = 500;
    private static double maxCost = 100_000_000;

    private static int minDayCount = 3;
    private static int maxDayCount = 210;

    private static int minHotelLevel = 1;
    private static int maxHotelLevel = 5;

    private static double maxBaggageWeight = 55;

    private static double minDailyTips = 10.0;
    private static double maxDailyTips = 5000.0;

    private static int minNumberPortsToVisit = 2;
    private static int maxNumberPortsToVisit = 16;

    private static int minNumberOfVisitSwimmingPoolTimesPerRelaxPeriod = 2;
    private static int maxNumberOfVisitSwimmingPoolTimesPerRelaxPeriod = 50;

    private static int minNumberOfElectrotherapyProcedurePerRelaxPeriod = 2;
    private static int maxNumberOfElectrotherapyProcedurePerRelaxPeriod = 21;

    private static int minCountOfExcursions = 0;
    private static int maxCountOfExcursions = 12;


}
