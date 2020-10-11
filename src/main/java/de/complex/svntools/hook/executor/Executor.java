/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.complex.svntools.hook.executor;

import de.complex.svntools.hook.exception.SvnHookException;

/**
 * @author Andreas Kunkel
 */
public interface Executor {

    public void execute() throws SvnHookException;

}
