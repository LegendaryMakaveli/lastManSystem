package dtos.responses;

import data.models.Offense;
import data.models.Officer;

import java.time.LocalDateTime;

public class BookTicketResponse {
    private String TicketId;
    private double Amount;
    private Officer issuer;
    private Offense offense;
    private LocalDateTime issueDate = LocalDateTime.now();


    @Override
    public String toString() {
        return "BookTicketResponse{" +
                "TicketId='" + TicketId + '\'' +
                ", Amount=" + Amount +
                ", issuer=" + issuer +
                ", offense=" + offense +
                ", issueDate=" + issueDate +
                '}';
    }

    public String getTicketId() {
        return TicketId;
    }

    public void setTicketId(String ticketId) {
        TicketId = ticketId;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public Officer getIssuer() {
        return issuer;
    }

    public void setIssuer(Officer issuer) {
        this.issuer = issuer;
    }

    public Offense getOffense() {
        return offense;
    }

    public void setOffense(Offense offense) {
        this.offense = offense;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }
}
