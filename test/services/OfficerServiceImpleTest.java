package services;

import data.models.Offense;
import data.repositories.OfficerRepositories;
import data.repositories.Officers;
import data.repositories.TicketRepositories;
import data.repositories.Tickets;
import dtos.requests.BookTicketRequest;
import dtos.requests.RegisterOfficerRequest;
import dtos.responses.BookTicketResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OfficerServiceImpleTest {
    private OfficerService officerService;
    private OfficerRepositories officers;
    private TicketRepositories tickets;

    @BeforeEach
    void setUp() {
        officerService = new OfficerServiceImple();
        officers = new Officers();
        tickets = new Tickets();
    }

    @AfterEach
    void tearDown() {
        officers.deleteAll();
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
        newOfficer.setId(newOfficer.getId());
        officerService.registerOfficer(newOfficer);

        BookTicketRequest giveATicket = new BookTicketRequest();
        giveATicket.setOffenderVehicleName(giveATicket.getOffenderVehicleName());
        giveATicket.setOffenderVehicleModel(giveATicket.getOffenderVehicleModel());
        giveATicket.setOffenderVehicleyear(giveATicket.getOffenderVehicleyear());
        giveATicket.setOffenderVehicleChasisNumber(giveATicket.getOffenderVehicleChasisNumber());
        giveATicket.setOffense(Offense.OVER_SPEEDING);

        officerService.bookTicket(giveATicket);

        assertEquals(1, tickets.getSize());
    }
}