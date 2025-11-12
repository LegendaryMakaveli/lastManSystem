package services;

import data.models.Offense;
import data.models.Officer;
import data.models.Ticket;
import data.repositories.OfficerRepositories;
import data.repositories.Officers;
import data.repositories.TicketRepositories;
import data.repositories.Tickets;
import dtos.requests.BookTicketRequest;
import dtos.requests.RegisterOfficerRequest;
import dtos.responses.BookTicketResponse;
import dtos.responses.RegisterOfficerResponse;
import exceptions.LastManException;
import static utils.OfficerMapper.map;
import static utils.OfficerMapper.mapTicket;



public class OfficerServiceImple implements  OfficerService {
    private OfficerRepositories officers = new Officers();
    private TicketRepositories tickets = new Tickets();
    private Offense offense;


    @Override
    public RegisterOfficerResponse registerOfficer(RegisterOfficerRequest request) {
        if(officers.findById(request.getId()) != null) throw new LastManException("Officer already exists");
        Officer newOfficer = map(request);
        officers.save(newOfficer);

        return new  RegisterOfficerResponse();
    }

    @Override
    public BookTicketResponse bookTicket(BookTicketRequest request) {
        if(officers.findById(request.getIssuerOfficerId()) == null)throw new LastManException("Officer does not exist");
        Ticket newTicket = mapTicket(request);
        newTicket.setOffense(offense);
        tickets.save(newTicket);

        return new BookTicketResponse();
    }
}
