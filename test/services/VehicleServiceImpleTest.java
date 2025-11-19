package services;

import TrafficSystemProjects.data.repositories.VehicleRepositories;
import TrafficSystemProjects.dtos.requests.RegisterVehicleRequest;
import TrafficSystemProjects.services.VehicleService;
import TrafficSystemProjects.services.VehicleServiceImple;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleServiceImpleTest {
    VehicleService service;
    VehicleRepositories vehicles;

    @BeforeEach
    void setUp() {
        service = new VehicleServiceImple(vehicles);
    }

    @AfterEach
    void tearDown() {
        vehicles.deleteAll();
    }

    @Test
    public void registerOneVehicleAndCountIsOne() {
        RegisterVehicleRequest request = new RegisterVehicleRequest();
        request.setVehicleChasisNumber("ADE23389KF");
        service.registerVehicle(request);

        assertEquals(1, vehicles.getSize());
    }

    @Test
    public void registerTwoVehicleAndCountIsTwo() {
        RegisterVehicleRequest request1 = new RegisterVehicleRequest();
        request1.setVehicleChasisNumber("A976NH67GHT55");
        service.registerVehicle(request1);

        RegisterVehicleRequest request2 = new RegisterVehicleRequest();
        request2.setVehicleChasisNumber("APO8700UJ5ODE");
        service.registerVehicle(request2);

        assertEquals(2, vehicles.getSize());
    }

}