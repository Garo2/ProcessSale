package se.kth.iv1350.seminar4Processsale.integration;

import se.kth.iv1350.seminar4Processsale.dto.ItemDTO;
import se.kth.iv1350.seminar4Processsale.dto.SaleLog;

/**
 * This system includes the store's items, and all necessary information. and the itemDTO[] updates repeatedly after each sale
 */
public class InventorySystem {

    private ItemDTO[] storeStock;

    /**
     * The store's inventory system which contains all information about store's items.
     */
    public InventorySystem() {
        this.storeStock = new ItemDTO[] {
                new ItemDTO(123, "Milk\t\t\t", 10.90, 0.12),
                new ItemDTO(1234, "Strawberry\t\t", 39.99, 0.06),
                new ItemDTO(12345, "Blueberry\t\t", 29.99, 0.06),
                new ItemDTO(123456, "Water   \t\t", 15.95, 0.06),
                new ItemDTO(654321, "Cola    \t\t", 17.95, 0.12),
                new ItemDTO(54321, "Pepsi    \t\t", 18.95, 0.12),
                new ItemDTO(4321, "Chips     \t\t", 21.95, 0.25),
                new ItemDTO(321, "Apple\t\t\t", 20.95, 0.12),
                new ItemDTO(111111, "Orange  \t\t", 20.95, 0.12),
                new ItemDTO(222222, "Lemon   \t\t", 9.99, 0.12),
                new ItemDTO(333333, "Cucumber\t\t", 19.95, 0.12),
                new ItemDTO(444444, "Tomato  \t\t", 25.95, 0.12),
                new ItemDTO(0, "", 0, 0)
        };
    }


    /**
     * /**
     * @param itemIdentification the itemId that the cashier want to register.
     * @return Returns the itemInfo with the specified itemId.
     * @throws NoSuchItemFoundException if no items has been found with the following itemId
     * @throws DataBaseConnectionException if the connection to database failed.
     */
    public ItemDTO getItemInfo(int itemIdentification) throws NoSuchItemFoundException, DataBaseConnectionException
    {
        if(itemIdentification == 0) {
            throw new DataBaseConnectionException("The connection to database failed, please try again");
        }
        for(int i=0; i<storeStock.length; i++)
        {
            ItemDTO tempItemDTO = storeStock[i];
            int itemId = tempItemDTO.getItemIdentification();
            if(itemIdentification == itemId)
            {
                return storeStock[i];
            }
        }
        throw new NoSuchItemFoundException("No item has been found with Id: " + itemIdentification);
    }

    /**
     * @param saleLog the saved log to update the InventorySystem
     */
    public static void updateInvSystem(SaleLog saleLog) {

    }


}