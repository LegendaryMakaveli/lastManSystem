package dtos.requests;

public class RegisterOfficerRequest {
    private String id;
    private String name;
    private String rank;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setName(String name) {
        this.name = name;
    }
}
