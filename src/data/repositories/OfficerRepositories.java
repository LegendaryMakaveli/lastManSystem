package data.repositories;
import data.models.Officer;
import java.util.List;

public interface OfficerRepositories {
    Officer save(Officer officer);
    Officer findById(int id);
    List<Officer> findAll();
    void deleteById(int id);
    int getSize();
    void deleteAll();
    Officer delete(Officer officer);
    long count();
}
