package services;

import data.repositories.OfficerRepositories;
import data.repositories.Officers;
import dtos.requests.RegisterOfficerRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OfficerServiceImpleTest {
    private OfficerService officerService;
    private OfficerRepositories officers;

    @BeforeEach
    void setUp() {
        officerService = new OfficerServiceImple();
        officers = new Officers();
    }

    @AfterEach
    void tearDown() {
        officers.deleteAll();
    }

    @Test
    public void registerOneOfficerAndCountIsOne() {
        RegisterOfficerRequest newOfficer = new  RegisterOfficerRequest();
        officerService.registerOfficer(newOfficer);

        assertEquals(1, officers.getSize());
    }

    @Test
    public void registerTwoOfficersAndCountIsTwo() {
        RegisterOfficerRequest newOfficer = new  RegisterOfficerRequest();
        officerService.registerOfficer(newOfficer);

        RegisterOfficerRequest newOfficer2 = new  RegisterOfficerRequest();
        officerService.registerOfficer(newOfficer2);

        assertEquals(2, officers.getSize());
    }
}