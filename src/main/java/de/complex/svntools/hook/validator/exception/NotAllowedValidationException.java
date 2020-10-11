/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.complex.svntools.hook.validator.exception;

/**
 * @author Andreas Kunkel
 */
public class NotAllowedValidationException extends RuleValidateException {

    /**
     * Creates a new instance of <code>MustHaveValidationException</code>
     * without detail message.
     */
    public NotAllowedValidationException() {
    }

    /**
     * Constructs an instance of <code>MustHaveValidationException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public NotAllowedValidationException(String msg) {
        super(msg);
    }

    public NotAllowedValidationException(Throwable cause) {
        super(cause);
    }
}
