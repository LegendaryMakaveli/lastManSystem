package dtos.responses;

public class ViewAllVehicleTicketsResponse {
    private String ticketId;
    private String offense;
    private String vehicleDetails;
    private String ownerName;
    private String hasPaid;


    @Override
    public String toString() {
        return "ViewAllVehicleTicketsResponse{" +
                "ticketId='" + ticketId + '\'' +
                ", offense='" + offense + '\'' +
                ", vehicleDetails='" + vehicleDetails + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", hasPaid='" + hasPaid + '\'' +
                '}';
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOffense() {
        return offense;
    }

    public void setOffense(String offense) {
        this.offense = offense;
    }

    public String getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(String vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }

    public String getHasPaid() {
        return hasPaid;
    }

    public void setHasPaid(String hasPaid) {
        this.hasPaid = hasPaid;
    }
}
