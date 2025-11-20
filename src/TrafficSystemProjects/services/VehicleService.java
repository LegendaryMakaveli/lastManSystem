package TrafficSystemProjects.services;

import TrafficSystemProjects.dtos.requests.RegisterVehicleRequest;
import TrafficSystemProjects.dtos.responses.RegisterVehicleResponse;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleService {
    RegisterVehicleResponse registerVehicle(RegisterVehicleRequest request);
}
