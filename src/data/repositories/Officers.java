package data.repositories;

import data.models.Officer;
import exceptions.IdNotFoundException;
import exceptions.InvalidObject;

import java.util.ArrayList;
import java.util.List;

public class Officers implements OfficerRepositories{
    private int count;
    private List<Officer> officers = new ArrayList<>();

    @Override
    public Officer save(Officer officer) {
        officers.add(officer);
        count++;
        return officer;
    }

    @Override
    public Officer findById(int id) {
        for(int count = 0; count < officers.size(); count++) {
            if (officers.get(count).getId() == id) {
                return officers.get(count);
            }
        }
        throw new IdNotFoundException("Id not found");
    }

    @Override
    public List<Officer> findAll() {
       List<Officer> newOfficer = new ArrayList<>();
       for(int count = 0; count < officers.size(); count++){
           Officer officer1 = officers.get(count);
           newOfficer.add(officer1);
       }
       return newOfficer;
    }

    @Override
    public void deleteById(int id) {
        for(int count = 0; count < officers.size(); count++){
            if(officers.get(count).getId() == id){
                officers.remove(count);
                return;
            }
        }
        throw new IdNotFoundException("Id not found");
    }

    @Override
    public int getSize() {
        return officers.size();
    }

    @Override
    public void deleteAll() {
        for(int count = officers.size() - 1; count >= 0; count--)officers.remove(count);
    }

    @Override
    public Officer delete(Officer officer) {
       for(int count = 0; count < officers.size(); count++){
           Officer officer1 = officers.get(count);
           if(officer.equals(officer1)){
               officers.remove(count);
               return officer;
           }
       }
        throw new InvalidObject("Not found");
    }

    @Override
    public long count() {
        return count;
    }
}
