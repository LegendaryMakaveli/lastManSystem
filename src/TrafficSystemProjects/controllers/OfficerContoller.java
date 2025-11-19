package TrafficSystemProjects.controllers;

import TrafficSystemProjects.dtos.requests.RegisterOfficerRequest;
import TrafficSystemProjects.dtos.responses.RegisterOfficerResponse;
import TrafficSystemProjects.services.OfficerService;
import TrafficSystemProjects.services.OfficerServiceImple;

public class OfficerContoller {
    private OfficerService officerService = new OfficerServiceImple();

    public RegisterOfficerResponse registerOfficer(RegisterOfficerRequest request){
        return officerService.registerOfficer(request);
    }
}
