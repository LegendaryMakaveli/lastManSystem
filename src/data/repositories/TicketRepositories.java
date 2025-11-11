package data.repositories;

import data.models.Ticket;
import java.util.List;

public interface TicketRepositories {
    Ticket save(Ticket ticket);
    Ticket findById(String id);
    List<Ticket> findAll();
    void deleteById(String id);
    int getSize();
    void deleteAll();
    Ticket delete(Ticket ticket);
    long count();
}
