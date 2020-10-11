/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.complex.svntools.tools;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * @author Andreas Kunkel
 */
public class FileTools {

    public static String getFileContent(File file) throws IOException {

        return FileUtils.readFileToString(file);
    }
}
