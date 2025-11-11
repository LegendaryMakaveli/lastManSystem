package services;

import data.models.Officer;
import data.repositories.OfficerRepositories;
import data.repositories.Officers;
import dtos.requests.RegisterOfficerRequest;
import dtos.responses.RegisterOfficerResponse;

import static utils.OfficerMapper.map;

public class OfficerServiceImple implements  OfficerService {
    private OfficerRepositories officers = new Officers();


    @Override
    public RegisterOfficerResponse registerOfficer(RegisterOfficerRequest request) {
        Officer newOfficer = map(request);
        officers.save(newOfficer);

        return new  RegisterOfficerResponse();
    }
}
