/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.complex.svntools.hook.validator.exception;

/**
 * @author Andreas Kunkel
 */
public class RuleValidateException extends ValidateException {

    /**
     * Creates a new instance of <code>RuleValidateException</code> without
     * detail message.
     */
    public RuleValidateException() {
    }

    /**
     * Constructs an instance of <code>RuleValidateException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public RuleValidateException(String msg) {
        super(msg);
    }

    public RuleValidateException(Throwable cause) {
        super(cause);
    }
}
