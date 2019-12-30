package by.trjava.trips.chekun.domain.service.impl;


import by.trjava.trips.chekun.domain.service.exception.ConfigurationServiceException;
import by.trjava.trips.chekun.domain.configuration.TripConfiguration;
import by.trjava.trips.chekun.domain.service.TripConfigurationService;
import by.trjava.trips.chekun.domain.util.exception.ReadRestrictionsException;

public class TripConfigurationServiceImpl implements TripConfigurationService {


    public TripConfigurationServiceImpl() { }


    @Override
    public void readRestrictions() throws ConfigurationServiceException {
        try {
            TripConfiguration.readRestrictions();
        } catch (ReadRestrictionsException e) {
            throw new ConfigurationServiceException("TripConfigurationService can`t get trip restrictions: " + e.getMessage());
        }
    }

    @Override
    public double getMinCost() {
        return TripConfiguration.getMinCost();
    }

    @Override
    public double getMaxCost() {
        return TripConfiguration.getMaxCost();
    }


    @Override
    public int getMinDayCount() {
        return TripConfiguration.getMinDayCount();
    }

    @Override
    public int getMaxDayCount() {
        return TripConfiguration.getMaxDayCount();
    }


    @Override
    public int getMinHotelLevel() {
        return TripConfiguration.getMinHotelLevel();
    }

    @Override
    public int getMaxHotelLevel() {
        return TripConfiguration.getMaxHotelLevel();
    }


    @Override
    public double getMaxBaggageWeight() {
        return TripConfiguration.getMaxBaggageWeight();
    }


    @Override
    public double getMinDailyTips() {
        return TripConfiguration.getMinDailyTips();
    }

    @Override
    public double getMaxDailyTips() {
        return TripConfiguration.getMaxDailyTips();
    }


    @Override
    public int getMinNumberPortsToVisit() {
        return TripConfiguration.getMinNumberPortsToVisit();
    }

    @Override
    public int getMaxNumberPortsToVisit() {
        return TripConfiguration.getMaxNumberPortsToVisit();
    }


    @Override
    public int getMinNumberOfVisitSwimmingPoolTimesPerRelaxPeriod() {
        return TripConfiguration.getMinNumberOfVisitSwimmingPoolTimesPerRelaxPeriod();
    }

    @Override
    public int getMaxNumberOfVisitSwimmingPoolTimesPerRelaxPeriod() {
        return TripConfiguration.getMaxNumberOfVisitSwimmingPoolTimesPerRelaxPeriod();
    }


    @Override
    public int getMinNumberOfElectrotherapyProcedurePerRelaxPeriod() {
        return TripConfiguration.getMinNumberOfElectrotherapyProcedurePerRelaxPeriod();
    }

    @Override
    public int getMaxNumberOfElectrotherapyProcedurePerRelaxPeriod() {
        return TripConfiguration.getMaxNumberOfElectrotherapyProcedurePerRelaxPeriod();
    }

    @Override
    public int getMinCountOfExcursions() {
        return TripConfiguration.getMinCountOfExcursions();
    }

    @Override
    public int getMaxCountOfExcursions() {
        return TripConfiguration.getMaxCountOfExcursions();
    }


}
