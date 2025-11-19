package TrafficSystemProjects.data.repositories;
import TrafficSystemProjects.data.models.Officer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface OfficerRepositories extends MongoRepository<Officer, String> {
    Officer save(Officer officer);
    Optional<Officer> findById(String id);
    List<Officer> findAll();
    void deleteById(String id);
    int getSize();
    void deleteAll();
    void delete(Officer officer);
    long count();
}
