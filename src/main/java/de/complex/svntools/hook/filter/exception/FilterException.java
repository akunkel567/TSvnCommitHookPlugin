/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.complex.svntools.hook.filter.exception;

/**
 * @author Andreas Kunkel
 */
public class FilterException extends Exception {

    /**
     * Creates a new instance of <code>FilterException</code> without detail
     * message.
     */
    public FilterException() {
    }

    /**
     * Constructs an instance of <code>FilterException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public FilterException(String msg) {
        super(msg);
    }
}
