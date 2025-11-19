package TrafficSystemProjects.controllers;

import TrafficSystemProjects.dtos.requests.RegisterVehicleRequest;
import TrafficSystemProjects.dtos.responses.RegisterVehicleResponse;
import TrafficSystemProjects.services.VehicleService;
import TrafficSystemProjects.services.VehicleServiceImple;

public class VehicleController {
    private VehicleService vehicleService = new VehicleServiceImple();

    public RegisterVehicleResponse registerVehicle(RegisterVehicleRequest request){
        return vehicleService.registerVehicle(request);
    }
}
