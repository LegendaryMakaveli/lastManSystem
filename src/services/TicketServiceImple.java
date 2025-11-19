package services;

import data.models.Officer;
import data.models.Ticket;
import data.repositories.OfficerRepositories;
import data.repositories.TicketRepositories;
import dtos.requests.BookTicketRequest;
import dtos.requests.SettleTicketRequest;
import dtos.requests.ViewTicketRequest;
import dtos.responses.BookTicketResponse;
import dtos.responses.SettleTicketResponse;
import dtos.responses.ViewAllVehicleTicketsResponse;
import dtos.responses.ViewTicketResponse;
import exceptions.IdNotFoundException;
import exceptions.LastManException;

import data.models.Offense;
import exceptions.TicketNotFoundException;

import java.util.ArrayList;
import java.util.List;

import static utils.Mapper.*;


public class TicketServiceImple implements TicketsService{
    private OfficerRepositories officers;
    private TicketRepositories tickets;
    private Ticket  ticket = new Ticket();
    private Offense offense;

    public TicketServiceImple(OfficerRepositories officers, TicketRepositories tickets) {
        this.officers = officers;
        this.tickets = tickets;
    }

    public TicketServiceImple(){
        this.officers = officers;
        this.tickets = tickets;
    }


    @Override
    public BookTicketResponse bookTicket(BookTicketRequest request) {
        Officer officer = officers.findById(request.getIssuerOfficerId());
        if (officer == null) throw new LastManException("Officer does not exist");
        ticket.setOfficer(officer);

        Ticket newTicket = mapToBookTicket(request);
        newTicket.setOffense(offense);
        Ticket savedTicket = tickets.save(newTicket);

        return mapToBookTicketResponse(savedTicket);
    }

    @Override
    public ViewTicketResponse viewBookedTicket(ViewTicketRequest request) {
        Officer officer = officers.findById(request.getIssuerOfficerId());
        if (officer == null) throw new LastManException("Officer does not exist");

        Ticket newTicket = mapToViewTicket(request);
        tickets.findById(newTicket.getId());
        if (ticket == null) throw new IdNotFoundException("Ticket not found");
        if (!ticket.getOfficer().getId().equals(officer.getId())) throw new LastManException("You are not allowed to view this ticket");

        return mapToViewTicketResponse(newTicket);
    }

    @Override
    public SettleTicketResponse settleTicket(SettleTicketRequest request) {
        Officer officer = officers.findById(request.getIssuerOfficerId());
        if (officer == null) throw new LastManException("Officer does not exist");


        Ticket newTicket = mapToSettleTicket(request);
        if(newTicket.getHasPaid()) return mapToSettleTicketResponse(newTicket);

        throw new IdNotFoundException("Ticket not found");
    }



    @Override
    public List<ViewAllVehicleTicketsResponse> viewTicketsByVehicleId(String vehicleId) {
        List<Ticket> ticketList = tickets.findByVehicleId(vehicleId);
        if(ticketList == null || ticketList.isEmpty()) throw new TicketNotFoundException("No tickets found for this vehicle");
        List<ViewAllVehicleTicketsResponse> responseList = new ArrayList<>();

        for (Ticket ticket : ticketList) {
            ViewAllVehicleTicketsResponse mapped = mapToViewVehicleTickets(ticket);
            responseList.add(mapped);
        }
        return responseList;
    }
}
