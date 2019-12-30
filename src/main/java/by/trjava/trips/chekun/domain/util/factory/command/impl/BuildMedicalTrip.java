package by.trjava.trips.chekun.domain.util.factory.command.impl;

import by.trjava.trips.chekun.domain.entity.MedicalTrip;
import by.trjava.trips.chekun.domain.util.factory.command.TripBuildingCommand;

import static by.trjava.trips.chekun.domain.configuration.TripConfiguration.*;

public class BuildMedicalTrip implements TripBuildingCommand {

    private MedicalTrip medicalTrip;

    public BuildMedicalTrip(final MedicalTrip medicalTrip) {
        this.medicalTrip = medicalTrip;
    }


    @Override
    public void execute(final String[] parameters) {
        BuildTrip buildTrip = new BuildTrip(medicalTrip);
        buildTrip.execute(parameters);

        medicalTrip.setTypeOfInhalationTreatment(parameters[TYPE_OF_INHALATION_TREATMENT]);
        medicalTrip.setVisitSwimmingPoolTimesPerRelaxPeriod(Integer.parseInt(parameters[VISIT_SWIMMIN_POOL_TIMES_TIMES_PER_RELAX_PERIOD]));
        medicalTrip.setElectrotherapyCountPerRelaxPeriod(Integer.parseInt(parameters[ELECTRO_THERAPY_COUNT_PER_RELAX_PERIOD]));
        medicalTrip.setPhysiotherapyType(parameters[PHYSIOTHERAPY_TYPE]);
        medicalTrip.setManualMassageType(parameters[MANUAL_MASSAGE_TYPE]);
        medicalTrip.setBalneotherapyType(parameters[BALNEOTHERAPY_TYPE]);
        medicalTrip.setHeatMudTherapyType(parameters[HEAT_MUD_THERAPY_TYPE]);
    }
}
