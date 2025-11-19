package TrafficSystemProjects.services;

import TrafficSystemProjects.data.models.Officer;
import TrafficSystemProjects.data.repositories.OfficerRepositories;
import TrafficSystemProjects.dtos.requests.RegisterOfficerRequest;
import TrafficSystemProjects.dtos.responses.RegisterOfficerResponse;
import TrafficSystemProjects.exceptions.LastManException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static TrafficSystemProjects.utils.Mapper.mapToOfficerResponse;
import static TrafficSystemProjects.utils.Mapper.mapToRegisterOfficer;


@Service
public class OfficerServiceImple implements  OfficerService {
    private OfficerRepositories officers;

    @Autowired
    public OfficerServiceImple(OfficerRepositories officers) {
        this.officers = officers;

    }

    @Autowired
    public OfficerServiceImple(){
        this.officers = officers;
    }

    @Override
    public RegisterOfficerResponse registerOfficer(RegisterOfficerRequest request) {
        if(officers.findById(request.getId()) != null) throw new LastManException("Officer already exists");
        Officer newOfficer = mapToRegisterOfficer(request);
        Officer savedOfficer = officers.save(newOfficer);
        request.setId(savedOfficer.getId());

        return mapToOfficerResponse(savedOfficer);
    }
}
