package se.kth.iv1350.seminar4Processsale.view;

import se.kth.iv1350.seminar4Processsale.dto.ReceiptDTO;
import se.kth.iv1350.seminar4Processsale.controller.Controller;
import se.kth.iv1350.seminar4Processsale.model.RegistryObserver;

/**
 * View class calls from Main which will represent the cashier in our case and enter values such as itemIds.
 */
public class View {

    private Controller controller;

    /** View class represents the cashier which enter item Ids. So first The cashier starts a new sale, enters customer items Ids.
     * When the cashier is done with registering the items, he/she ends the sale and enters the amount paid and return the change to customer
     * And After the payment is done, the controller call a method in Sale to save the logged sale in AccountingSystem.
     * @param controller
     */
    public View(Controller controller){
        this.controller = controller;
        RegistryObserver registryObserver = new TotalRevenueView();
        controller.registerObserver(registryObserver);
        customerSale();

    }
    private void returnedItem(int itemId) {
        String addedItem = controller.addItemToSale(itemId);
        if(addedItem.equals("")) {

        }
        else {
            System.out.println(addedItem);
        }
    }
    private void customerSale() {
        controller.startNewSale();
        returnedItem(123);
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