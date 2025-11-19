package TrafficSystemProjects.services;

import TrafficSystemProjects.dtos.requests.RegisterVehicleRequest;
import TrafficSystemProjects.dtos.responses.RegisterVehicleResponse;

public interface VehicleService {
    RegisterVehicleResponse registerVehicle(RegisterVehicleRequest request);
}
