package services;

import dtos.requests.BookTicketRequest;
import dtos.requests.RegisterOfficerRequest;
import dtos.responses.BookTicketResponse;
import dtos.responses.RegisterOfficerResponse;

public interface OfficerService {
    RegisterOfficerResponse registerOfficer(RegisterOfficerRequest request);
    BookTicketResponse bookTicket(BookTicketRequest request);
}
