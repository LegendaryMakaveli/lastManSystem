package services;

import TrafficSystemProjects.data.models.Offense;
import TrafficSystemProjects.data.repositories.OfficerRepositories;
import TrafficSystemProjects.data.repositories.TicketRepositories;
import TrafficSystemProjects.dtos.requests.BookTicketRequest;
import TrafficSystemProjects.dtos.requests.RegisterOfficerRequest;
import TrafficSystemProjects.dtos.requests.SettleTicketRequest;
import TrafficSystemProjects.dtos.requests.ViewTicketRequest;
import TrafficSystemProjects.dtos.responses.SettleTicketResponse;
import TrafficSystemProjects.dtos.responses.ViewTicketResponse;
import TrafficSystemProjects.exceptions.LastManException;
import TrafficSystemProjects.services.OfficerService;
import TrafficSystemProjects.services.OfficerServiceImple;
import TrafficSystemProjects.services.TicketServiceImple;
import TrafficSystemProjects.services.TicketsService;
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
        newOfficer.setName("John");
        newOfficer.setRank("Inspector");
        officerService.registerOfficer(newOfficer);

        assertEquals(1, officers.getSize());
    }

    @Test
    public void registerTwoOfficersAndCountIsTwo() {
        RegisterOfficerRequest newOfficer = new  RegisterOfficerRequest();
        newOfficer.setId(newOfficer.getId());
        newOfficer.setName("John");
        newOfficer.setRank("Inspector");
        officerService.registerOfficer(newOfficer);

        RegisterOfficerRequest newOfficer2 = new  RegisterOfficerRequest();
        newOfficer2.setId(newOfficer2.getId());
        newOfficer2.setName("JohnDan");
        newOfficer2.setRank("Sergent");
        officerService.registerOfficer(newOfficer2);

        assertEquals(2, officers.getSize());
    }

    @Test
    public void registerOneOfficerTwiceAndCountIsOne() {
        RegisterOfficerRequest newOfficer = new  RegisterOfficerRequest();
        newOfficer.setId(newOfficer.getId());
        newOfficer.setName("John");
        newOfficer.setRank("Inspector");
        officerService.registerOfficer(newOfficer);

        assertThrows(LastManException.class, () -> officerService.registerOfficer(newOfficer));
    }

    @Test
    public void testThatRegisterOfficerCanBookTicket() {
        RegisterOfficerRequest newOfficer = new RegisterOfficerRequest();
        newOfficer.setId(newOfficer.getId());
        newOfficer.setName("John");
        newOfficer.setRank("Inspector");
        officerService.registerOfficer(newOfficer);

        BookTicketRequest giveTicket = getBookTicketRequest(newOfficer);
        ticketsService.bookTicket(giveTicket);

        assertEquals(1, tickets.getSize());
    }

    @Test
    public void testOfficerCanViewOwnTicket() {
        RegisterOfficerRequest newOfficer = new RegisterOfficerRequest();
        newOfficer.setId(newOfficer.getId());
        newOfficer.setName("John");
        newOfficer.setRank("Inspector");
        officerService.registerOfficer(newOfficer);

        BookTicketRequest giveTicket = getBookTicketRequest(newOfficer);
        ticketsService.bookTicket(giveTicket);

        ViewTicketRequest viewRequest = new ViewTicketRequest();
        viewRequest.setIssuerOfficerId(newOfficer.getId());
        viewRequest.setTicketId(giveTicket.getTicketId());

        ViewTicketResponse newOfficerView = ticketsService.viewBookedTicket(viewRequest);
        assertNotNull(newOfficerView);
    }

    @Test
    public void testOfficerCannotViewAnotherOfficersTicket() {
        RegisterOfficerRequest newOfficer = new RegisterOfficerRequest();
        newOfficer.setId(newOfficer.getId());
        newOfficer.setName("John");
        newOfficer.setRank("Inspector");
        officerService.registerOfficer(newOfficer);

        RegisterOfficerRequest newOfficerTwo = new RegisterOfficerRequest();
        newOfficerTwo.setId(newOfficerTwo.getId());
        newOfficerTwo.setName("Daniel");
        newOfficerTwo.setRank("Inspector");
        officerService.registerOfficer(newOfficerTwo);

        BookTicketRequest giveTicket = getBookTicketRequest(newOfficer);
        ticketsService.bookTicket(giveTicket);

        ViewTicketRequest viewRequest = new ViewTicketRequest();
        viewRequest.setIssuerOfficerId(newOfficerTwo.getId());
        viewRequest.setTicketId(giveTicket.getTicketId());

       assertThrows(LastManException.class, () -> ticketsService.viewBookedTicket(viewRequest));

    }


    @Test
    public void testThatOfficerCanBeRegister_BookTicket_ViewTicket_AndBeAbleToSettleTicket(){
        RegisterOfficerRequest newOfficer = new RegisterOfficerRequest();
        newOfficer.setId(newOfficer.getId());
        newOfficer.setName("John");
        newOfficer.setRank("Inspector");
        officerService.registerOfficer(newOfficer);

        BookTicketRequest giveTicket = getBookTicketRequest(newOfficer);
        ticketsService.bookTicket(giveTicket);

        SettleTicketRequest settleTicketRequest = new SettleTicketRequest();
        settleTicketRequest.setTicketId(giveTicket.getTicketId());
        settleTicketRequest.setHasPaid(true);
        settleTicketRequest.setIssuerOfficerId(newOfficer.getId());

        SettleTicketResponse settleTicketResponse = ticketsService.settleTicket(settleTicketRequest);
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