package utils;

import data.models.Owner;
import data.models.Vehicle;
import dtos.requests.RegisterVehicleRequest;

public class Mapper {

    public static Vehicle map(RegisterVehicleRequest request){
        Vehicle vehicle = new Vehicle("Toyota", "Camry", "black");
        vehicle.setName(request.getVehicleName());
        vehicle.setColour(request.getVehicleColour());
        vehicle.setModel(request.getVehicleModel());
        vehicle.setYear(request.getProductionYear());
        vehicle.setChasisNumber(request.getVehicleChasisNumber());

        Owner owner = new Owner();
        owner.setFullName(request.getOwnerFullName());
        owner.setAddress(request.getOwnerAddress());
        owner.setGender(request.getOwnerGender());
        owner.setPhoneNumber(request.getOwnerPhoneNumber());

        vehicle.setOwner(owner);
        return vehicle;
    }
}
