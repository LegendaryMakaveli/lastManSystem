package dtos.responses;

import java.time.LocalDateTime;

public class SettleTicketResponse {
    private String ticketId;
    private String vehicleDetails;
    private double amount;
    private LocalDateTime settleDate = LocalDateTime.now();

    @Override
    public String toString() {
        return "SettleTicketResponse{" +
                "ticketId='" + ticketId + '\'' +
                ", vehicleDetails='" + vehicleDetails + '\'' +
                ", amount=" + amount +
                ", registrationDate=" + settleDate +
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getsettleDate() {
        return settleDate;
    }

    public void setSettleDate(LocalDateTime registrationDate) {
        this.settleDate = registrationDate;
    }
}
