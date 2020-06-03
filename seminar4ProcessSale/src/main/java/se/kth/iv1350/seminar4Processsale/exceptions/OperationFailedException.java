package se.kth.iv1350.seminar4Processsale.exceptions;

/**
 * The exception that will be passed to the view layer
 */
public class OperationFailedException extends Exception {

    public OperationFailedException(String message)
    {
        super(message);
    }
}
