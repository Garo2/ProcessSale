package se.kth.iv1350.seminar4Processsale.integration;

/**
 * The exception if the cashier enters invalid itemId.
 */
public class NoSuchItemFoundException extends Exception{

    /**
     * @param msg that massage choose when calling the method.
     */
    public NoSuchItemFoundException(String msg) {
        super(msg);
    }

}
