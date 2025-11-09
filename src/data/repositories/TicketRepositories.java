package data.repositories;

import data.models.Ticket;
import java.util.List;

public interface TicketRepositories {
    Ticket save(Ticket ticket);
    Ticket findById(int id);
    List<Ticket> findAll();
    void deleteById(int id);
    int getSize();
    void deleteAll();
    Ticket delete(Ticket ticket);
    long count();
}
