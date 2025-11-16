package services;

import data.models.Officer;
import data.repositories.OfficerRepositories;
import data.repositories.Officers;
import dtos.requests.RegisterOfficerRequest;
import dtos.responses.RegisterOfficerResponse;
import exceptions.LastManException;
import static utils.OfficerMapper.map;



public class OfficerServiceImple implements  OfficerService {
    private OfficerRepositories officers;

    public OfficerServiceImple(OfficerRepositories officers) {
        this.officers = officers;

    }

    @Override
    public RegisterOfficerResponse registerOfficer(RegisterOfficerRequest request) {
        if(officers.findById(request.getId()) != null) throw new LastManException("Officer already exists");
        Officer newOfficer = map(request);
        Officer savedOfficer = officers.save(newOfficer);
        request.setId(savedOfficer.getId());

        return new  RegisterOfficerResponse();
    }
}
