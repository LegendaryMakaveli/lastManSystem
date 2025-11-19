package TrafficSystemProjects.data.models;

import lombok.Data;

@Data
public class Owner {
    private String fullName;
    private String address;
    private String phoneNumber;
    private Gender gender;
    private String id;
}
