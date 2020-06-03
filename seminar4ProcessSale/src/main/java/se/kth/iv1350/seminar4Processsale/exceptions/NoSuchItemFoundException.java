package se.kth.iv1350.seminar4Processsale.exceptions;

/**
 * The exception if the cashier enters invalid itemId.
 */
public class NoSuchItemFoundException extends Exception{

    /**
     * @param msg that message choose when calling the method.
     */
    public NoSuchItemFoundException(String msg) {
        super(msg);
    }

}
