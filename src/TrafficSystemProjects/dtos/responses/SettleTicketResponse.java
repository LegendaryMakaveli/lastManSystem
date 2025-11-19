package TrafficSystemProjects.dtos.responses;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class SettleTicketResponse {
    private String ticketId;
    private String vehicleDetails;
    private double amount;
    private LocalDateTime settleDate;
}
