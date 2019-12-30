package by.trjava.trips.chekun.domain.util.validator.command.impl;

import java.util.Arrays;

import static by.trjava.trips.chekun.domain.configuration.TripConfiguration.*;
import static by.trjava.trips.chekun.domain.configuration.TripConfiguration.HEAT_MUD_THERAPY_TYPE;

public class MedicalTripValidatorCommand implements by.trjava.trips.chekun.domain.util.validator.command.TripValidatorCommand {

    @Override
    public boolean validate(final String[] values) {
        boolean result = false;

        if (values.length == MEDICAL_TRIP_ARGUMENTS_COUNT) {
            TripValidatorCommand tripValidatorCommand = new TripValidatorCommand();

            result =   tripValidatorCommand.validate(values)
                    && isTypeOfInhalationTreatmentCorrect(values[TYPE_OF_INHALATION_TREATMENT])
                    && isVisitSwimmingPoolTimesPerRelaxPeriodCorrect(values[VISIT_SWIMMIN_POOL_TIMES_TIMES_PER_RELAX_PERIOD])
                    && isElectrotherapyCountPerRelaxPeriodCorrect(values[ELECTRO_THERAPY_COUNT_PER_RELAX_PERIOD])
                    && isPhysiotherapyTypeCorrect(values[PHYSIOTHERAPY_TYPE])
                    && isManualMassageTypeCorrect(values[MANUAL_MASSAGE_TYPE])
                    && isBalneotherapyTypeCorrect(values[BALNEOTHERAPY_TYPE])
                    && isHeatMudTherapyTypeCorrect(values[HEAT_MUD_THERAPY_TYPE]);
        }
        return result;
    }

    private boolean isHeatMudTherapyTypeCorrect(final String value) {
        return Arrays.stream(MEDICAL_TRIP_HEAT_MUD_THERAPY_TYPES).anyMatch(s -> s.equalsIgnoreCase(value));
    }

    private boolean isBalneotherapyTypeCorrect(final String value) {
        return Arrays.stream(MEDICAL_TRIP_BALNEOTHERAPY_TYPES).anyMatch(s -> s.equalsIgnoreCase(value));
    }

    private boolean isManualMassageTypeCorrect(final String value) {
        return Arrays.stream(MEDICAL_TRIP_MANUAL_MASSAGE_TYPES).anyMatch(s -> s.equalsIgnoreCase(value));
    }

    private boolean isPhysiotherapyTypeCorrect(final String value) {
        return Arrays.stream(MEDICAL_TRIP_PHYSIO_THERAPY_TYPES).anyMatch(s -> s.equalsIgnoreCase(value));
    }

    private boolean isElectrotherapyCountPerRelaxPeriodCorrect(final String value) {
        try {
            final int  electrotherapyCountPerRest = Integer.parseInt(value);
            return     electrotherapyCountPerRest >= getMinNumberOfElectrotherapyProcedurePerRelaxPeriod()
                    && electrotherapyCountPerRest <= getMaxNumberOfElectrotherapyProcedurePerRelaxPeriod();
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private boolean isVisitSwimmingPoolTimesPerRelaxPeriodCorrect(final String value) {
        try {
            final int  visitSwimmingPoolTimesPerRelaxPeriod = Integer.parseInt(value);
            return     visitSwimmingPoolTimesPerRelaxPeriod >= getMinNumberOfVisitSwimmingPoolTimesPerRelaxPeriod()
                    && visitSwimmingPoolTimesPerRelaxPeriod <= getMaxNumberOfVisitSwimmingPoolTimesPerRelaxPeriod();
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private boolean isTypeOfInhalationTreatmentCorrect(final String value) {
        return Arrays.stream(MEDICAL_TRIP_TYPES_OF_INHALATION_TREATMET).anyMatch(s -> s.equalsIgnoreCase(value));
    }
}
