/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.complex.svntools.hook.filter;

import de.complex.svntools.hook.filter.exception.FilterException;

/**
 * @author Andreas Kunkel
 */
public interface Filter {

    public boolean filter(String name) throws FilterException;
}
