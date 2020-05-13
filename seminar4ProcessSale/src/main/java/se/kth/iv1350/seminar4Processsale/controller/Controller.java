package se.kth.iv1350.seminar4Processsale.controller;

import se.kth.iv1350.seminar4Processsale.integration.*;
import se.kth.iv1350.seminar4Processsale.model.*;

/**
 * Controller transfer the data from View/cashier to model and other packages.
 */
public class Controller {

    private Printer printer;
    private InventorySystem inventorySystem;
    private CustomerDiscountSystem customerDiscountSystem;

    private Sale sale;
    private ItemRegistery itemRegistery;
    private PaymentManager paymentManager;
    private AccountingSystem accountingSystem;

    /**
     * @param printer an instance of Printer which will print the receipt later.
     * @param inventorySystem contains all store's items.
     * @param customerDiscountSystem the system of customers discounts
     * @param accountingSystem stores the loggedSale after each completed sale.
     */
    public Controller(Printer printer, InventorySystem inventorySystem, CustomerDiscountSystem customerDiscountSystem, AccountingSystem accountingSystem) {
        this.printer = printer;
        this.inventorySystem = inventorySystem;
        this.customerDiscountSystem = customerDiscountSystem;
        this.accountingSystem = accountingSystem;
        this.paymentManager = new PaymentManager();
    }

    /**
     * Starting the new sale by calling this method which creates an instance of class Sale.
     */

    public void startNewSale() {
        this.sale = new Sale(this.printer, this.inventorySystem, this.accountingSystem, this.paymentManager);
        sale.startNewSale();
    }

    /**
     * @param itemId the id which has been entered by cashier.
     * @return returns the itemDTO.
     */
    public String addItemToSale(int itemId) {
        if(sale.addItem(itemId).equals("")){
            return "";
        }
        return sale.addItem(itemId);
    }

    /**
     * Ending the sale and return the total price to be shown to the customer and cashier
     * @return the totalPrice.
     */
    public double endSale() {

        return sale.endSale();
    }

    /**
     * @param amountPaid the amount of money that the customer has paid.
     * @return
     */
    public double enterAmountPaid(int amountPaid) {
        double change = paymentManager.processPayment(amountPaid);
        sale.loggedSale();
        return change;
    }

    public void registerObserver(RegistryObserver observer) {
        paymentManager.registerObserver(observer);
    }

}