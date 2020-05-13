package se.kth.iv1350.seminar4Processsale.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Register the income to the system after each payment.
 */
public class RegisterIncomeHandler {
    private double incomeAmount;
    private List<RegistryObserver> observersList;

    /**
     * Register the income to the system after each payment.
     */
    public RegisterIncomeHandler() {
        observersList = new ArrayList<RegistryObserver>();
    }

    /**
     * @param totalPrice updates and increase the amount of totalPrice to RegisterIncomeHandler
     */
    public void updateRegisterAmount(double totalPrice) {
        this.incomeAmount += totalPrice;
        for (RegistryObserver observer: observersList) {
            observer.incomeChange(incomeAmount);
        }
    }

    public void registerObserver(RegistryObserver observer) {
        observersList.add(observer);
    }
}
