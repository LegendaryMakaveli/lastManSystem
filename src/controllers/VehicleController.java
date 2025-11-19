package controllers;

import dtos.requests.RegisterVehicleRequest;
import dtos.responses.RegisterVehicleResponse;
import services.VehicleService;
import services.VehicleServiceImple;

public class VehicleController {
    private VehicleService vehicleService = new VehicleServiceImple();

    public RegisterVehicleResponse registerVehicle(RegisterVehicleRequest request){
        return vehicleService.registerVehicle(request);
    }
}
