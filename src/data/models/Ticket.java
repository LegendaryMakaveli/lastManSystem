package data.models;

import java.time.LocalDateTime;

public class Ticket {
    private String id;
    private Vehicle vehicle;
    private Offense offense;
    private boolean hasPaid;
    private LocalDateTime dateOfBooking = LocalDateTime.now();
    private LocalDateTime dateOfPaymant;

    public Ticket(){}



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
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
