/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.complex.svntools.hook.validator.exception;

/**
 * @author Andreas Kunkel
 */
public class MustHaveValidationException extends RuleValidateException {

    /**
     * Creates a new instance of <code>MustHaveValidationException</code>
     * without detail message.
     */
    public MustHaveValidationException() {
    }

    /**
     * Constructs an instance of <code>MustHaveValidationException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public MustHaveValidationException(String msg) {
        super(msg);
    }

    public MustHaveValidationException(Throwable cause) {
        super(cause);
    }
}
