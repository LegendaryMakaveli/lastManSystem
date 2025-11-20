package TrafficSystemProjects.controllers;

import TrafficSystemProjects.dtos.requests.RegisterOfficerRequest;
import TrafficSystemProjects.dtos.responses.RegisterOfficerResponse;
import TrafficSystemProjects.services.OfficerService;
import TrafficSystemProjects.services.OfficerServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfficerContoller {
    @Autowired
    private OfficerService officerService;

    @PostMapping( "/officer/register")
    public RegisterOfficerResponse registerOfficer(@RequestBody RegisterOfficerRequest request){
        return officerService.registerOfficer(request);
    }
}
