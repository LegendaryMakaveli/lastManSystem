package services;

import dtos.requests.BookTicketRequest;
import dtos.responses.BookTicketResponse;

public interface TicketsService {
    BookTicketResponse bookTicket(BookTicketRequest request);
}
