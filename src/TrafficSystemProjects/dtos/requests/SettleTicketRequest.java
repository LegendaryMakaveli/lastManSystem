package TrafficSystemProjects.dtos.requests;

import lombok.Data;

@Data
public class SettleTicketRequest {
    private String IssuerOfficerId;
    private String ticketId;
    private boolean hasPaid;
}
