/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.complex.svntools.tools;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Andreas Kunkel
 */
public class StringTools {

    public static boolean containsIgnoreCase(String string, String stringToSearch) {
        return StringUtils.containsIgnoreCase(string, stringToSearch);
    }
}
