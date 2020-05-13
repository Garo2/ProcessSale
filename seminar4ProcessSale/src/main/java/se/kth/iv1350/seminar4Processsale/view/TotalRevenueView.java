package se.kth.iv1350.seminar4Processsale.view;

import se.kth.iv1350.seminar4Processsale.model.RegistryObserver;

public class TotalRevenueView implements RegistryObserver {

    @Override
    public void incomeChange(double amountPaid) {
        System.out.println("\nTotal Revenue: " + amountPaid + "\n");
    }
}
