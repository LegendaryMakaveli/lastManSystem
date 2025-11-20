package TrafficSystemProjects.services;

import TrafficSystemProjects.data.models.Officer;
import TrafficSystemProjects.data.repositories.OfficerRepositories;
import TrafficSystemProjects.dtos.requests.RegisterOfficerRequest;
import TrafficSystemProjects.dtos.responses.RegisterOfficerResponse;
import TrafficSystemProjects.exceptions.LastManException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static TrafficSystemProjects.utils.Mapper.mapToOfficerResponse;
import static TrafficSystemProjects.utils.Mapper.mapToRegisterOfficer;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class OfficerServiceImple implements  OfficerService {

    @Autowired
    private OfficerRepositories officers;


    @Override
    public RegisterOfficerResponse registerOfficer(RegisterOfficerRequest request) {
        if (request.getId() != null && officers.findById(request.getId()).isPresent()) throw new LastManException("Officer already exists");
        Officer newOfficer = mapToRegisterOfficer(request);
        Officer savedOfficer = officers.save(newOfficer);
        request.setId(savedOfficer.getId());

        return mapToOfficerResponse(savedOfficer);
    }
}
