package dtos.responses;

import java.time.LocalDateTime;

public class RegisterVehicleResponse {
    private String VehicleId;
    private String VehicleDetails;
    private String OwnerName;
    private LocalDateTime registrationDate = LocalDateTime.now();

    @Override
    public String toString() {
        return "RegisterVehicleResponse{" +
                "VehicleId='" + VehicleId + '\'' +
                ", VehicleDetails='" + VehicleDetails + '\'' +
                ", OwnerName='" + OwnerName + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }

    public String getVehicleId() {
        return VehicleId;
    }

    public void setVehicleId(String vehicleId) {
        VehicleId = vehicleId;
    }

    public String getVehicleDetails() {
        return VehicleDetails;
    }

    public void setVehicleDetails(String vehicleDetails) {
        VehicleDetails = vehicleDetails;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
}
