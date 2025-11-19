package TrafficSystemProjects.dtos.responses;

import TrafficSystemProjects.data.models.Offense;
import lombok.Data;

@Data
public class ViewTicketResponse {
    private String ticketId;
    private String vehicleDetails;
    private String OwnerName;
    private Offense offense;
    private boolean hasPaid;
}
