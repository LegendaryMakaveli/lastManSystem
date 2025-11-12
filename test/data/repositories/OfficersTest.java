package data.repositories;

import data.models.Officer;
import exceptions.IdNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OfficersTest {
    private OfficerRepositories officer;

    @BeforeEach
    void setUp() {
        officer = new Officers();
    }

    @AfterEach
    void tearDown() {
        officer.deleteAll();
    }


    @Test
    public void testThatOfficerIsEmpty() {
        assertEquals(0, officer.count());
    }

    @Test
    public void testThatOneOfficerIsSavedAndIsNotEmpty(){
        assertEquals(0, officer.count());
        Officer newOfficer = new Officer();
        officer.save(newOfficer);
        assertEquals(1, officer.count());
    }

    @Test
    public void testThatOfficerListIsEmpty(){
        assertEquals(0, officer.getSize());
    }


    @Test
    public void saveOneOfficerIntoTheListAndListIsNotEmpty() {
        assertEquals(0, officer.getSize());
        Officer newOfficer = new Officer();
        officer.save(newOfficer);
        Officer secondOfficer = new  Officer();
        officer.save(secondOfficer);
        assertEquals(2, officer.getSize());
    }

    @Test
    public void saveTwoOfficerAndConfirmWhatWeSaveIsWhatWeGet() {
        Officer newOfficer = new Officer();
        Officer result = officer.save(newOfficer);
        Officer secondOfficer = new  Officer();
        Officer result2 = officer.save(secondOfficer);
        assertEquals(result, newOfficer);
        assertEquals(result2, secondOfficer);
    }

    @Test
    public void saveTwoOfficerAndFindThemById(){
        Officer newOfficer = new Officer();
        officer.save(newOfficer);
        Officer secondOfficer = new  Officer();
        officer.save(secondOfficer);
        Officer result = officer.findById(newOfficer.getId());
        Officer result2 = officer.findById(secondOfficer.getId());

        assertEquals(newOfficer, result);
        assertEquals(secondOfficer, result2);

    }

    @Test
    public void testThatWhenOfficerIsSearchWithInvalidId_ExceptionIThrown(){
        Officer newOfficer = new Officer();
        officer.save(newOfficer);

        assertThrows(IdNotFoundException.class, () -> officer.findById("Ofc99"));
    }

    @Test
    public void testThatFindAllOfficerInOfficerList() {
        Officer newOfficer = new Officer();
        officer.save(newOfficer);
        Officer secondOfficer = new  Officer();
        officer.save(secondOfficer);

        List<Officer> allOfficer = officer.findAll();
        assertNotNull(allOfficer);
        assertEquals(2, allOfficer.size());
        assertEquals(newOfficer, allOfficer.get(0));
        assertEquals(secondOfficer, allOfficer.get(1));
    }

    @Test
    public void testThatDeleteOfficerById() {
        Officer newOfficer = new Officer();
        officer.save(newOfficer);
        Officer secondOfficer = new  Officer();
        officer.save(secondOfficer);

        assertEquals(2, officer.getSize());
        officer.deleteById(newOfficer.getId());
        assertEquals(1, officer.getSize());
        officer.deleteById(secondOfficer.getId());
        assertEquals(0, officer.getSize());
    }

    @Test
    public void testThatWhenOfficerIsdWithDeleteWithIvalidId_ExceptionIThrown(){
        Officer newOfficer = new Officer();
        officer.save(newOfficer);

        assertThrows(IdNotFoundException.class, () -> officer.deleteById("Ofc 20"));
    }


    @Test
    public void getSizeOfTheOfficerList() {
        Officer newOfficer = new Officer();
        officer.save(newOfficer);
        Officer secondOfficer = new  Officer();
        officer.save(secondOfficer);

        assertEquals(2, officer.getSize());
    }

    @Test
    public void deleteAllOfficerInOfficerList() {
        Officer newOfficer = new Officer();
        officer.save(newOfficer);
        Officer secondOfficer = new  Officer();
        officer.save(secondOfficer);
        assertEquals(2, officer.getSize());
        officer.deleteAll();
        assertEquals(0, officer.getSize());
    }

    @Test
    public void deleteAnOfficerObject() {
        Officer newOfficer = new Officer();
        officer.save(newOfficer);
        Officer secondOfficer = new  Officer();
        Officer result = officer.save(secondOfficer);
        assertEquals(2, officer.getSize());
        officer.delete(result);
        assertEquals(1, officer.getSize());
    }

    @Test
    public void GetTheCountOfAllOfficerInRepository() {
        Officer newOfficer = new Officer();
        officer.save(newOfficer);
        Officer secondOfficer = new  Officer();
        officer.save(secondOfficer);

        assertEquals(2, officer.count());
    }
}