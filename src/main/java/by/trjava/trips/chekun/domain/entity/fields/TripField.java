package by.trjava.trips.chekun.domain.entity.fields;

import java.util.HashMap;
import java.util.Map;

public final class TripField {

    public static Class<? extends Enum<?>> getEnumWithTripFields(final String name) {
        return ENUMS_MAP.get(name);
    }

    public static enum Trip {
        ID,
        NAME,
        TRANSPORT_TYPE,
        TYPE_OF_FOOD,
        TRIP_LOCATION,
        DAY_COUNT,
        COST,
    }

    public static enum RestTrip {
//        TRANSPORT_TYPE,
//        TYPE_OF_FOOD,
//        TRIP_LOCATION,
//        DAY_COUNT,
//        COST,

        HOTEL_NAME,
        HOTEL_LEVEL
    }


    public static enum ShoppingTrip {
//        TRANSPORT_TYPE,
//        TYPE_OF_FOOD,
//        TRIP_LOCATION,
//        DAY_COUNT,
//        COST,

        SHOP_CENTRE_NAME,
        BAGGAGE_WEIGHT_LIMIT
    }

    public static enum MedicalTrip {
//        TRANSPORT_TYPE,
//        TYPE_OF_FOOD,
//        TRIP_LOCATION,
//        DAY_COUNT,
//        COST,

        TYPE_OF_INHALATION_TREATMENT,
        VISIT_SWIMMIN_POOL_TIMES_TIMES_PER_RELAX_PERIOD,
        ELECTRO_THERAPY_COUNT_PER_RELAX_PERIOD,
        PHYSIOTHERAPY_TYPE,
        MANUAL_MASSAGE_TYPE,
        BALNEOTHERAPY_TYPE,
        HEAT_MUD_THERAPY_TYPE

    }

    public static enum ExcursionTrip {
//        TRANSPORT_TYPE,
//        TYPE_OF_FOOD,
//        TRIP_LOCATION,
//        DAY_COUNT,
//        COST,

        COUNT_OF_EXCURSIONS, EXCURSION_PLACE_NAME
    }

    public static enum CruiseTrip {
//        TRANSPORT_TYPE,
//        TYPE_OF_FOOD,
//        TRIP_LOCATION,
//        DAY_COUNT,
//        COST,

        SHIP_NAME,
        DAILY_TIPS,
        NUMBER_OF_PORTS_TO_VISIT,
        CRUISE_TYPE
    }


    //Map contain 1.Name of enum with types of fields of classes 2. References on all enums
    private static final Map<String, Class<? extends Enum<?>>> ENUMS_MAP = new HashMap<>();

    //there in static block init i put all names of enums and references on this enums
    static {
        ENUMS_MAP.put(TripField.RestTrip.class.getSimpleName(), TripField.RestTrip.class);
        ENUMS_MAP.put(TripField.ShoppingTrip.class.getSimpleName(), TripField.ShoppingTrip.class);
        ENUMS_MAP.put(TripField.MedicalTrip.class.getSimpleName(), TripField.MedicalTrip.class);
        ENUMS_MAP.put(TripField.ExcursionTrip.class.getSimpleName(), TripField.ExcursionTrip.class);
        ENUMS_MAP.put(TripField.CruiseTrip.class.getSimpleName(), TripField.CruiseTrip.class);
    }


    private TripField() {
    }
}
