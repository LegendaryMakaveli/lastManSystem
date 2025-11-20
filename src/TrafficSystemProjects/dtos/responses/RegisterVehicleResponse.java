package TrafficSystemProjects.dtos.responses;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegisterVehicleResponse {
    private String VehicleId;
    private String VehicleDetails;
    private String OwnerName;
    private LocalDateTime registrationDate;
}
