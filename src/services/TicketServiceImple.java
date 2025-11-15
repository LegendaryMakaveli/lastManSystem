package services;

import data.models.Officer;
import data.models.Ticket;
import data.repositories.OfficerRepositories;
import data.repositories.Officers;
import data.repositories.TicketRepositories;
import data.repositories.Tickets;
import dtos.requests.BookTicketRequest;
import dtos.responses.BookTicketResponse;
import exceptions.LastManException;
import static utils.OfficerMapper.mapTicket;
import data.models.Offense;



public class TicketServiceImple implements TicketsService{
    private OfficerRepositories officers = new Officers();
    private TicketRepositories tickets = new Tickets();
    private Ticket  ticket = new Ticket();
    private Offense offense;

    @Override
    public BookTicketResponse bookTicket(BookTicketRequest request) {
        Officer officer = officers.findById(request.getIssuerOfficerId());
        ticket.setOfficer(officer);
        if (officer == null) throw new LastManException("Officer does not exist");

        Ticket newTicket = mapTicket(request);
        newTicket.setOffense(offense);
        tickets.save(newTicket);

        return new BookTicketResponse();
    }
}
