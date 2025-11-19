package TrafficSystemProjects.dtos.responses;

import lombok.Data;

@Data
public class RegisterVehicleResponse {
    private String VehicleId;
    private String VehicleDetails;
    private String OwnerName;
    private String registrationDate;
}
