package se.kth.iv1350.seminar4Processsale.dto;
/**
 * Includes all information about items which been returned from InventorySystem, includes itemIdentification, itemDescription, itemPriceExclduing vatRate and Item rate
 * * to use later to calculate the total price and items price including vat.  and getters method which returns the Class's modifiers.
 */

public class ItemDTO {
    private int itemIdentification;
    private String itemDescription;
    private double itemPriceExcVat;
    private double itemVatRate;

    /**
     * @param itemIdentification itemId that has been returned from <class>InventorySystem<class>
     * @param itemDescription itemDescription that has been returned from <class>InventorySystem<class>
     * @param itemPriceExcVat itemPriceExcVat that has been returned from <class>InventorySystem<class>
     * @param itemVatRate itemVatRate that has been returned from <class>InventorySystem<class>
     */
    public ItemDTO(int itemIdentification, String itemDescription, double itemPriceExcVat, double itemVatRate)
    {
        this.itemIdentification = itemIdentification;
        this.itemDescription = itemDescription;
        this.itemPriceExcVat = itemPriceExcVat;
        this.itemVatRate = itemVatRate;
    }
    /**
     * @return the itemIdentification
     */
    public int getItemIdentification() {
        return itemIdentification;
    }

    /**
     * @return the itemDescription
     */
    public String getItemDescription() {
        return itemDescription;
    }
    /**
     * @return the itemPriceExcVat
     */
    public double getItemPriceExcVat() {
        return itemPriceExcVat;
    }
    /**
     * @return the itemVatRate
     */
    public double getItemVatRate() {
        return itemVatRate;
    }
}
