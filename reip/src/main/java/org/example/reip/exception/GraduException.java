package org.example.reip.exception;

/**
 * @author cyan
 * @since 2022/3/26
 */
public class GraduException extends RuntimeException{
    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public GraduException(String message) {
        super(message);
    }
}
