package se.kth.iv1350.seminar4Processsale.dto;
import java.util.ArrayList;
import se.kth.iv1350.seminar4Processsale.model.Sale;

/**
 * The receiptDTO includes all information about sale, store address, itemList, etc. which are necessary and will be used to print the receipt by Printer.
 */
public final class ReceiptDTO {
    private String dateOfSale;
    private String storesName;
    private String storeAddress;
    private ArrayList<ItemDTO> itemDTOList;
    private double totalPrice;
    private double vatForEntireSale;
    private double amountPaid;
    private double change;
    private Sale sale;
    private String itemsDTOString;

    public ReceiptDTO(String dateOfSale, ArrayList<ItemDTO> itemDTOList, double totalPrice, double vatForEntireSale, double amountPaid, double change, String itemsDTOString){
        this.dateOfSale = dateOfSale;
        this.storesName="Alpha Store";
        this.storeAddress = "Kämpevägen 20, 15163 Södertälje";
        this.itemDTOList = itemDTOList;
        this.totalPrice = totalPrice;
        this.vatForEntireSale = vatForEntireSale;
        this.amountPaid = amountPaid;
        this.change = change;
        this.itemsDTOString = itemsDTOString;
    }

    /**
     * @return the amountPaid
     */
    public double getAmountPaid() {
        return amountPaid;
    }
    /**
     * @return the change
     */
    public double getChange() {
        return change;
    }
    /**
     * @return the dateOfSale
     */
    public String getDateOfSale() {
        return dateOfSale;
    }

    /**
     * @return the storesName
     */
    public String getStoreName() {
        return storesName;
    }
    /**
     * @return the storeAddress
     */
    public String getStoreAddress() {
        return storeAddress;
    }
    /**
     * @return the totalPrice
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /** Get the vatForTheEntireSale which works by adding the difference between totalPrice including vat and totalPrice excluding vat.
     * @return the vatForEntireSale
     */
    public double getVatForEntireSale() {
        return vatForEntireSale;
    }


    /**
     * @return itemsDTOString which presents the itemsList as string
     */
    public String getItemsDTOString() {
        return itemsDTOString;
    }

    /**
     * @return saved ItemDTOList as <ArrayList>ItemDTO<ArrayList/>.
     */
    public ArrayList<ItemDTO> getItemDTOList() {
        return itemDTOList;
    }
}
