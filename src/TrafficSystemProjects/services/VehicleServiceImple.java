package TrafficSystemProjects.services;
import TrafficSystemProjects.data.models.Vehicle;
import TrafficSystemProjects.data.repositories.VehicleRepositories;
import TrafficSystemProjects.dtos.requests.RegisterVehicleRequest;
import TrafficSystemProjects.dtos.responses.RegisterVehicleResponse;
import TrafficSystemProjects.exceptions.VehicleAlreadyExistsException;
import TrafficSystemProjects.exceptions.VehicleNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static TrafficSystemProjects.utils.Mapper.map;
import static TrafficSystemProjects.utils.Mapper.mapToVehicleResponse;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class VehicleServiceImple implements VehicleService{
    @Autowired
    private VehicleRepositories vehicles;



    @Override
    public RegisterVehicleResponse registerVehicle(RegisterVehicleRequest request) {
        if(vehicles.findByChasisNumber(request.getVehicleChasisNumber()).isPresent()) throw new VehicleAlreadyExistsException("Vehicle already exists");
        Vehicle vehicle = map(request);
        vehicle.setRegistrationDate(LocalDateTime.now());
        Vehicle savedVehicle = vehicles.save(vehicle);

        return mapToVehicleResponse(savedVehicle);
    }
}
