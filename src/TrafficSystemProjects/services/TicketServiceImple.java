package TrafficSystemProjects.services;

import TrafficSystemProjects.data.models.Officer;
import TrafficSystemProjects.data.models.Ticket;
import TrafficSystemProjects.data.repositories.OfficerRepositories;
import TrafficSystemProjects.data.repositories.TicketRepositories;
import TrafficSystemProjects.dtos.requests.BookTicketRequest;
import TrafficSystemProjects.dtos.requests.SettleTicketRequest;
import TrafficSystemProjects.dtos.requests.ViewTicketRequest;
import TrafficSystemProjects.dtos.responses.BookTicketResponse;
import TrafficSystemProjects.dtos.responses.SettleTicketResponse;
import TrafficSystemProjects.dtos.responses.ViewAllVehicleTicketsResponse;
import TrafficSystemProjects.dtos.responses.ViewTicketResponse;
import TrafficSystemProjects.exceptions.IdNotFoundException;
import TrafficSystemProjects.exceptions.LastManException;

import TrafficSystemProjects.data.models.Offense;
import TrafficSystemProjects.exceptions.TicketNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static TrafficSystemProjects.utils.Mapper.*;


public class TicketServiceImple implements TicketsService{
    private OfficerRepositories officers;
    private TicketRepositories tickets;
    private Ticket  ticket = new Ticket();
    private Offense offense;

    @Autowired
    public TicketServiceImple(OfficerRepositories officers, TicketRepositories tickets) {
        this.officers = officers;
        this.tickets = tickets;
    }

    @Autowired
    public TicketServiceImple(){
        this.officers = officers;
        this.tickets = tickets;
    }


    @Override
    public BookTicketResponse bookTicket(BookTicketRequest request) {
        Optional<Officer> officer = officers.findById(request.getIssuerOfficerId());
        if (officer.isEmpty()) throw new LastManException("Officer does not exist");
        ticket.setOfficer(officer.get());

        Ticket newTicket = mapToBookTicket(request);
        newTicket.setOffense(offense);
        Ticket savedTicket = tickets.save(newTicket);

        return mapToBookTicketResponse(savedTicket);
    }

    @Override
    public ViewTicketResponse viewBookedTicket(ViewTicketRequest request) {
        Optional<Officer> officer = officers.findById(request.getIssuerOfficerId());
        if (officer.isEmpty()) throw new LastManException("Officer does not exist");

        Ticket newTicket = mapToViewTicket(request);
        tickets.findById(newTicket.getId());
        if (ticket == null) throw new IdNotFoundException("Ticket not found");
        if (!ticket.getOfficer().getId().equals(officer.get())) throw new LastManException("You are not allowed to view this ticket");

        return mapToViewTicketResponse(newTicket);
    }

    @Override
    public SettleTicketResponse settleTicket(SettleTicketRequest request) {
        Optional<Officer> officer = officers.findById(request.getIssuerOfficerId());
        if (officer.isEmpty()) throw new LastManException("Officer does not exist");


        Ticket newTicket = mapToSettleTicket(request);
        if(newTicket.isHasPaid()) return mapToSettleTicketResponse(newTicket);

        throw new IdNotFoundException("Ticket not found");
    }



    @Override
    public List<ViewAllVehicleTicketsResponse> viewTicketsByVehicleId(String vehicleId) {
        List<Ticket> ticketList = tickets.findByVehicleId(vehicleId);
        if(ticketList == null) throw new TicketNotFoundException("No tickets found for this vehicle");
        List<ViewAllVehicleTicketsResponse> responseList = new ArrayList<>();

        for (Ticket ticket : ticketList) {
            ViewAllVehicleTicketsResponse mapped = mapToViewVehicleTickets(ticket);
            responseList.add(mapped);
        }
        return responseList;
    }
}
