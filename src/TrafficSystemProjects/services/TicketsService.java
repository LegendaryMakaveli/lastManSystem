package TrafficSystemProjects.services;

import TrafficSystemProjects.dtos.requests.BookTicketRequest;
import TrafficSystemProjects.dtos.requests.SettleTicketRequest;
import TrafficSystemProjects.dtos.requests.ViewTicketRequest;
import TrafficSystemProjects.dtos.responses.BookTicketResponse;
import TrafficSystemProjects.dtos.responses.SettleTicketResponse;
import TrafficSystemProjects.dtos.responses.ViewAllVehicleTicketsResponse;
import TrafficSystemProjects.dtos.responses.ViewTicketResponse;

import java.util.List;

public interface TicketsService {
    BookTicketResponse bookTicket(BookTicketRequest request);
    ViewTicketResponse viewBookedTicket(ViewTicketRequest request);
    SettleTicketResponse settleTicket(SettleTicketRequest request);
    List<ViewAllVehicleTicketsResponse> viewTicketsByVehicleId(String vehicleId);
}
