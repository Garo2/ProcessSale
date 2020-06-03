package se.kth.iv1350.seminar4Processsale.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.seminar4Processsale.dto.ItemDTO;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ItemRegisteryTest {
    private ItemRegistery instanceItemRegistery;
    private ArrayList<ItemDTO> instanceItemDTOList;
    private ArrayList<Integer> instanceItemQuantityList;

    @BeforeEach
    void setUp() {
        instanceItemRegistery = new ItemRegistery();
        instanceItemDTOList = new ArrayList<ItemDTO>();
        instanceItemQuantityList = new ArrayList<Integer>();
    }

    @AfterEach
    void tearDown() {
        instanceItemRegistery = null;
        instanceItemDTOList = null;
        instanceItemQuantityList = null;
    }

    @Test
    void testToAddItemToRegistery() {
        ItemDTO itemDTO1 = new ItemDTO(123, "Milk\t\t\t", 10.9, 0.12);
        instanceItemRegistery.addItemToRegistery(itemDTO1);
        instanceItemQuantityList.add(0, 1);
        String returnedItemDescription = instanceItemRegistery.getItemDTOList().get(0).getItemDescription();
        boolean comparedItemDescription = itemDTO1.getItemDescription().equals(returnedItemDescription);
        assertTrue(comparedItemDescription);
    }

    @Test
    void testToGetItemDTOList() {

        ItemDTO itemDTO1 = new ItemDTO(123, "Milk\t\t\t", 10.9, 0.12);
        ItemDTO itemDTO2 = new ItemDTO(1234, "Strawberry\t\t", 39.99, 0.06);
        instanceItemRegistery.addItemToRegistery(itemDTO1);
        instanceItemRegistery.addItemToRegistery(itemDTO2);
        String returnedItemDescription = instanceItemRegistery.getItemDTOList().get(0).getItemDescription() + ", " + instanceItemRegistery.getItemDTOList().get(1).getItemDescription();
        String expectedReturnedString = "Milk\t\t\t, Strawberry\t\t";
        boolean similarity = returnedItemDescription.equals(expectedReturnedString);
        assertTrue(similarity);

    }

    @Test
    void testToGetItemQuantityList() {
        ItemDTO itemDTO1 = new ItemDTO(123, "Milk\t\t\t", 10.9, 0.12);
        ItemDTO itemDTO2 = new ItemDTO(1234, "Strawberry\t\t", 39.99, 0.06);
        ItemDTO itemDTO3 = new ItemDTO(12345, "Blueberry\t\t", 29.99, 0.06);
        instanceItemRegistery.addItemToRegistery(itemDTO1);
        instanceItemQuantityList.add(0, 1);
        instanceItemRegistery.addItemToRegistery(itemDTO2);
        instanceItemQuantityList.add(1, 1);
        instanceItemRegistery.addItemToRegistery(itemDTO3);
        instanceItemQuantityList.add(2, 1);
        String returnedItemQuantityList = instanceItemRegistery.getItemQuantityList().get(0)+ ", " + instanceItemRegistery.getItemQuantityList().get(1) + ", " + instanceItemRegistery.getItemQuantityList().get(2);
        String expectedReturnedString = "1, 1, 1";
        boolean similarity = returnedItemQuantityList.equals(expectedReturnedString);
        assertTrue(similarity);
    }
}
