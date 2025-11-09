package data.repositories;

import data.models.Ticket;
import exceptions.IdNotFoundException;
import exceptions.InvalidObject;

import java.util.ArrayList;
import java.util.List;

public class Tickets implements TicketRepositories {
    private int count;
    private List<Ticket> tickets = new ArrayList<>();

    @Override
    public Ticket save(Ticket ticket) {
        tickets.add(ticket);
        count++;
        return ticket;
    }

    @Override
    public Ticket findById(int id) {
        for(int count = 0; count < tickets.size(); count++){
            Ticket ticket = tickets.get(count);
            if(ticket.getId() == id){
                return ticket;
            }
        }
        throw new IdNotFoundException("Ticket with id " + id + " not found");
    }

    @Override
    public List<Ticket> findAll() {
        List<Ticket> myList = new ArrayList<>();
        for(int count = 0; count < tickets.size(); count++){
            Ticket ticket = tickets.get(count);
            myList.add(ticket);
        }
        return myList;
    }

    @Override
    public void deleteById(int id) {
        for(int count = 0; count < tickets.size(); count++){
            if(tickets.get(count).getId() == id){
                tickets.remove(count);
                return;
            }
        }
        throw new IdNotFoundException("Ticket with id " + id + " not found");
    }

    @Override
    public int getSize() {
        return tickets.size();
    }

    @Override
    public void deleteAll() {
        for(int count = tickets.size() - 1; count >= 0; count--)tickets.remove(count);
    }

    @Override
    public Ticket delete(Ticket ticket) {
        for(int count = 0; count < tickets.size(); count++){
            Ticket ticket1 = tickets.get(count);
            if(ticket1.equals(ticket)){
                tickets.remove(count);
                return ticket1;
            }
        }
        throw new InvalidObject("Not found");
    }

    @Override
    public long count() {
        return count;
    }
}
