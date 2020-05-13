package se.kth.iv1350.seminar4Processsale.model;

/**
 * This class calculates all calculations of totalPrice for entireSale, calculate the difference between amountPaid and totalPrice and return it as change, VatForEntireSale..
 */
public class PaymentManager {

    private double totalPrice;
    private double change;
    private int amountPaid;
    private double itemPrice;
    private double VatEntireSale;
    RegisterIncomeHandler registerIncomeHandler;

    /**
     *  calculates the change and return the value with rounding the answer into 2 decimal number,
     */
    public PaymentManager() {
        this.registerIncomeHandler = new RegisterIncomeHandler();
    }

    /**
     * @return the amount that the cashier supposed to give the customer back.
     */
    public double calcAmountChange() {
        this.change = amountPaid - totalPrice;
        return (double)Math.round( change*100 )/100;
    }


    /**
     * @param amountPaid amountPaid that customer pays for cashier
     * @return returning the change of amountPaid.
     */
    public double processPayment(int amountPaid)
    {
        this.amountPaid = amountPaid;
        double paymentChange = this.calcAmountChange();
        double totPrice = getTotalPrice();
        registerIncomeHandler.updateRegisterAmount(totPrice);
        return paymentChange;
    }

    /**
     * @param itemPrice the price for each item after calculating the price including vat
     * @param itemQuantity the quantity of registered item with the entered itemId,
     * @return return the totalPrice after each item until all items have been registered.
     */
    public double calcTotalPrice(double itemPrice, int itemQuantity)
    {
       return totalPrice += (itemPrice * itemQuantity);
    }

    /**
     * calculates the vatForEntireSale and return the value with rounding the answer into 2 decimal number.
     * @param itemPrice itemPrice excluding vat from the itemDTO.
     * @param itemVatRate itemVatRate depends on each item in InventorySystem.
     * @return the VatEntireSale after each item has been added until all items has been registered.
     */
    public double calcVatForEntireSale(double itemPrice, double itemVatRate) {
        return this.VatEntireSale += itemPrice * itemVatRate;
    }

    /**
     *  calculates the itemPriceIncVat and return the value with rounding the answer into 2 decimal number,
     * @param itemPrice
     * @param itemVatRate
     * @return update the itemPrice after by adding vatAmount to ItemPriceExcludingVat.
     */
    public double calcItemPriceIncVat(double itemPrice, double itemVatRate) {
       return this.itemPrice = itemPrice+(getPriceRounded(itemPrice * itemVatRate));
    }

    /**
     * calculates the totalPrice and return the value with rounding the answer into 2 decimal number,
     * @return return totalPrice with rounding for 2 decimals number.
     */
    public double getTotalPrice() {
        return (double)Math.round( totalPrice*100 )/100;
    }


    /**
     * @return amountPaid
     */
    public int getAmountPaid() {
        return amountPaid;
    }

    /**
     * Rounding each price which call this method, into a number with only 2 decimal numbers.
     * @param price itemPrice includingVat
     * @return rounding the price to 2 decimals number.
     */
    public double getPriceRounded(double price) {
        return ((double)Math.round( price*100 ))/ 100;
    }

    public void registerObserver(RegistryObserver observer) {
        registerIncomeHandler.registerObserver(observer);
    }
}