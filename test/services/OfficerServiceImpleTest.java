package services;

import data.models.Offense;
import data.repositories.OfficerRepositories;
import data.repositories.Officers;
import data.repositories.TicketRepositories;
import data.repositories.Tickets;
import dtos.requests.BookTicketRequest;
import dtos.requests.RegisterOfficerRequest;
import dtos.responses.BookTicketResponse;
import exceptions.LastManException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;

class OfficerServiceImpleTest {
    private OfficerService officerService;
    private OfficerRepositories officers;
    private TicketRepositories tickets;
    private TicketsService ticketsService;

    @BeforeEach
    void setUp() {
        officers = new Officers();
        tickets = new Tickets();

        officers.deleteAll();
        tickets.deleteAll();

        officerService = new OfficerServiceImple(officers);
        ticketsService = new TicketServiceImple(officers, tickets);
    }

    @Test
    public void registerOneOfficerAndCountIsOne() {
        RegisterOfficerRequest newOfficer = new  RegisterOfficerRequest();
        newOfficer.setId(newOfficer.getId());
        officerService.registerOfficer(newOfficer);

        assertEquals(1, officers.getSize());
    }

    @Test
    public void registerTwoOfficersAndCountIsTwo() {
        RegisterOfficerRequest newOfficer = new  RegisterOfficerRequest();
        newOfficer.setId(newOfficer.getId());
        officerService.registerOfficer(newOfficer);

        RegisterOfficerRequest newOfficer2 = new  RegisterOfficerRequest();
        newOfficer2.setId(newOfficer2.getId());
        officerService.registerOfficer(newOfficer2);

        assertEquals(2, officers.getSize());
    }

    @Test
    public void testThatRegisterOfficerCanBookTicket() {
        RegisterOfficerRequest newOfficer = new RegisterOfficerRequest();
        officerService.registerOfficer(newOfficer);

        BookTicketRequest giveTicket = getBookTicketRequest(newOfficer);
        ticketsService.bookTicket(giveTicket);

        assertEquals(1, tickets.getSize());
    }

    @Test
    public void testOfficerCanViewOwnTicket() {
        RegisterOfficerRequest newOfficer = new RegisterOfficerRequest();
        officerService.registerOfficer(newOfficer);
        BookTicketRequest giveTicket = getBookTicketRequest(newOfficer);
        ticketsService.bookTicket(giveTicket);

        BookTicketRequest viewRequest = new BookTicketRequest();
        viewRequest.setIssuerOfficerId(newOfficer.getId());
        viewRequest.setTicketId(giveTicket.getTicketId());

        BookTicketResponse newOfficerView = ticketsService.viewBookedTicket(viewRequest);
        assertNotNull(newOfficerView);
    }

    @Test
    public void testOfficerCannotViewAnotherOfficersTicket() {
        RegisterOfficerRequest newOfficer = new RegisterOfficerRequest();
        officerService.registerOfficer(newOfficer);
        RegisterOfficerRequest newOfficerTwo = new RegisterOfficerRequest();
        officerService.registerOfficer(newOfficerTwo);

        BookTicketRequest giveTicket = getBookTicketRequest(newOfficer);
        ticketsService.bookTicket(giveTicket);

        BookTicketRequest viewRequest = new BookTicketRequest();
        viewRequest.setIssuerOfficerId(newOfficerTwo.getId());
        viewRequest.setTicketId(giveTicket.getTicketId());

       assertThrows(LastManException.class, () -> ticketsService.viewBookedTicket(viewRequest));

    }


    @Test
    public void testThatOfficerCanBeRegister_BookTicket_ViewTicket_AndBeAbleToSettleTicket(){
        RegisterOfficerRequest newOfficer = new RegisterOfficerRequest();
        officerService.registerOfficer(newOfficer);

        BookTicketRequest giveTicket = getBookTicketRequest(newOfficer);
        ticketsService.bookTicket(giveTicket);

        BookTicketRequest settleTicketRequest = new BookTicketRequest();
        settleTicketRequest.setTicketId(giveTicket.getTicketId());
        settleTicketRequest.setHasPaid(true);
        settleTicketRequest.setIssuerOfficerId(newOfficer.getId());

        BookTicketResponse settleTicketResponse = ticketsService.settleTicket(settleTicketRequest);
        assertNotNull(settleTicketResponse);
    }


























    private static BookTicketRequest getBookTicketRequest(RegisterOfficerRequest newOfficer) {
        BookTicketRequest giveTicket = new BookTicketRequest();
        giveTicket.setIssuerOfficerId(newOfficer.getId());
        giveTicket.setOffenderVehicleName("TOYOTA");
        giveTicket.setOffenderVehicleModel("CAMRY");
        giveTicket.setOffenderVehicleyear(Year.of(2015));
        giveTicket.setOffenderVehicleChasisNumber("SK2345CHI99FEM222EBU99");
        giveTicket.setOffense(Offense.OVER_SPEEDING);

        return giveTicket;
    }


}