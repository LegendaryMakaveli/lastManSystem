package data.repositories;

import data.models.Ticket;

import java.util.*;

public class Tickets implements TicketRepositories {
    private static Random random = new Random();
    private static  Set<String> usedIds = new HashSet<>();
    private static List<Ticket> tickets = new ArrayList<>();

    @Override
    public Ticket save(Ticket ticket) {
        if(ticket.getId() == null){
            ticket.setId(generateId());
            tickets.add(ticket);
            return ticket;

        }else{
            for(int index = 0; index < tickets.size(); index++){
                if(tickets.get(index).getId().equals(ticket.getId())){
                    tickets.set(index, ticket);
                    return ticket;
                }
            }
        }
        return null;
    }



    @Override
    public Ticket findById(String id) {
        for(int count = 0; count < tickets.size(); count++){
            Ticket ticket = tickets.get(count);
            if(ticket.getId() != null && ticket.getId().equals(id)){
                return ticket;
            }
        }
        return null;
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
    public void deleteById(String id) {
        for(int count = 0; count < tickets.size(); count++){
            if(tickets.get(count).getId() == id){
                tickets.remove(count);
                return;
            }
        }
    }

    @Override
    public List<Ticket> findByVehicleId(String vehicleId) {
        List<Ticket> result = new ArrayList<>();

        for (Ticket ticket : tickets) {
            if (ticket.getVehicle().getId().equals(vehicleId)) {
                result.add(ticket);
            }
        }
        return result;
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
        return null;
    }

    @Override
    public long count() {
        return tickets.size();
    }


    private String generateId(){
        String id;
        do {
            int number = random.nextInt(Integer.MAX_VALUE);
            id = "Tic" + number;
        } while (usedIds.contains(id));
        usedIds.add(id);
        return id;
    }
}
