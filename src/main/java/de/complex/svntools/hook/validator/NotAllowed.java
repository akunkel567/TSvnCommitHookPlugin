/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.complex.svntools.hook.validator;

import de.complex.svntools.hook.content.Content;
import de.complex.svntools.hook.content.exception.ContentException;
import de.complex.svntools.hook.validator.exception.NotAllowedValidationException;
import de.complex.svntools.hook.validator.exception.ValidateException;
import de.complex.svntools.tools.StringTools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Andreas Kunkel
 */
public class NotAllowed {

    private final boolean regex;
    private final String value;

    public NotAllowed(String value, boolean regex) {
        this.regex = regex;
        this.value = value;
    }

    public void validate(Content content) throws ValidateException {

        if (this.regex) {
            Pattern pattern = Pattern.compile(this.value);
            Matcher matcher = null;
            try {
                matcher = pattern.matcher(content.getValue());
            } catch (ContentException ex) {
                throw new ValidateException(ex);
            }

            if (matcher.matches()) {
                throw new NotAllowedValidationException(String.format("Data contains not allowed content for regex pattern '%s'", value));
            }
        } else {

            try {
                if (StringTools.containsIgnoreCase(content.getValue(), value)) {
                    throw new NotAllowedValidationException(String.format("Data contains not allowed content '%s'", value));
                }
            } catch (ContentException ex) {
                throw new ValidateException(ex);
            }
        }
    }

    @Override
    public String toString() {
        return "NotAllowed{" + "regex=" + regex + ", value=" + value + '}';
    }
}
