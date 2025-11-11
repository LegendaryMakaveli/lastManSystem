package services;
import data.models.Vehicle;
import data.repositories.VehicleRepositories;
import data.repositories.Vehicles;
import dtos.requests.RegisterVehicleRequest;
import dtos.responses.RegisterVehicleResponse;
import exceptions.VehicleNotFoundException;

import static utils.Mapper.map;

public class VehicleServiceImple implements VehicleService{
    private VehicleRepositories vehicles = new Vehicles();


    @Override
    public RegisterVehicleResponse registerVehicle(RegisterVehicleRequest request) {
        if(vehicles.findByChasisNumber(request.getVehicleChasisNumber()) != null) throw new VehicleNotFoundException("Vehicle already exists");
        Vehicle vehicle = map(request);
        vehicles.save(vehicle);

        return new RegisterVehicleResponse();
    }
}
