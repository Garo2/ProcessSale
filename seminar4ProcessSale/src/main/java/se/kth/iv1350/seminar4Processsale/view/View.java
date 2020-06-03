package se.kth.iv1350.seminar4Processsale.view;

import se.kth.iv1350.seminar4Processsale.dto.ReceiptDTO;
import se.kth.iv1350.seminar4Processsale.controller.Controller;
import se.kth.iv1350.seminar4Processsale.exceptions.OperationFailedException;
import se.kth.iv1350.seminar4Processsale.integration.Logger;
import se.kth.iv1350.seminar4Processsale.model.RegistryObserver;

/**
 * View class calls from Main which will represent the cashier in our case and enter values such as itemIds.
 */
public class View {
    private Controller controller;
    private Logger logger;

    /** View class represents the cashier who enter item Ids. So first The cashier starts a new sale, enters customer items Ids.
     * When the cashier is done with registering the items, he/she ends the sale and enters the amount paid and return the change to customer
     * And After the payment is done, the controller call a method in Sale to save the logged sale in AccountingSystem.
     * @param controller
     */
    public View(Controller controller){
        this.controller = controller;
        this.logger = new Logger();
        RegistryObserver registryObserver = new TotalRevenueView();
        controller.registerObserver(registryObserver);
        customerSale();
    }

    /** the details of the returned item.
     * @param itemId the entered Id of each item.
     */
    private void returnedItem(int itemId) {
        String addedItem = "";
        try {
            addedItem = controller.addItemToSale(itemId);
        } catch (OperationFailedException e) {
            System.out.println(e.getMessage());
        }
        if(addedItem.equals("")) {

        }
        else {
            System.out.println(addedItem);
        }
    }

    /**
     * For each customer Sale
     */
    private void customerSale() {
        controller.startNewSale();
        returnedItem(1222);
        returnedItem(1234);
        returnedItem(12345);
        returnedItem(123456);
        returnedItem(123456);
        returnedItem(1111);
        returnedItem(222222);
        returnedItem(222222);
        returnedItem(222);
        returnedItem(0);
        int amountPaid = 1000;
        System.out.println("The sale has been ended, The totalPrice is: "+ controller.endSale());
        System.out.println(amountPaid + " kr has been paid, the change: " + controller.enterAmountPaid(amountPaid));
    }
}