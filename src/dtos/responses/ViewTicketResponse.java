package dtos.responses;

import data.models.Offense;

public class ViewTicketResponse {
    private String ticketId;
    private String vehicleDetails;
    private String OwnerName;
    private Offense offense;
    private boolean hasPaid;

    @Override
    public String toString() {
        return "ViewTicketResponse{" +
                "ticketId='" + ticketId + '\'' +
                ", vehicleDetails='" + vehicleDetails + '\'' +
                ", OwnerName='" + OwnerName + '\'' +
                ", offense=" + offense +
                ", hasPaid=" + hasPaid +
                '}';
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(String vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }

    public Offense getOffense() {
        return offense;
    }

    public void setOffense(Offense offense) {
        this.offense = offense;
    }

    public boolean isHasPaid() {
        return hasPaid;
    }

    public void setHasPaid(boolean hasPaid) {
        this.hasPaid = hasPaid;
    }
}
