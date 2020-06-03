package se.kth.iv1350.seminar4Processsale.exceptions;

/**
 *
 */
public class DataBaseConnectionException extends Exception{
    /**
     * @param msg writes a message to DataBaseConnection to show to user.
     */
    public DataBaseConnectionException(String msg) {
        super(msg);
    }
}
