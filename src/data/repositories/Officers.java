package data.repositories;

import data.models.Officer;
import exceptions.IdNotFoundException;
import exceptions.InvalidObject;

import java.util.*;

public class Officers implements OfficerRepositories{
    private static Random random = new Random();
    private static Set<String> usedIds = new HashSet<>();
    private static List<Officer> officers = new ArrayList<>();

    @Override
    public Officer save(Officer officer) {
        if(officer.getId() == null){
            officer.setId(generateId());
            officers.add(officer);
            return officer;
        }else {
            for(int index = 0; index < officers.size(); index++){
                if(officers.get(index).getId().equals(officer.getId())){
                    officers.set(index, officer);
                    return officer;
                }
            }
        }
        return null;
    }

    @Override
    public Officer findById(String id) {
        for(int count = 0; count < officers.size(); count++) {
            Officer officer = officers.get(count);
            if (officer.getId() !=  null && officer.getId().equals(id)) {
                return officer;
            }
        }
        return null;
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
    public void deleteById(String id) {
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
        return officers.size();
    }

    private String generateId(){
        String id;
        do {
            int number = random.nextInt(Integer.MAX_VALUE);
            id = "Ofc" + number;
        } while (usedIds.contains(id));
        usedIds.add(id);
        return id;
    }
}
