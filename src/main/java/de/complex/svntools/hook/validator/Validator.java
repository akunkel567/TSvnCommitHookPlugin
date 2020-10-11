/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.complex.svntools.hook.validator;

import de.complex.svntools.hook.content.Content;
import de.complex.svntools.hook.validator.exception.ValidateException;

/**
 * @author Andreas Kunkel
 */
public interface Validator {

    public void validate(Content content) throws ValidateException;
}
