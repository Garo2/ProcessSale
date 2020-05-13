package se.kth.iv1350.seminar4Processsale.model;

import se.kth.iv1350.seminar4Processsale.dto.ItemDTO;
import java.util.ArrayList;

/**
 * ItemRegistery Saves the Items in list, update the list, updating the items quantity.
 */
public class ItemRegistery {

    private ArrayList<ItemDTO> itemDTOList;
//    private double totalPrice;
    private ArrayList<Integer> itemQuantityList;

    /**
     * By creating an instance, the program creates instances of ArrayList of object ItemDTO and ArrayList of object Integer which represents a list of bought items quantity.
     *
     */
    public ItemRegistery() {
        itemDTOList = new ArrayList<ItemDTO>();
        itemQuantityList = new ArrayList<Integer>();
    }

    /**
     * @param item contiains the current item of type <<ItemDTO>> to store it in ItemRegesteiry
     */
    public void addItemToRegistery(ItemDTO item) // return itemDTO //only the current item;
    {
        for (int i =0; i<itemDTOList.size(); i++) {
            if (item.getItemDescription().equals(itemDTOList.get(i).getItemDescription())) {
                int itemQuantity = this.itemQuantityList.get(i);
                itemQuantity++;
                this.itemQuantityList.set(i, itemQuantity);
                return;
            }
        }
        itemDTOList.add(item);
        itemQuantityList.add(1);
    }

    /**
     * @return the itemDTOList
     */
    public ArrayList<ItemDTO> getItemDTOList() {

        return itemDTOList;
    }
    /**
     * @return the itemQuantityList
     */
    public ArrayList<Integer> getItemQuantityList() {
        return itemQuantityList;
    }

}