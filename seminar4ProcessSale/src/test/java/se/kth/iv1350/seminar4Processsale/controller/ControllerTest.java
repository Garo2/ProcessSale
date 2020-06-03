package se.kth.iv1350.seminar4Processsale.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.seminar4Processsale.exceptions.OperationFailedException;
import se.kth.iv1350.seminar4Processsale.integration.AccountingSystem;
import se.kth.iv1350.seminar4Processsale.integration.CustomerDiscountSystem;
import se.kth.iv1350.seminar4Processsale.integration.InventorySystem;
import se.kth.iv1350.seminar4Processsale.integration.Printer;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {

    private Controller controller;

    @BeforeEach
    void setUp() {
        AccountingSystem accountingSystem = new AccountingSystem();
        CustomerDiscountSystem customerDiscountSystem = new CustomerDiscountSystem();
        InventorySystem inventorySystem = new InventorySystem();
        Printer printer = new Printer();
        controller = new Controller(printer, inventorySystem, customerDiscountSystem, accountingSystem);
        controller.startNewSale();
    }

    @AfterEach
    void tearDown() {
        controller = null;
    }

    @Test
    void testOperationFailedException()
    {
        try {
            controller.addItemToSale(1221);
        } catch (OperationFailedException e) {
            return;
        }
        fail("No exception has been thrown. Expected: OperationFailedException");
    }

}
