package data.repositories;

import data.models.Vehicle;

import java.util.List;

public interface VehicleRepositories {
    Vehicle save(Vehicle vehicle);
    Vehicle findById(String id);
    Vehicle findByChasisNumber(String chasisNumber);
    List<Vehicle> findAll();
    void deleteById(String id);
    int getSize();
    void deleteAll();
    Vehicle delete(Vehicle vehicle);
    long count();
}
