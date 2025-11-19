package services;

import dtos.requests.BookTicketRequest;
import dtos.requests.SettleTicketRequest;
import dtos.requests.ViewTicketRequest;
import dtos.responses.BookTicketResponse;
import dtos.responses.SettleTicketResponse;
import dtos.responses.ViewAllVehicleTicketsResponse;
import dtos.responses.ViewTicketResponse;

import java.util.List;

public interface TicketsService {
    BookTicketResponse bookTicket(BookTicketRequest request);
    ViewTicketResponse viewBookedTicket(ViewTicketRequest request);
    SettleTicketResponse settleTicket(SettleTicketRequest request);
    List<ViewAllVehicleTicketsResponse> viewTicketsByVehicleId(String vehicleId);
}
