package services;
import data.models.Vehicle;
import data.repositories.VehicleRepositories;
import data.repositories.Vehicles;
import dtos.requests.RegisterVehicleRequest;
import dtos.responses.RegisterVehicleResponse;

import static utils.Mapper.map;

public class VehicleSericeImple implements VehicleService{
    private VehicleRepositories vehicles = new Vehicles();


    @Override
    public RegisterVehicleResponse registerVehicle(RegisterVehicleRequest request) {
        Vehicle vehicle = map(request);
        vehicles.save(vehicle);

        return new RegisterVehicleResponse();
    }
}
