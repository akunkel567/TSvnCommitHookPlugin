/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.complex.svntools.hook.content;

import de.complex.svntools.tools.FileTools;

import java.io.File;
import java.io.IOException;

import de.complex.svntools.hook.content.exception.ContentException;

/**
 * @author Andreas Kunkel
 */
public class StringContent implements Content {

    String string;

    public StringContent(String string) {
        this.string = string;
    }

    @Override
    public String getValue() throws ContentException {

        return string;
    }
}
