/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.complex.svntools.hook.content;

import de.complex.svntools.hook.content.exception.ContentException;

/**
 * @author Andreas Kunkel
 */
public interface Content {

    public String getValue() throws ContentException;

}
