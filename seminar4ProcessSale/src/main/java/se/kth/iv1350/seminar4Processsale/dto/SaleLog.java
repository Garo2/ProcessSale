package se.kth.iv1350.seminar4Processsale.dto;

import se.kth.iv1350.seminar4Processsale.model.Sale;
import java.util.ArrayList;

/**
 * This class has almost the same modifiers as receiptDTO except the storeAddress and storeName, These information are necessary to be saved later in AccountingSystem
 */
public class SaleLog {
    private String dateOfSale;
    private ArrayList<ItemDTO> itemDTOList;
    private double totalPrice;
    private double vatForEntireSale;
    private double amountPaid;
    private double change;
    private Sale sale;
    private String itemsDTOString;

    /**
     * @param receiptDTO includes all information and details that will be presented on ReceiptDTO.
     */
    public SaleLog(ReceiptDTO receiptDTO) {
        this.dateOfSale = receiptDTO.getDateOfSale();
        this.itemDTOList = receiptDTO.getItemDTOList();
        this.totalPrice = receiptDTO.getTotalPrice();
        this.vatForEntireSale = receiptDTO.getVatForEntireSale();
        this.amountPaid = receiptDTO.getAmountPaid();
        this.change = receiptDTO.getChange();
        this.itemsDTOString = receiptDTO.getItemsDTOString();
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
     * @return the totalPrice
     */
    public double getTotalPrice() {
        return totalPrice;
    }
    /**
     * @return the vatForEntireSale
     */
    public double getVatForEntireSale() {
        return vatForEntireSale;
    }

    /**
     * @return itemsDTOString which will be sent to Printer
     */
    public String getItemsDTOString() {
        return itemsDTOString;
    }

    /**
     * @return itemDTOList which will be rewritten as string to print them out.
     */
    public ArrayList<ItemDTO> getItemDTOList() {
        return itemDTOList;
    }

}
