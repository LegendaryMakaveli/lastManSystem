package TrafficSystemProjects.data.repositories;

import TrafficSystemProjects.data.models.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface VehicleRepositories extends MongoRepository<Vehicle,String> {
    Vehicle save(Vehicle vehicle);
    Optional<Vehicle> findById(String id);
    Vehicle findByChasisNumber(String chasisNumber);
    List<Vehicle> findAll();
    void deleteById(String id);
    int getSize();
    void deleteAll();
    void delete(Vehicle vehicle);
    long count();
}
