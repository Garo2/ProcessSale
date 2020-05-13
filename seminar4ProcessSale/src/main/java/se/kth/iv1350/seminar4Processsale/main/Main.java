package se.kth.iv1350.seminar4Processsale.main;

import se.kth.iv1350.seminar4Processsale.integration.*;
import se.kth.iv1350.seminar4Processsale.view.View;
import se.kth.iv1350.seminar4Processsale.controller.*;

/**
 * Main class runs first and creates instances of some classes that will be created only once when the whole system start for the first time
 */
public class Main {
    public static void main(String[] args) {
        AccountingSystem accountingSystem = new AccountingSystem();
        CustomerDiscountSystem customerDiscountSystem = new CustomerDiscountSystem();
        InventorySystem inventorySystem = new InventorySystem();
        Printer printer = new Printer();
        Controller controller = new Controller(printer, inventorySystem, customerDiscountSystem, accountingSystem);
        View view = new View(controller);
    }
}