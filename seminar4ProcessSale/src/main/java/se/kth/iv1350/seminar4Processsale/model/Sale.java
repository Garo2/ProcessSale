package se.kth.iv1350.seminar4Processsale.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import se.kth.iv1350.seminar4Processsale.dto.*;
import se.kth.iv1350.seminar4Processsale.exceptions.DataBaseConnectionException;
import se.kth.iv1350.seminar4Processsale.exceptions.NoSuchItemFoundException;
import se.kth.iv1350.seminar4Processsale.exceptions.OperationFailedException;
import se.kth.iv1350.seminar4Processsale.integration.*;

/**
 * Sale is the core of the saleProcess here, it pass itemId to register in ItemRegistery, get the totalPrice, itemPrice, vatForEntireSale, etc. from PaymentManager
 * creates an ArrayList of itemDTO to pass them to Printer.
 */
public class Sale {
    private ItemRegistery itemRegistery;
    private PaymentManager paymentManager;
    private AccountingSystem accountingSystem;
    private ReceiptDTO receiptDTO;
    private ArrayList<ItemDTO> itemDTOList;
    private Printer printer;
    private InventorySystem inventorySystem;
    private String currentTime;
    private int itemQuantity;
    private double vatRateForEntireSale;
    private String itemDTOToString ="";
    private SaleLog saleLog;


    /**
     * creating a constructor for Sale with an instance of Log.
     */
    public Sale(Printer printer, InventorySystem inventorySystem, AccountingSystem accountingSystem, PaymentManager paymentManager){
        this.printer = printer;
        this.inventorySystem = inventorySystem;
        this.accountingSystem = accountingSystem;
        this.paymentManager = paymentManager;
    }

    /**
     * startNewSale by creating instances of following Classes to be able to use them later
     */
    public void startNewSale() {
        itemRegistery = new ItemRegistery();
        itemDTOList = new ArrayList<ItemDTO>();
        currentTime = getCurrentTime();
    }

    /**
     * call this method by Controller and View to pass the itemId that needs to be added.
     * add items to itemDTOList and itemQuantity.
     * Print out the added item after every addItem call if the item exists.
     *
     * @param itemId passing the itemId to return the itemDetails for adding them to saleList.
     * @return output return the item details as string
     */
    public String addItem(ItemDTO itemDTO){
        if(itemDTO == null){
            return "";
        }
        else {
            double itemPrice = itemDTO.getItemPriceExcVat();
            double itemVatRate = itemDTO.getItemVatRate();
            itemRegistery.addItemToRegistery(itemDTO);
            itemRegistery.getItemQuantityList();
            itemDTOList = itemRegistery.getItemDTOList();
            double itemPriceIncVat = paymentManager.calcItemPriceIncVat(itemPrice, itemVatRate);
            vatRateForEntireSale = paymentManager.calcVatForEntireSale(itemPrice, itemVatRate);
            double totalPrice = paymentManager.calcTotalPrice(itemPriceIncVat, 1); // set as 1 temp but in logSale multiplies with quantity
            String output = (itemDTO.getItemDescription() + ", " + itemPriceIncVat + ", " + totalPrice + " kr");
            return output;
        }
    }

    /**
     * @return return the totalPrice from paymentManager.
     */
    public double endSale() {
        return paymentManager.getTotalPrice();
    }

    /**
     * @return currentTime of Sale.
     */
    public String getCurrentTime() {
        String currentTime = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
        return  currentTime;
    }

    /**
     * Write the itemDTOList as string to show the list on receipt. later and send a copy to AccountingSystem and returning the itemDTOString as a String.
     * @return itemDTOToString which will be listed on receipt.
     */
    public String itemsToString() {
        for (int i=0; i<itemDTOList.size(); i++) {
            if(itemDTOList.get(i).getItemDescription() == "") {

            }
            else {
                itemQuantity = itemRegistery.getItemQuantityList().get(i);
                itemDTOToString += "-" + itemDTOList.get(i).getItemDescription() + "" + itemQuantity+ " piece/s\t\t price: "+
                        (itemQuantity * paymentManager.getPriceRounded(paymentManager.calcItemPriceIncVat(itemDTOList.get(i).getItemPriceExcVat(), itemDTOList.get(i).getItemVatRate())) + " kr\n");
            }
        }
        return itemDTOToString;
    }

    /**
     * @return itemDTOList which contains the list of added items.
     */
    public ArrayList<ItemDTO> getItemDTOList() {
        return itemDTOList;
    }

    /**
     * save the sale's information, such as itemDTOList, totalPrice, change, the date of sale, etc.
     */
    public void loggedSale() {
        receiptDTO = new ReceiptDTO(currentTime, getItemDTOList(), paymentManager.getTotalPrice(), paymentManager.getPriceRounded(vatRateForEntireSale),paymentManager.getAmountPaid(),
                paymentManager.calcAmountChange(), itemsToString());
        saleLog = new SaleLog(receiptDTO);
        saveLoggedSale(saleLog);
        printReceipt(receiptDTO);
        updateInventorySystem(saleLog);
    }

    /**
     * create an instance of Printer
     * @param receiptDTO be passed to Printer.
     */
    public void printReceipt(ReceiptDTO receiptDTO)
    {
        printer = new Printer();
        printer.printOutReceipt(receiptDTO);
    }



    /**
     * @param saleLog save the loggedSale in AccountingSystem.
     */
    public void saveLoggedSale(SaleLog saleLog) {
        accountingSystem.addSaleLogToSystem(saleLog);
    }

    /**
     * @param saleLog send the saleLog to InventorySystem to update the database.
     */
    public void updateInventorySystem(SaleLog saleLog) {
        InventorySystem.updateInvSystem(saleLog);
    }
}