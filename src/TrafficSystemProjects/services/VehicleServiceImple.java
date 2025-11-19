package TrafficSystemProjects.services;
import TrafficSystemProjects.data.models.Vehicle;
import TrafficSystemProjects.data.repositories.VehicleRepositories;
import TrafficSystemProjects.dtos.requests.RegisterVehicleRequest;
import TrafficSystemProjects.dtos.responses.RegisterVehicleResponse;
import TrafficSystemProjects.exceptions.VehicleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import static TrafficSystemProjects.utils.Mapper.map;
import static TrafficSystemProjects.utils.Mapper.mapToVehicleResponse;

public class VehicleServiceImple implements VehicleService{
    private VehicleRepositories vehicles;

    @Autowired
    public VehicleServiceImple(VehicleRepositories vehicles){
        this.vehicles = vehicles;
    }


    @Override
    public RegisterVehicleResponse registerVehicle(RegisterVehicleRequest request) {
        if(vehicles.findByChasisNumber(request.getVehicleChasisNumber()) != null) throw new VehicleNotFoundException("Vehicle already exists");
        Vehicle vehicle = map(request);
        Vehicle savedVehicle = vehicles.save(vehicle);

        return mapToVehicleResponse(savedVehicle);
    }
}
