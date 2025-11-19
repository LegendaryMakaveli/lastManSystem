package TrafficSystemProjects.utils;

import TrafficSystemProjects.data.models.Owner;
import TrafficSystemProjects.data.models.Vehicle;
import TrafficSystemProjects.data.models.Officer;
import TrafficSystemProjects.data.models.Ticket;
import TrafficSystemProjects.dtos.requests.*;
import TrafficSystemProjects.dtos.responses.*;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Mapper {

    public static Vehicle map(RegisterVehicleRequest request){
        Vehicle vehicle = new Vehicle();
        vehicle.setName(request.getVehicleName());
        vehicle.setColour(request.getVehicleColour());
        vehicle.setModel(request.getVehicleModel());
        vehicle.setYear(request.getProductionYear());
        vehicle.setRegistrationDate(request.getRegistrationDate());
        vehicle.setChasisNumber(request.getVehicleChasisNumber());

        Owner owner = new Owner();
        owner.setFullName(request.getOwnerFullName());
        owner.setAddress(request.getOwnerAddress());
        owner.setGender(request.getOwnerGender());
        owner.setPhoneNumber(request.getOwnerPhoneNumber());

        vehicle.setOwner(owner);
        return vehicle;
    }

    public static RegisterVehicleResponse mapToVehicleResponse(Vehicle vehicle){
        RegisterVehicleResponse response = new RegisterVehicleResponse();
        response.setVehicleId(vehicle.getId());
        Owner owner = vehicle.getOwner();
        response.setOwnerName(owner != null ? owner.getFullName() : "Unknown Owner");
        String details = (vehicle.getName() + " " + vehicle.getColour() + " " + vehicle.getModel() + " " + vehicle.getYear()).trim();
        response.setVehicleDetails(details);
        LocalDateTime date = LocalDateTime.parse(vehicle.getRegistrationDate());
        String formattedDate = DateTimeFormatter.ofPattern("EEE, yyyy/MM/dd, hh : mm a").format(date);
        response.setRegistrationDate(formattedDate);

        return response;
    }


    public static Officer mapToRegisterOfficer(RegisterOfficerRequest request) {
        Officer newOfficer = new Officer();
        newOfficer.setName(request.getName());
        newOfficer.setRank(request.getRank());
        return newOfficer;
    }

    public static RegisterOfficerResponse mapToOfficerResponse(Officer officer){
        RegisterOfficerResponse response = new RegisterOfficerResponse();
        response.setOfficerId(officer.getId());
        response.setOfficerName(officer.getName().toLowerCase());

        return response;
    }


    public static Ticket mapToBookTicket(BookTicketRequest request) {
        Vehicle vehicle = new Vehicle();
        vehicle.setName(request.getOffenderVehicleName());
        vehicle.setModel(request.getOffenderVehicleModel());
        vehicle.setYear(request.getOffenderVehicleyear());
        vehicle.setChasisNumber(request.getOffenderVehicleChasisNumber());

        Ticket newTicket = new Ticket();

        newTicket.setVehicle(vehicle);
        newTicket.setHasPaid(request.isHasPaid());
        newTicket.setOffense(request.getOffense());

        return newTicket;
    }

    public static BookTicketResponse mapToBookTicketResponse(Ticket ticket){
        BookTicketResponse response = new BookTicketResponse();
        response.setTicketId(ticket.getId());
        response.setAmount(ticket.getAmount());
        response.setIssuer(ticket.getOfficer());
        response.setOffense(ticket.getOffense());
        response.setIssueDate(LocalDateTime.parse(DateTimeFormatter.ofPattern("EEE, yyy/mm/dd,  hh : mm, a").format(ticket.getDateOfBooking())));

        return response;
    }

    public static Ticket mapToViewTicket(ViewTicketRequest request){
        Officer newOfficer = new Officer();
        newOfficer.setId(request.getIssuerOfficerId());
        Ticket newTicket = new Ticket();
        newTicket.setId(request.getTicketId());


        return newTicket;
    }

    public static ViewTicketResponse mapToViewTicketResponse(Ticket savedTicket){
        ViewTicketResponse response = new ViewTicketResponse();
        response.setTicketId(savedTicket.getId());
        response.setOffense(savedTicket.getOffense());
        response.setHasPaid(savedTicket.isHasPaid());
        Vehicle vehicle = savedTicket.getVehicle();
        if (vehicle != null) {
            String details = vehicle.getName() + " "
                    + vehicle.getModel() + " "
                    + vehicle.getYear();

            response.setVehicleDetails(details.trim());
        }

        Owner owner = (vehicle != null) ? vehicle.getOwner() : null;
        if (owner != null) {
            String ownerInfo = owner.getFullName() + " - " + owner.getPhoneNumber() + " - " + owner.getGender();
            response.setOwnerName(ownerInfo.trim());
        }

        return response;
    }

    public static Ticket mapToSettleTicket(SettleTicketRequest request){
        Officer officer = new Officer();
        officer.setId(request.getIssuerOfficerId());
        Ticket newTicket = new Ticket();
        newTicket.setId(request.getTicketId());
        newTicket.setHasPaid(request.isHasPaid());

        return newTicket;
    }

    public static SettleTicketResponse mapToSettleTicketResponse(Ticket ticket){
        SettleTicketResponse response = new SettleTicketResponse();
        response.setTicketId(ticket.getId());
        response.setAmount(ticket.getAmount());
        Vehicle vehicle = ticket.getVehicle();
        if (vehicle != null) {
            String details = vehicle.getName() + " "
                    + vehicle.getModel() + " "
                    + vehicle.getYear();

            response.setVehicleDetails(details.trim());
        }
        return response;
    }

    public static ViewAllVehicleTicketsResponse mapToViewVehicleTickets(Ticket ticket){
        ViewAllVehicleTicketsResponse response = new ViewAllVehicleTicketsResponse();
        response.setTicketId(ticket.getId());
        response.setOffense(ticket.getOffense().name());

        Vehicle vehicle = ticket.getVehicle();
        response.setVehicleDetails(vehicle.getName() + " " + vehicle.getModel() + " " + vehicle.getYear());

        Owner owner = vehicle.getOwner();
        response.setOwnerName(owner.getFullName());

        response.setHasPaid(ticket.isHasPaid() ? "Yes" : "No");
        response.

        return response;
    }
}
