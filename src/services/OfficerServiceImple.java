package services;

import data.models.Officer;
import data.repositories.OfficerRepositories;
import dtos.requests.RegisterOfficerRequest;
import dtos.responses.RegisterOfficerResponse;
import exceptions.LastManException;

import static utils.Mapper.mapToOfficerResponse;
import static utils.Mapper.mapToRegisterOfficer;



public class OfficerServiceImple implements  OfficerService {
    private OfficerRepositories officers;

    public OfficerServiceImple(OfficerRepositories officers) {
        this.officers = officers;

    }

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
