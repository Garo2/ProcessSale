package se.kth.iv1350.seminar4Processsale.integration;

import se.kth.iv1350.seminar4Processsale.dto.SaleLog;
import java.util.ArrayList;

/**
 * This class contains the loggedSale for each customer. by passing the information using the class SaleLog
 */
public class AccountingSystem {
    private ArrayList<SaleLog> saleLogList;

    /**
     * constructor for the class AccountingSystem.
     */
    public AccountingSystem() {

        saleLogList = new ArrayList<SaleLog>();
    }

    /**
     * @param saleLog which will be received from SaleLog
     */
    public void addSaleLogToSystem(SaleLog saleLog) {

        this.saleLogList.add(saleLog);
    }

    /**
     * @return saleLogList: the loggedSale as a list for each customer.
     */
    public ArrayList<SaleLog> getSaleLogList() {
        return saleLogList;
    }
}
