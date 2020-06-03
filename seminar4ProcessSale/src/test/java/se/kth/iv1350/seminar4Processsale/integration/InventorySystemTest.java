package se.kth.iv1350.seminar4Processsale.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.seminar4Processsale.exceptions.DataBaseConnectionException;
import se.kth.iv1350.seminar4Processsale.exceptions.NoSuchItemFoundException;

import static org.junit.jupiter.api.Assertions.*;

class InventorySystemTest {
    private InventorySystem instanceInvSystem;


    @BeforeEach
    void setUp() {
        instanceInvSystem = new InventorySystem();
    }

    @AfterEach
    void tearDown() {
        instanceInvSystem = null;
    }

    @Test
    void testGetCorrectItemDescription() throws NoSuchItemFoundException, DataBaseConnectionException {
        String ItemDescription = (instanceInvSystem.getItemInfo(123)).getItemDescription();
        if(ItemDescription.equals("")) {

        }
        else {
            String expectedItemDescription = "Milk\t\t\t";
            boolean similarityBetweenItems = ItemDescription.equals(expectedItemDescription);
            assertTrue(similarityBetweenItems);
        }
    }

    @Test
    void testGetWrongItemDescription() throws NoSuchItemFoundException, DataBaseConnectionException {
        String ItemDescription =(instanceInvSystem.getItemInfo(123)).getItemDescription();
        String unexpectedItemDescription = "Strawberry\t\t";
        boolean differenceBetweenItems = ItemDescription.equals(unexpectedItemDescription);
        assertFalse(differenceBetweenItems);
    }

    @Test
    void testSameItemExistTwice() throws NoSuchItemFoundException, DataBaseConnectionException {
        String ItemDescription1 = (instanceInvSystem.getItemInfo(123)).getItemDescription();
        String ItemDescription2 = (instanceInvSystem.getItemInfo(1234)).getItemDescription();
        boolean similiarDescriptionTwice = ItemDescription1.equals(ItemDescription2);
        assertFalse(similiarDescriptionTwice);
    }

    @Test
    void testNoSuchItemFoundException()
    {

        try {
            instanceInvSystem.getItemInfo(1221);
        } catch (NoSuchItemFoundException e) {
            return;
        } catch (DataBaseConnectionException e) {
            fail("Wrong exception thrown. Expected: NoSuchItemFoundException");
        }

        fail("No exception has been thrown. Expected: NoSuchItemFoundException.");

    }

    @Test
    void testDataBaseConnectionException()
    {

        try {
            instanceInvSystem.getItemInfo(0);
        } catch (NoSuchItemFoundException e) {
            fail("Wrong exception thrown. Expected: DataBaseConnectionException");
        } catch (DataBaseConnectionException e) {
           return;
        }

        fail("No exception has been thrown. Expected: DataBaseConnectionException.");

    }

}