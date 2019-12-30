package by.trjava.trips.chekun.domain.entity.fieldsrestriction.resttrip;

public enum RestTripHotelName {

    MINSK_PRESIDENT_HOTEL("President_hotel"),
    MINSK_HOTEL_EAST_TIME("Hotel_East_Time"),
    OSLO_THON_HOTEL_STORO("Thon_Hotel_Storo"),
    OSLO_CAMILLAS_HUS("Camillas_Hus"),
    PARIS_LE_SHANGRI_LA_HOTEL("Le_Shangri-La_Hôtel"),
    PARIS_GEORGE_V("George_V"), //(Париж)
    CANADA_FAIRMONT_LE_CHATEAU_FRONTENAC("Fairmont_Le_Chateau_Frontenac"),
    IBISA_HACIENDA_NA_XAMENA("Hacienda_Na_Xamena"),
    MAJORKA_HOSPES_MARICIEL_SPA("Hospes_Mariciel&Spa"),
    NEW_YORK_CONCORDE_HOTEL("Concorde_Hotel"),
    NEW_YORK_LUMA_HOTEL("Luma_Hotel");


    private String name;

    private RestTripHotelName(final String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return this.name;
    }
}
