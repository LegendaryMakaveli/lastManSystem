package TrafficSystemProjects.dtos.requests;

import TrafficSystemProjects.data.models.Gender;
import lombok.Data;

import java.time.Year;

@Data
public class RegisterVehicleRequest {
    private String vehicleName;
    private String vehicleModel;
    private String vehicleColour;
    private String vehicleChasisNumber;
    private Year productionYear;
    private String ownerFullName;
    private String ownerAddress;
    private String ownerPhoneNumber;
    private Gender ownerGender;
    private String registrationDate;
}
