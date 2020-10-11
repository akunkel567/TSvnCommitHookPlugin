/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.complex.svntools.hook.content.exception;

/**
 * @author Andreas Kunkel
 */
public class ContentException extends Exception {

    /**
     * Creates a new instance of <code>ContentLoadException</code> without
     * detail message.
     */
    public ContentException() {
    }

    /**
     * Constructs an instance of <code>ContentLoadException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ContentException(String msg) {
        super(msg);
    }

    public ContentException(Throwable cause) {
        super(cause);
    }

}
