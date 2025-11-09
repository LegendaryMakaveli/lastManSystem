package data.models;

public enum Offense {
    ONE_WAY("One_way", 30_000),
    DRUNK_DRIVING("Drunk_driving", 400_000),
    NO_SEAT_BELT("No_seat_belt", 60_000),
    OVER_SPEEDING("Over_speeding", 80_000);

    private final String name;
    private final int amount;

    Offense(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }
}
