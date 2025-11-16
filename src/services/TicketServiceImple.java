package services;

import data.models.Officer;
import data.models.Ticket;
import data.repositories.OfficerRepositories;
import data.repositories.TicketRepositories;
import dtos.requests.BookTicketRequest;
import dtos.responses.BookTicketResponse;
import exceptions.IdNotFoundException;
import exceptions.LastManException;
import static utils.OfficerMapper.mapTicket;
import data.models.Offense;



public class TicketServiceImple implements TicketsService{
    private OfficerRepositories officers;
    private TicketRepositories tickets;
    private Ticket  ticket = new Ticket();
    private Offense offense;

    public TicketServiceImple(OfficerRepositories officers, TicketRepositories tickets) {
        this.officers = officers;
        this.tickets = tickets;
    }


    @Override
    public BookTicketResponse bookTicket(BookTicketRequest request) {
        Officer officer = officers.findById(request.getIssuerOfficerId());
        if (officer == null) throw new LastManException("Officer does not exist");
        ticket.setOfficer(officer);


        Ticket newTicket = mapTicket(request);
        newTicket.setOffense(offense);
        tickets.save(newTicket);

        return new BookTicketResponse();
    }

    @Override
    public BookTicketResponse viewBookedTicket(BookTicketRequest request) {
        Officer officer = officers.findById(request.getIssuerOfficerId());
        if (officer == null) throw new LastManException("Officer does not exist");



        Ticket newTicket = mapTicket(request);
        tickets.findById(newTicket.getId());
        if (ticket == null) throw new IdNotFoundException("Ticket not found");
        if (!ticket.getOfficer().getId().equals(officer.getId())) throw new LastManException("You are not allowed to view this ticket");

        return new  BookTicketResponse();
    }

    @Override
    public BookTicketResponse settleTicket(BookTicketRequest request) {
        Officer officer = officers.findById(request.getIssuerOfficerId());
        if (officer == null) throw new LastManException("Officer does not exist");


        Ticket newTicket = mapTicket(request);
        if(newTicket.getHasPaid()) return new  BookTicketResponse();

        throw new IdNotFoundException("Ticket not found");
    }

}

