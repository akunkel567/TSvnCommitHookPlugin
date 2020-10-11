/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.complex.svntools.hook.rule;

import de.complex.svntools.hook.validator.ContentValidator;
import de.complex.svntools.config.Config;
import de.complex.svntools.config.ObjectFactory;
import de.complex.svntools.hook.content.Content;
import de.complex.svntools.hook.content.StringContent;
import de.complex.svntools.hook.validator.exception.MustHaveValidationException;
import de.complex.svntools.hook.validator.exception.NotAllowedValidationException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Ignore;

/**
 * @author Andreas Kunkel
 */
public class ContentValidatorTest {

    public ContentValidatorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of validate method, of class ContentValidator.
     */
    @Test
    public void testValidateMustHaveOk() throws Exception {
        System.out.println("testValidateMustHaveOk");

        Content content = new StringContent("testtestMUSTHAVEtesttest");
        ContentValidator instance = ContentValidator.createFromConfig(createConfigRuleMustHave("MUSTHAVE"));
        instance.validate(content);
    }

    @Test(expected = MustHaveValidationException.class)
    public void testValidateMustHaveFaulty() throws Exception {
        System.out.println("testValidateMustHaveFaulty");

        Content content = new StringContent("testtesttesttest");
        ContentValidator instance = ContentValidator.createFromConfig(createConfigRuleMustHave("MUSTHAVE"));
        instance.validate(content);
    }

    @Test
    public void testValidateNotAllowedOk() throws Exception {
        System.out.println("testValidateNotAllowedOk");

        Content content = new StringContent("testtesttesttest");
        ContentValidator instance = ContentValidator.createFromConfig(createConfigRuleNotAllowed("NOTALLOWED"));
        instance.validate(content);
    }

    @Test(expected = NotAllowedValidationException.class)
    public void testValidateNotAllowedFaulty() throws Exception {
        System.out.println("testValidateNotAllowedFaulty");

        Content content = new StringContent("testtestNOTALLOWEDtesttest");
        ContentValidator instance = ContentValidator.createFromConfig(createConfigRuleNotAllowed("NOTALLOWED"));
        instance.validate(content);
    }

    /**
     * Test of createFromConfig method, of class ContentValidator.
     */
    @Test
    @Ignore
    public void testCreateFromConfig() {
        System.out.println("createFromConfig");
        Config.Rule configRule = null;
        ContentValidator expResult = null;
        ContentValidator result = ContentValidator.createFromConfig(configRule);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    private Config.Rule createConfigRuleMustHave(String must) {
        ObjectFactory of = new ObjectFactory();

        Config.Rule rule = of.createConfigRule();
        rule.setName("TestRule");

        rule.setFilter(null);

        Config.Rule.MustHave mustHave = of.createConfigRuleMustHave();
        mustHave.setRegex(false);
        mustHave.setValue(must);
        rule.getMustHave().add(mustHave);

        return rule;
    }

    private Config.Rule createConfigRuleNotAllowed(String not) {
        ObjectFactory of = new ObjectFactory();

        Config.Rule rule = of.createConfigRule();
        rule.setName("TestRule");

        rule.setFilter(null);

        Config.Rule.NotAllowed notAllowed = of.createConfigRuleNotAllowed();
        notAllowed.setRegex(false);
        notAllowed.setValue(not);
        rule.getNotAllowed().add(notAllowed);

        return rule;
    }

}
