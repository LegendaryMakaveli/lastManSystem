package TrafficSystemProjects.dtos.requests;

import TrafficSystemProjects.data.models.Offense;
import lombok.Data;


@Data
public class BookTicketRequest {
    private String offenderVehicleName;
    private String offenderVehicleModel;
    private String offenderVehicleyear;
    private String offenderVehicleChasisNumber;
    private String IssuerOfficerId;
    private boolean hasPaid;
    private Offense offense;

}
