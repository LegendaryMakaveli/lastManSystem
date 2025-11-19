package TrafficSystemProjects.dtos.requests;

import lombok.Data;

@Data
public class ViewTicketRequest {
    private String IssuerOfficerId;
    private String TicketId;

}
