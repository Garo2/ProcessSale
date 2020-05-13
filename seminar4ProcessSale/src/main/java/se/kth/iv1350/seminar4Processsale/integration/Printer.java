package se.kth.iv1350.seminar4Processsale.integration;
import se.kth.iv1350.seminar4Processsale.dto.ReceiptDTO;

public class Printer {
    public Printer (){

    }

    /**
     * The printer prints the receipts in a specific way which depends on the store's will.
     * @param receiptDTO receive receiptDTO and list the informations in a customized way to be shown on the receipt.
     */
    public void printOutReceipt(ReceiptDTO receiptDTO){
        String printedReceipt = "\n++++++++++++++++++++++++++++++++++++++++++++\n\t\tReceipt\n----------------------------------\n"+receiptDTO.getDateOfSale()+"\n"+ receiptDTO.getStoreAddress()
                + "\n" + receiptDTO.getStoreName()
                + "\n\n" + receiptDTO.getItemsDTOString()
                + "\nTotal price: "+ receiptDTO.getTotalPrice()
                + "\nVat for the entire sale: "+ receiptDTO.getVatForEntireSale()
                + "\nAmount paid: " + receiptDTO.getAmountPaid()
                + "\nchange: " + receiptDTO.getChange() + "\n----------------------------------";

        System.out.println(printedReceipt);
    }
}