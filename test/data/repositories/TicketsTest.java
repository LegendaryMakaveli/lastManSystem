package data.repositories;

import data.models.Ticket;
import exceptions.IdNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TicketsTest {
    private TicketRepositories ticket;
    @BeforeEach
    void setUp() {
        ticket = new Tickets();
    }

    @Test
    public void testThatMyTicketIsEmpty(){
        assertEquals(0, ticket.count());
    }

    @Test
    public void saveANewTicketAndIsNotEmpty() {
        assertEquals(0, ticket.count());
        Ticket newTicket = new Ticket();
        ticket.save(newTicket);

        assertEquals(1, ticket.count());
    }

    @Test
    public void saveTwoTicketsInAListAndListIsNotEmpty() {
        Ticket ticket1 = new Ticket();
        Ticket ticket2 = new Ticket();
        ticket.save(ticket1);
        ticket.save(ticket2);

        assertEquals(2, ticket.getSize());
    }

    @Test
    public void saveTwoTicketAndFindOneById() {
        Ticket ticket1 = new Ticket();
        ticket.save(ticket1);
        Ticket ticket2 = new Ticket();
        ticket.save(ticket2);

        Ticket result = ticket.findById(ticket2.getId());
        assertEquals(result, ticket2);
    }

    @Test
    public void testThatWhenTicketIsSearchWithInvalidId_ExceptionIThrown(){
        Ticket newTicket = new Ticket();
        ticket.save(newTicket);

        assertThrows(IdNotFoundException.class, () -> ticket.findById("Dan09"));
    }

    @Test
    public void findAllTicketInMyList() {
        Ticket ticket1 = new Ticket();
        ticket.save(ticket1);
        Ticket ticket2 = new Ticket();
        ticket.save(ticket2);
        Ticket ticket3 = new  Ticket();
        ticket.save(ticket3);

        List<Ticket> found = ticket.findAll();
        assertNotNull(found);
        assertEquals(3, found.size());
        assertEquals(ticket1, found.get(0));
        assertEquals(ticket2, found.get(1));
        assertEquals(ticket3, found.get(2));
    }

    @Test
    public void deleteATicketById() {
        Ticket ticket1 = new Ticket();
        ticket.save(ticket1);
        Ticket ticket2 = new Ticket();
        ticket.save(ticket2);
        assertEquals(2, ticket.getSize());
        ticket.deleteById(ticket1.getId());
        assertEquals(1, ticket.getSize());
    }
    @Test
    public void testThatWhenTicketIsDeletedWithInvalidId_ExceptionIThrown(){
        Ticket newTicket = new Ticket();
        ticket.save(newTicket);

        assertThrows(IdNotFoundException.class, () -> ticket.deleteById("Dan07"));
    }

    @Test
    public void getTotalSizeOfMyLIst() {
        Ticket ticket1 = new Ticket();
        ticket.save(ticket1);
        Ticket ticket2 = new Ticket();
        ticket.save(ticket2);

        assertEquals(2, ticket.getSize());
    }

    @Test
    public void deleteAllTicketInMyList() {
        Ticket ticket1 = new Ticket();
        ticket.save(ticket1);
        Ticket ticket2 = new Ticket();
        ticket.save(ticket2);
        Ticket ticket3 = new  Ticket();
        ticket.save(ticket3);
        assertEquals(3, ticket.getSize());
        ticket.deleteAll();
        assertEquals(0, ticket.getSize());
    }

    @Test
    public void deleteATicketObject() {
        Ticket ticket1 = new Ticket();
        Ticket result = ticket.save(ticket1);
        assertEquals(1, ticket.getSize());
        ticket.delete(result);
        assertEquals(0, ticket.getSize());
    }

    @Test
    public void getTheTotalCountOfTicketInMyRepositories() {
        Ticket ticket1 = new Ticket();
        ticket.save(ticket1);
        Ticket ticket2 = new Ticket();
        ticket.save(ticket2);
        Ticket ticket3 = new  Ticket();
        ticket.save(ticket3);
        assertEquals(3, ticket.count());
    }
}