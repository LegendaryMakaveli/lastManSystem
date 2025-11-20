package TrafficSystemProjects.data.repositories;

import TrafficSystemProjects.data.models.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TicketRepositories extends MongoRepository<Ticket,String> {
    Ticket save(Ticket ticket);
    Optional<Ticket> findById(String id);
    List<Ticket> findAll();
    List<Ticket> findByVehicleId(String vehicleId);
    void deleteById(String id);
    void deleteAll();
    void delete(Ticket ticket);
    long count();
}
