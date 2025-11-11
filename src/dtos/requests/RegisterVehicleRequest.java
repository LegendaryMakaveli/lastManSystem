package dtos.requests;

import data.models.Gender;
import java.time.Year;

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

    public String getVehicleChasisNumber() {
        return vehicleChasisNumber;
    }

    public void setVehicleChasisNumber(String vehicleChasisNumber) {
        this.vehicleChasisNumber = vehicleChasisNumber;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleColour() {
        return vehicleColour;
    }

    public void setVehicleColour(String vehicleColour) {
        this.vehicleColour = vehicleColour;
    }

    public Year getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Year productionYear) {
        this.productionYear = productionYear;
    }

    public String getOwnerFullName() {
        return ownerFullName;
    }

    public void setOwnerFullName(String ownerFullName) {
        this.ownerFullName = ownerFullName;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getOwnerPhoneNumber() {
        return ownerPhoneNumber;
    }

    public void setOwnerPhoneNumber(String ownerPhoneNumber) {
        this.ownerPhoneNumber = ownerPhoneNumber;
    }

    public Gender getOwnerGender() {
        return ownerGender;
    }

    public void setOwnerGender(Gender ownerGender) {
        this.ownerGender = ownerGender;
    }
}
