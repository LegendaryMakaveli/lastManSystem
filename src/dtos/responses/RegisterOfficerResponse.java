package dtos.responses;

public class RegisterOfficerResponse {
    private String officerId;
    private String officerName;


    @Override
    public String toString() {
        return "RegisterOfficerResponse{" +
                "officerId='" + officerId + '\'' +
                ", officerName='" + officerName + '\'' +
                '}';
    }

    public String getOfficerId() {
        return officerId;
    }

    public void setOfficerId(String officerId) {
        this.officerId = officerId;
    }

    public String getOfficerName() {
        return officerName;
    }

    public void setOfficerName(String officerName) {
        this.officerName = officerName;
    }
}
