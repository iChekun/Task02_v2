package by.trjava.trips.chekun.domain.service;

import by.trjava.trips.chekun.domain.service.exception.ConfigurationServiceException;
import by.trjava.trips.chekun.domain.util.exception.ReadRestrictionsException;

public interface TripConfigurationService {

    public void readRestrictions() throws ConfigurationServiceException;


    public double getMinCost();
    public double getMaxCost();


    public int getMinDayCount();
    public int getMaxDayCount();


    public int getMinHotelLevel();
    public int getMaxHotelLevel();


    public double getMaxBaggageWeight();


    public double getMinDailyTips();
    public double getMaxDailyTips();


    public int getMinNumberPortsToVisit();
    public int getMaxNumberPortsToVisit();


    public int getMinNumberOfVisitSwimmingPoolTimesPerRelaxPeriod();
    public int getMaxNumberOfVisitSwimmingPoolTimesPerRelaxPeriod();


    public int getMinNumberOfElectrotherapyProcedurePerRelaxPeriod();
    public int getMaxNumberOfElectrotherapyProcedurePerRelaxPeriod();


    public int getMinCountOfExcursions();
    public int getMaxCountOfExcursions();


}
