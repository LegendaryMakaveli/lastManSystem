package TrafficSystemProjects.controllers;

import TrafficSystemProjects.dtos.requests.BookTicketRequest;
import TrafficSystemProjects.dtos.requests.SettleTicketRequest;
import TrafficSystemProjects.dtos.requests.ViewTicketRequest;
import TrafficSystemProjects.dtos.responses.BookTicketResponse;
import TrafficSystemProjects.dtos.responses.SettleTicketResponse;
import TrafficSystemProjects.dtos.responses.ViewAllVehicleTicketsResponse;
import TrafficSystemProjects.dtos.responses.ViewTicketResponse;
import TrafficSystemProjects.services.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class TicketController {
    @Autowired
    private TicketsService ticketsService;

    @PostMapping( "/tickets/bookTicket")
    public BookTicketResponse bookTicket(@RequestBody BookTicketRequest request){
        return ticketsService.bookTicket(request);
    }

    @GetMapping( "/tickets/viewTicket")
    public ViewTicketResponse viewTicket(@PathVariable ViewTicketRequest request){
        return ticketsService.viewBookedTicket(request);
    }

    @PostMapping( "/ tickets/settleTicket")
    public SettleTicketResponse settleTicket(SettleTicketRequest request){
        return ticketsService.settleTicket(request);
    }

    @GetMapping( "/tickets/viewAllTicket")
    public List<ViewAllVehicleTicketsResponse> viewVehicleTickets(@PathVariable String vehicleId){
        return ticketsService.viewTicketsByVehicleId(vehicleId);
    }
}
