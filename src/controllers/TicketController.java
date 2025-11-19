package controllers;

import dtos.requests.BookTicketRequest;
import dtos.requests.SettleTicketRequest;
import dtos.requests.ViewTicketRequest;
import dtos.responses.BookTicketResponse;
import dtos.responses.SettleTicketResponse;
import dtos.responses.ViewAllVehicleTicketsResponse;
import dtos.responses.ViewTicketResponse;
import services.TicketServiceImple;
import services.TicketsService;

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
