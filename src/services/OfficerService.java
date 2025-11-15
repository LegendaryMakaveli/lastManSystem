package services;

import dtos.requests.RegisterOfficerRequest;
import dtos.responses.RegisterOfficerResponse;

public interface OfficerService {
    RegisterOfficerResponse registerOfficer(RegisterOfficerRequest request);
}
