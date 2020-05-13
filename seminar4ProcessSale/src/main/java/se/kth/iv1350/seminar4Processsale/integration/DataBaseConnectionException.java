package se.kth.iv1350.seminar4Processsale.integration;

/**
 *
 */
public class DataBaseConnectionException extends Exception{
    /**
     * @param msg writes a massage to DataBaseConnection to show to user.
     */
    public DataBaseConnectionException(String msg) {
        super(msg);
    }
}
