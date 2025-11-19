package data.repositories;

import TrafficSystemProjects.data.models.Vehicle;
import TrafficSystemProjects.data.repositories.VehicleRepositories;
import org.junit.jupiter.api.AfterEach;
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
    @AfterEach
    void tearDown() {
        vehicle.deleteAll();
    }

    @Test
    public void TestThatMyVehiclesListIsEmpty() {
        assertEquals(0, vehicle.count());
    }

    @Test
    public void TestThatOneVehiclesIsSaved() {
        assertEquals(0, vehicle.count());
        Vehicle oneVehicle = new Vehicle();
        vehicle.save(oneVehicle);
        assertEquals(1, vehicle.getSize());
    }

    @Test
    public void TestThatWhatVehicleIsSavedIsWhatWeGet(){
        assertEquals(0, vehicle.count());
        Vehicle newVehicle = new Vehicle();
        Vehicle result = vehicle.save(newVehicle);
        assertEquals(result,  vehicle.findById(newVehicle.getId()));
    }


    @Test
    public void findAllAvailableVehicles() {
        Vehicle oneVehicle = new Vehicle();
        vehicle.save(oneVehicle);
        Vehicle twoVehicle = new Vehicle();
        vehicle.save(twoVehicle);
        List<Vehicle> allNewVehicle = vehicle.findAll();
        assertNotNull(allNewVehicle);
        assertEquals(2,  allNewVehicle.size());
        assertEquals(oneVehicle, allNewVehicle.get(0));
        assertEquals(twoVehicle, allNewVehicle.get(1));
    }

    @Test
    public void deleteById() {
        Vehicle oneVehicle = new Vehicle();
        vehicle.save(oneVehicle);
        Vehicle twoVehicle = new Vehicle();
        vehicle.save(twoVehicle);
        assertEquals(2, vehicle.getSize());
        vehicle.deleteById(twoVehicle.getId());
        assertEquals(1, vehicle.getSize());
    }

    @Test
    public void deleteAll() {
        Vehicle oneVehicle = new Vehicle();
        vehicle.save(oneVehicle);
        Vehicle twoVehicle = new Vehicle();
        vehicle.save(twoVehicle);
        Vehicle thirdVehicle = new Vehicle();
        vehicle.save(thirdVehicle);
        Vehicle fourthVehicle = new Vehicle();
        vehicle.save(fourthVehicle);
        assertEquals(4, vehicle.getSize());
        vehicle.deleteAll();
        assertEquals(0, vehicle.getSize());
    }

    @Test
    public void deleteObject() {
        Vehicle newVehicle = new Vehicle();
        Vehicle result = vehicle.save(newVehicle);
        assertEquals(1, vehicle.getSize());
        vehicle.delete(result);
        assertEquals(0, vehicle.getSize());
    }

    @Test
    public void getVehicleCount() {
        Vehicle oneVehicle = new Vehicle();
        vehicle.save(oneVehicle);
        Vehicle twoVehicle = new Vehicle();
        vehicle.save(twoVehicle);
        Vehicle thirdVehicle = new Vehicle();
        vehicle.save(thirdVehicle);
        Vehicle fourthVehicle = new Vehicle();
        vehicle.save(fourthVehicle);

        assertEquals(4, vehicle.count());
    }
}