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
public class FileContent implements Content {

    File file;

    public FileContent(File file) {
        this.file = file;
    }

    public FileContent(String path) {
        this.file = new File(path);
    }

    @Override
    public String getValue() throws ContentException {

        try {
            return FileTools.getFileContent(file);
        } catch (IOException ex) {
            throw new ContentException(ex);
        }
    }

    public String getFilename() {
        return this.file.getName();
    }
}
