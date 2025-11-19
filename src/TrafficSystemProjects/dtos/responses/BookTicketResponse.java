package TrafficSystemProjects.dtos.responses;

import TrafficSystemProjects.data.models.Offense;
import TrafficSystemProjects.data.models.Officer;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class BookTicketResponse {
    private String TicketId;
    private double Amount;
    private Officer issuer;
    private Offense offense;
    private LocalDateTime issueDate;
}
