package utils;

import data.models.Officer;
import data.models.Ticket;
import data.models.Vehicle;
import dtos.requests.BookTicketRequest;
import dtos.requests.RegisterOfficerRequest;

public class OfficerMapper {

    public static Officer map(RegisterOfficerRequest request) {
        Officer newOfficer = new Officer();
        newOfficer.setName(request.getName());
        newOfficer.setId(request.getId());
        newOfficer.setRank(request.getRank());
        return newOfficer;
    }


    public static Ticket mapTicket(BookTicketRequest request) {
        Ticket newTicket = new Ticket();
        Vehicle vehicle = new Vehicle("Toyota", "Camry", "Black");
        vehicle.setName(request.getOffenderVehicleName());
        vehicle.setModel(request.getOffenderVehicleModel());
        vehicle.setYear(request.getOffenderVehicleyear());
        vehicle.setChasisNumber(request.getOffenderVehicleChasisNumber());

        Officer newOfficer = new Officer();
        newOfficer.setId(request.getIssuerOfficerId());
        newTicket.setVehicle(vehicle);

        return newTicket;
    }
}
