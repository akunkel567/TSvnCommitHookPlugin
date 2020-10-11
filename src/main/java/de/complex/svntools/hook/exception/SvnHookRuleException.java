/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.complex.svntools.hook.exception;

/**
 * @author Andreas Kunkel
 */
public class SvnHookRuleException extends SvnHookException {

    /**
     * Creates a new instance of <code>SvnHookExecuteException</code> without
     * detail message.
     */
    public SvnHookRuleException() {
    }

    /**
     * Constructs an instance of <code>SvnHookExecuteException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public SvnHookRuleException(String msg) {
        super(msg);
    }

    public SvnHookRuleException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
