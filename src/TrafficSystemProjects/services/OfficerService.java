package TrafficSystemProjects.services;

import TrafficSystemProjects.dtos.requests.RegisterOfficerRequest;
import TrafficSystemProjects.dtos.responses.RegisterOfficerResponse;

public interface OfficerService {
    RegisterOfficerResponse registerOfficer(RegisterOfficerRequest request);
}
