package dtos.requests;

import data.models.Offense;
import java.time.Year;

public class BookTicketRequest {
    private String offenderVehicleName;
    private String offenderVehicleModel;
    private Year offenderVehicleyear;
    private String offenderVehicleChasisNumber;
    private String IssuerOfficerId;
    private Offense offense;

    public String getIssuerOfficerId() {
        return IssuerOfficerId;
    }

    public void setIssuerOfficerId(String issuerOfficerId) {
        IssuerOfficerId = issuerOfficerId;
    }

    public Offense getOffense() {
        return offense;
    }

    public void setOffense(Offense offense) {
        this.offense = offense;
    }

    public String getOffenderVehicleName() {
        return offenderVehicleName;
    }

    public void setOffenderVehicleName(String offenderVehicleName) {
        this.offenderVehicleName = offenderVehicleName;
    }

    public String getOffenderVehicleModel() {
        return offenderVehicleModel;
    }

    public void setOffenderVehicleModel(String offenderVehicleModel) {
        this.offenderVehicleModel = offenderVehicleModel;
    }

    public Year getOffenderVehicleyear() {
        return offenderVehicleyear;
    }

    public void setOffenderVehicleyear(Year offenderVehicleyear) {
        this.offenderVehicleyear = offenderVehicleyear;
    }

    public String getOffenderVehicleChasisNumber() {
        return offenderVehicleChasisNumber;
    }

    public void setOffenderVehicleChasisNumber(String offenderVehicleChasisNumber) {
        this.offenderVehicleChasisNumber = offenderVehicleChasisNumber;
    }
}
