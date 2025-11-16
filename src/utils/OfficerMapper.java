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
        newOfficer.setRank(request.getRank());
        return newOfficer;
    }


    public static Ticket mapTicket(BookTicketRequest request) {
        Vehicle vehicle = new Vehicle();

        vehicle.setName(request.getOffenderVehicleName());
        vehicle.setModel(request.getOffenderVehicleModel());
        vehicle.setYear(request.getOffenderVehicleyear());
        vehicle.setChasisNumber(request.getOffenderVehicleChasisNumber());

        Ticket newTicket = new Ticket();

        newTicket.setVehicle(vehicle);
        newTicket.setId(request.getTicketId());
        newTicket.setHasPaid();
        newTicket.setOffense(request.getOffense());

        return newTicket;
    }
}
