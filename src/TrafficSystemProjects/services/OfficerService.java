package TrafficSystemProjects.services;

import TrafficSystemProjects.dtos.requests.RegisterOfficerRequest;
import TrafficSystemProjects.dtos.responses.RegisterOfficerResponse;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficerService {
    RegisterOfficerResponse registerOfficer(RegisterOfficerRequest request);
}
