/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.complex.svntools.hook.validator;

import de.complex.svntools.hook.content.Content;
import de.complex.svntools.hook.content.exception.ContentException;
import de.complex.svntools.hook.validator.exception.MustHaveValidationException;
import de.complex.svntools.hook.validator.exception.ValidateException;
import de.complex.svntools.tools.StringTools;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Andreas Kunkel
 */
public class MustHave {

    private final boolean regex;
    private final String value;

    public MustHave(String value, boolean regex) {
        this.regex = regex;
        this.value = value;
    }

    public void validate(Content content) throws ValidateException {

        if (this.regex) {
            throw new UnsupportedOperationException("Regex functionality not implemented yet.");
        } else {
            try {
                if (!StringTools.containsIgnoreCase(content.getValue(), value)) {
                    throw new MustHaveValidationException(String.format("Data must contains '%s'", value));
                }
            } catch (ContentException ex) {
                throw new ValidateException(ex);
            }
        }
    }

    @Override
    public String toString() {
        return "MustHave{" + "regex=" + regex + ", value=" + value + '}';
    }
}
