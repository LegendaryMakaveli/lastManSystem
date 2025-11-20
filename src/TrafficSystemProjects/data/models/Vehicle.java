package TrafficSystemProjects.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
@Data
@Document(collection = "Vehicles")
public class Vehicle {
    @Id
    private String id;
    private String name;
    private String model;
    private String colour;
    private String year;
    private String chasisNumber;
    private String plateNumber;
    private Owner owner;
    private LocalDateTime registrationDate;
    private List<Ticket> tickets;
}
