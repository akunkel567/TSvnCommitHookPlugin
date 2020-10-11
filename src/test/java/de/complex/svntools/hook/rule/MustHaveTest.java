/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.complex.svntools.hook.rule;

import de.complex.svntools.hook.content.StringContent;
import de.complex.svntools.hook.validator.MustHave;
import de.complex.svntools.hook.validator.exception.MustHaveValidationException;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Andreas Kunkel
 */
public class MustHaveTest {

    public MustHaveTest() {
    }

    @Test(expected = MustHaveValidationException.class)
    public void testValidateContentNotOK() throws Exception {

        MustHave mustHave = new MustHave("DEFINER", false);
        mustHave.validate(new StringContent("testtesttesttest"));
    }

    @Test(expected = MustHaveValidationException.class)
    public void testValidateContentOK() throws Exception {

        MustHave mustHave = new MustHave("DEFINER", false);
        mustHave.validate(new StringContent("testtesttesttest"));
    }

    @Test(expected = MustHaveValidationException.class)
    @Ignore
    public void testValidateContentRegexNotOK() throws Exception {

        MustHave mustHave = new MustHave("DEFINER", true);
        mustHave.validate(new StringContent("testtesttesttest"));
    }

    @Test
    @Ignore
    public void testValidateContentRegexOK() throws Exception {

        MustHave mustHave = new MustHave("DEFINER", true);
        mustHave.validate(new StringContent("testtestDEFINERtesttest"));
    }
}
