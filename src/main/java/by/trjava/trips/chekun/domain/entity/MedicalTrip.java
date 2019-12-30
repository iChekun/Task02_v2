package by.trjava.trips.chekun.domain.entity;

public class MedicalTrip extends Trip {

    private String typeOfInhalationTreatment;

    private int visitSwimmingPoolTimesPerRelaxPeriod;

    private int electrotherapyCountPerRelaxPeriod;

    private String physiotherapyType;

    private String manualMassageType;

    private String balneotherapyType;

    private String heatMudTherapyType;


    public MedicalTrip() {
        super(MedicalTrip.class.getSimpleName());
    }

    public MedicalTrip(int id, String transportType, String typeOfFood, String country, int dayCount, double cost,
                       String typeOfInhalationTreatment, int visitSwimmingPoolTimesPerRelaxPeriod, int electrotherapyCountPerRelaxPeriod,
                       String physiotherapyType, String manualMassageType, String balneotherapyType, String heatMudTherapyType) {

        super(id, MedicalTrip.class.getSimpleName(), transportType, typeOfFood, country, dayCount, cost);

        this.typeOfInhalationTreatment = typeOfInhalationTreatment;
        this.visitSwimmingPoolTimesPerRelaxPeriod = visitSwimmingPoolTimesPerRelaxPeriod;
        this.electrotherapyCountPerRelaxPeriod = electrotherapyCountPerRelaxPeriod;
        this.physiotherapyType = physiotherapyType;
        this.manualMassageType = manualMassageType;
        this.balneotherapyType = balneotherapyType;
        this.heatMudTherapyType = heatMudTherapyType;
    }

    public String getTypeOfInhalationTreatment() {
        return typeOfInhalationTreatment;
    }

    public void setTypeOfInhalationTreatment(String typeOfInhalationTreatment) {
        this.typeOfInhalationTreatment = typeOfInhalationTreatment;
    }

    public int getVisitSwimmingPoolTimesPerRelaxPeriod() {
        return visitSwimmingPoolTimesPerRelaxPeriod;
    }

    public void setVisitSwimmingPoolTimesPerRelaxPeriod(int visitSwimmingPoolTimesPerRelaxPeriod) {
        this.visitSwimmingPoolTimesPerRelaxPeriod = visitSwimmingPoolTimesPerRelaxPeriod;
    }

    public int getElectrotherapyCountPerRelaxPeriod() {
        return electrotherapyCountPerRelaxPeriod;
    }

    public void setElectrotherapyCountPerRelaxPeriod(int electrotherapyCountPerRelaxPeriod) {
        this.electrotherapyCountPerRelaxPeriod = electrotherapyCountPerRelaxPeriod;
    }

    public String getPhysiotherapyType() {
        return physiotherapyType;
    }

    public void setPhysiotherapyType(String physiotherapyType) {
        this.physiotherapyType = physiotherapyType;
    }

    public String getManualMassageType() {
        return manualMassageType;
    }

    public void setManualMassageType(String manualMassageType) {
        this.manualMassageType = manualMassageType;
    }

    public String getBalneotherapyType() {
        return balneotherapyType;
    }

    public void setBalneotherapyType(String balneotherapyType) {
        this.balneotherapyType = balneotherapyType;
    }

    public String getHeatMudTherapyType() {
        return heatMudTherapyType;
    }

    public void setHeatMudTherapyType(String heatMudTherapyType) {
        this.heatMudTherapyType = heatMudTherapyType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }

        MedicalTrip medicalTrip = (MedicalTrip) obj;

        return (typeOfInhalationTreatment == medicalTrip.typeOfInhalationTreatment || (typeOfInhalationTreatment != null && typeOfInhalationTreatment.equalsIgnoreCase(medicalTrip.typeOfInhalationTreatment)))
                && (physiotherapyType == medicalTrip.physiotherapyType || (physiotherapyType != null && physiotherapyType.equalsIgnoreCase(medicalTrip.physiotherapyType)))
                && (manualMassageType == medicalTrip.manualMassageType || (manualMassageType != null && manualMassageType.equalsIgnoreCase(medicalTrip.manualMassageType)))
                && (balneotherapyType == medicalTrip.balneotherapyType || (balneotherapyType != null && balneotherapyType.equalsIgnoreCase(medicalTrip.balneotherapyType)))
                && (heatMudTherapyType == medicalTrip.heatMudTherapyType || (heatMudTherapyType != null && heatMudTherapyType.equalsIgnoreCase(medicalTrip.heatMudTherapyType)))
                && visitSwimmingPoolTimesPerRelaxPeriod == medicalTrip.visitSwimmingPoolTimesPerRelaxPeriod
                && electrotherapyCountPerRelaxPeriod == medicalTrip.electrotherapyCountPerRelaxPeriod;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        return (int) (hash * 31 + (visitSwimmingPoolTimesPerRelaxPeriod + electrotherapyCountPerRelaxPeriod
                + (typeOfInhalationTreatment == null ? 0 : typeOfInhalationTreatment.hashCode())
                + (physiotherapyType == null ? 0 : physiotherapyType.hashCode())
                + (manualMassageType == null ? 0 : manualMassageType.hashCode())
                + (balneotherapyType == null ? 0 : balneotherapyType.hashCode())
                + (heatMudTherapyType == null ? 0 : heatMudTherapyType.hashCode())));
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " : "
                + super.toString() +
                ", TYPE_OF_INHALATION_TREATMENT=" + typeOfInhalationTreatment +
                ", VISIT_SWIMMIN_POOL_TIMES_TIMES_PER_RELAX_PERIOD=" + visitSwimmingPoolTimesPerRelaxPeriod +
                ", ELECTRO_THERAPY_COUNT_PER_RELAX_PERIOD=" + electrotherapyCountPerRelaxPeriod +
                ", PHYSIOTHERAPY_TYPE=" + physiotherapyType +
                ", MANUAL_MASSAGE_TYPE=" + manualMassageType +
                ", BALNEOTHERAPY_TYPE=" + balneotherapyType +
                ", HEAT_MUD_THERAPY_TYPE=" + heatMudTherapyType + ";";

    }
}
