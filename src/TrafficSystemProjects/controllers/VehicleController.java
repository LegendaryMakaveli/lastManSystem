package TrafficSystemProjects.controllers;

import TrafficSystemProjects.dtos.requests.RegisterVehicleRequest;
import TrafficSystemProjects.dtos.responses.RegisterVehicleResponse;
import TrafficSystemProjects.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping( "/vehicle/register")
    public RegisterVehicleResponse registerVehicle(@RequestBody RegisterVehicleRequest request){
        return vehicleService.registerVehicle(request);
    }
}
