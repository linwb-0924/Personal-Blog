package org.fjnu.Exception;

/**
 * @author wb_Lin
 * @create 2020-05-30 11:14
 */
public class NotfoundException extends Exception {
    public NotfoundException() {
    }

    public NotfoundException(String message) {
        super(message);
    }

    public NotfoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
