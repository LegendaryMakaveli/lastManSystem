package data.repositories;

import data.models.Vehicle;
import exceptions.IdNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VehiclesTest {
    private VehicleRepositories vehicle;

    @BeforeEach
    void setUp() {
        vehicle = new Vehicles();
    }

    @Test
    public void TestThatMyVehiclesListIsEmpty() {
        assertEquals(0, vehicle.count());
    }

    @Test
    public void TestThatOneVehiclesIsSaved() {
        assertEquals(0, vehicle.count());
        Vehicle oneVehicle = new Vehicle(0,"Toyota", "Camry", "Red");
        vehicle.save(oneVehicle);
        assertEquals(1, vehicle.getSize());
    }

    @Test
    public void TestThatWhatVehicleIsSavedIsWhatWeGet(){
        assertEquals(0, vehicle.count());
        Vehicle newVehicle = new Vehicle(0,"Toyota", "Camry", "Red");
        Vehicle result = vehicle.save(newVehicle);
        assertEquals(result,  vehicle.findById(0));
    }

    @Test
    public void testThatWhenVehicleIsSearchWithInvalidId_ExceptionIThrown(){
        Vehicle newVehicle = new Vehicle(0,"Toyota", "Camry", "Red");
        vehicle.save(newVehicle);

        assertThrows(IdNotFoundException.class, () -> vehicle.findById(1));
    }


    @Test
    public void findAllAvailableVehicles() {
        Vehicle oneVehicle = new Vehicle(0,"Toyota", "Camry", "Red");
        vehicle.save(oneVehicle);
        Vehicle twoVehicle = new Vehicle(1,"Honda", "Accord", "Blue");
        vehicle.save(twoVehicle);
        List<Vehicle> allNewVehicle = vehicle.findAll();
        assertNotNull(allNewVehicle);
        assertEquals(2,  allNewVehicle.size());
        assertEquals(oneVehicle, allNewVehicle.get(0));
        assertEquals(twoVehicle, allNewVehicle.get(1));
    }

    @Test
    public void deleteById() {
        Vehicle oneVehicle = new Vehicle(0,"Toyota", "Camry", "Red");
        vehicle.save(oneVehicle);
        Vehicle twoVehicle = new Vehicle(1,"Hyundai", "Solana", "Blue");
        vehicle.save(twoVehicle);
        assertEquals(2, vehicle.getSize());
        vehicle.deleteById(1);
        assertEquals(1, vehicle.getSize());
    }

    @Test
    public void deleteAll() {
        Vehicle oneVehicle = new Vehicle(0,"Toyota", "Camry", "Red");
        vehicle.save(oneVehicle);
        Vehicle twoVehicle = new Vehicle(1,"Toyota", "Sienna", "Blue");
        vehicle.save(twoVehicle);
        Vehicle thirdVehicle = new Vehicle(2,"Honda", "EvilSpirit", "Yellow");
        vehicle.save(thirdVehicle);
        Vehicle fourthVehicle = new Vehicle(3,"Toyota", "Corolla", "Red");
        vehicle.save(fourthVehicle);
        assertEquals(4, vehicle.getSize());
        vehicle.deleteAll();
        assertEquals(0, vehicle.getSize());
    }

    @Test
    public void deleteObject() {
        Vehicle newVehicle = new Vehicle(0,"Toyota", "Camry", "Red");
        Vehicle result = vehicle.save(newVehicle);
        assertEquals(1, vehicle.getSize());
        vehicle.delete(result);
        assertEquals(0, vehicle.getSize());
    }

    @Test
    public void getVehicleCount() {
        Vehicle oneVehicle = new Vehicle(0,"Toyota", "Camry", "Red");
        vehicle.save(oneVehicle);
        Vehicle twoVehicle = new Vehicle(1,"Lexus", "Rx", "Red");
        vehicle.save(twoVehicle);
        Vehicle thirdVehicle = new Vehicle(2,"Nissan", "Premier", "Blue");
        vehicle.save(thirdVehicle);
        Vehicle fourthVehicle = new Vehicle(3,"Lambo", "Urus", "Red");
        vehicle.save(fourthVehicle);

        assertEquals(4, vehicle.count());
    }
}