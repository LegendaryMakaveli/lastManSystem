package data.repositories;

import data.models.Vehicle;

import java.util.*;

public class Vehicles implements VehicleRepositories{
    private static Random random =  new Random();
    private static List<Vehicle> vehicles = new ArrayList<>();
    private static Set<String> usedIds = new HashSet<>();

    @Override
    public Vehicle save(Vehicle vehicle) {
        if(vehicle.getId() == null){
            vehicle.setId(generateId());
            vehicles.add(vehicle);
            return vehicle;
        } else{
            for(int index = 0; index < vehicles.size(); index++){
                if(vehicles.get(index).getId().equals(vehicle.getId())){
                    vehicles.set(index, vehicle);
                    return vehicle;
                }
            }
        }
        return null;
    }

    @Override
    public int getSize() {
        return vehicles.size();
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    @Override
    public Vehicle findById(String id) {
        for(int count = 0; count < vehicles.size(); count++){
            Vehicle vehicle = vehicles.get(count);
            if(vehicle.getId().equals(id)){
                return vehicle;
            }
        }
        return null;
    }

    @Override
    public Vehicle findByChasisNumber(String chasisNumber) {
        for(Vehicle newVehicle : vehicles){
            if(newVehicle.getChasisNumber().equals(chasisNumber)){
                return newVehicle;
            }
        }
        return null;
    }

    @Override
    public List<Vehicle> findAll() {
        List<Vehicle> allVehicles = new ArrayList<>();
        for(int count = 0; count <  vehicles.size(); count++){
            Vehicle vehicle = vehicles.get(count);
            allVehicles.add(vehicle);
        }
        return allVehicles;
    }

    @Override
    public void deleteById(String id) {
        for(int count = 0; count < vehicles.size(); count++){
            Vehicle vehicle = vehicles.get(count);
            if(vehicle.getId().equals(id)){
                vehicles.remove(count);
                return;
            }
        }
    }

    @Override
    public void deleteAll() {
        for(int count = vehicles.size() - 1; count >= 0; count--) vehicles.remove(count);
    }

    @Override
    public Vehicle delete(Vehicle vehicle) {
      for(int count = 0; count < vehicles.size(); count++){
          Vehicle vehicle1 = vehicles.get(count);
          if(vehicle1.equals(vehicle)){
              vehicles.remove(count);
              return vehicle1;
          }
      }
      return null;
    }

    @Override
    public long count() {
        return vehicles.size();
    }


    private String generateId(){
        String id;
        do {
            int number = random.nextInt(Integer.MAX_VALUE);
            id = "Veh" + number;
        } while (usedIds.contains(id));
        usedIds.add(id);
        return id;
    }
}
