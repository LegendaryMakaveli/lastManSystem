package TrafficSystemProjects.controllers;

import TrafficSystemProjects.dtos.requests.BookTicketRequest;
import TrafficSystemProjects.dtos.requests.SettleTicketRequest;
import TrafficSystemProjects.dtos.requests.ViewTicketRequest;
import TrafficSystemProjects.dtos.responses.BookTicketResponse;
import TrafficSystemProjects.dtos.responses.SettleTicketResponse;
import TrafficSystemProjects.dtos.responses.ViewAllVehicleTicketsResponse;
import TrafficSystemProjects.dtos.responses.ViewTicketResponse;
import TrafficSystemProjects.services.TicketServiceImple;
import TrafficSystemProjects.services.TicketsService;

import java.util.List;

public class TicketController {
    private TicketsService ticketsService = new TicketServiceImple();

    public BookTicketResponse bookTicket(BookTicketRequest request){
        return ticketsService.bookTicket(request);
    }

    public ViewTicketResponse viewTicket(ViewTicketRequest request){
        return ticketsService.viewBookedTicket(request);
    }

    public SettleTicketResponse settleTicket(SettleTicketRequest request){
        return ticketsService.settleTicket(request);
    }

    public List<ViewAllVehicleTicketsResponse> viewVehicleTickets(String vehicleId){
        return ticketsService.viewTicketsByVehicleId(vehicleId);
    }
}
