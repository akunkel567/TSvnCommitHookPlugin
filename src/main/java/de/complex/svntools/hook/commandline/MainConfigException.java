/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.complex.svntools.hook.commandline;

/**
 * @author Andreas Kunkel
 */
public class MainConfigException extends Exception {

    /**
     * Creates a new instance of <code>MainConfigException</code> without detail
     * message.
     */
    public MainConfigException() {
    }

    /**
     * Constructs an instance of <code>MainConfigException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public MainConfigException(String msg) {
        super(msg);
    }
}
