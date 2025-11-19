package dtos.requests;

public class ViewTicketRequest {
    private String IssuerOfficerId;
    private String TicketId;

    public String getTicketId() {
        return TicketId;
    }

    public void setTicketId(String ticketId) {
        TicketId = ticketId;
    }

    public String getIssuerOfficerId() {
        return IssuerOfficerId;
    }

    public void setIssuerOfficerId(String issuerOfficerId) {
        IssuerOfficerId = issuerOfficerId;
    }
}
