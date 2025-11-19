package dtos.requests;

public class SettleTicketRequest {
    private String IssuerOfficerId;
    private String ticketId;
    private boolean hasPaid;

    public String getIssuerOfficerId() {
        return IssuerOfficerId;
    }

    public void setIssuerOfficerId(String issuerOfficerId) {
        IssuerOfficerId = issuerOfficerId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public boolean isHasPaid() {
        return hasPaid;
    }

    public void setHasPaid(boolean hasPaid) {
        this.hasPaid = hasPaid;
    }
}
