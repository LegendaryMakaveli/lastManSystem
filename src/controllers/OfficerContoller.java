package controllers;

import dtos.requests.RegisterOfficerRequest;
import dtos.responses.RegisterOfficerResponse;
import services.OfficerService;
import services.OfficerServiceImple;

public class OfficerContoller {
    private OfficerService officerService = new OfficerServiceImple();

    public RegisterOfficerResponse registerOfficer(RegisterOfficerRequest request){
        return officerService.registerOfficer(request);
    }
}
