package utils;

import data.models.Officer;
import dtos.requests.RegisterOfficerRequest;

public class OfficerMapper {

    public static Officer map(RegisterOfficerRequest request) {
        Officer newOfficer = new Officer();
        newOfficer.setName(request.getName());
        return newOfficer;
    }
}
