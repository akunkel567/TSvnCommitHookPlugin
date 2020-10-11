/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.complex.svntools.hook.rule;

import de.complex.svntools.hook.content.StringContent;
import de.complex.svntools.hook.validator.NotAllowed;
import de.complex.svntools.hook.validator.exception.NotAllowedValidationException;
import org.junit.Test;
import org.junit.Ignore;

/**
 * @author Andreas Kunkel
 */
public class NotAllowedTest {

    public NotAllowedTest() {
    }

    @Test(expected = NotAllowedValidationException.class)
    public void testValidateContentNotOK() throws Exception {

        NotAllowed notAllowed = new NotAllowed("DEFINER", false);
        notAllowed.validate(new StringContent("testDEFINERtest"));
    }

    @Test
    public void testValidateContentOK() throws Exception {

        NotAllowed notAllowed = new NotAllowed("DEFINER", false);
        notAllowed.validate(new StringContent("testtesttesttest"));
    }

    @Test(expected = NotAllowedValidationException.class)
    @Ignore
    public void testValidateContentRegexNotOK() throws Exception {

        NotAllowed notAllowed = new NotAllowed("DEFINER", true);
        notAllowed.validate(new StringContent("testDEFINERtest"));
    }

    @Test
    @Ignore
    public void testValidateContentRegexOK() throws Exception {

        NotAllowed notAllowed = new NotAllowed("DEFINER", true);
        notAllowed.validate(new StringContent("testtesttesttest"));
    }
}
