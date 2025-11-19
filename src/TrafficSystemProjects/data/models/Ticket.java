package TrafficSystemProjects.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "Tickets")
public class Ticket {
    @Id
    private String id;
    private Vehicle vehicle;
    @DBRef
    private Officer officer;
    @DBRef
    private Offense offense;
    private boolean hasPaid;
    private double amount;
    private LocalDateTime dateOfBooking;
    private LocalDateTime dateOfPayment;
}
