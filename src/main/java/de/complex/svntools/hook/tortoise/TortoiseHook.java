/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.complex.svntools.hook.tortoise;

import de.complex.svntools.hook.exception.SvnHookException;

import java.util.List;

/**
 * @author Andreas Kunkel
 */
public interface TortoiseHook {

    public List<String> getFilenames() throws SvnHookException;
}
