package TrafficSystemProjects.dtos.responses;

import lombok.Data;

@Data
public class ViewAllVehicleTicketsResponse {
    private String ticketId;
    private String offense;
    private String vehicleDetails;
    private String ownerName;
    private String hasPaid;
}
