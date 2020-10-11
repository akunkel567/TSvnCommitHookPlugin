/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.complex.svntools.hook.filter;

import de.complex.svntools.config.Config;
import de.complex.svntools.config.Config.Rule;
import de.complex.svntools.config.FilterType;
import de.complex.svntools.hook.filter.exception.FilterException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Andreas Kunkel
 */
public class FilenameFilterTest {

    public FilenameFilterTest() {
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

    @Test
    public void testFilterEqualsOk() throws Exception {
        System.out.println("testFilterEqualsOk");
        String filename = "test.txt";

        Rule.Filter filter = new Rule.Filter();
        filter.setType(FilterType.EQUALS);
        filter.setValue("test.txt");

        FilenameFilter instance = new FilenameFilter(filter);

        boolean expResult = true;
        boolean result = instance.filter(filename);

        assertEquals(expResult, result);
    }

    @Test
    public void testFilterEqualsNotOk() throws Exception {
        System.out.println("testFilterEqualsNotOk");
        String filename = "tester.txt";

        Rule.Filter filter = new Rule.Filter();
        filter.setType(FilterType.EQUALS);
        filter.setValue("test.txt");

        FilenameFilter instance = new FilenameFilter(filter);

        boolean expResult = false;
        boolean result = instance.filter(filename);

        assertEquals(expResult, result);
    }

    @Test
    public void testFilterContainsOk() throws Exception {
        System.out.println("testFilterContainsOk");
        String filename = "abcxyabc.txt";

        Rule.Filter filter = new Rule.Filter();
        filter.setType(FilterType.CONTAINS);
        filter.setValue("xy");

        FilenameFilter instance = new FilenameFilter(filter);

        boolean expResult = true;
        boolean result = instance.filter(filename);

        assertEquals(expResult, result);
    }

    @Test
    public void testFilterContainsNotOk() throws Exception {
        System.out.println("testFilterContainsNotOk");
        String filename = "abcxyabc.txt";

        Rule.Filter filter = new Rule.Filter();
        filter.setType(FilterType.CONTAINS);
        filter.setValue("sz");

        FilenameFilter instance = new FilenameFilter(filter);

        boolean expResult = false;
        boolean result = instance.filter(filename);

        assertEquals(expResult, result);
    }

    @Test
    public void testFilterStartsWithOk() throws Exception {
        System.out.println("testFilterStartsWithOk");
        String filename = "xcabcde.txt";

        Rule.Filter filter = new Rule.Filter();
        filter.setType(FilterType.STARTS_WITH);
        filter.setValue("xc");

        FilenameFilter instance = new FilenameFilter(filter);

        boolean expResult = true;
        boolean result = instance.filter(filename);

        assertEquals(expResult, result);
    }

    @Test
    public void testFilterStartsWithNotOk() throws Exception {
        System.out.println("testFilterStartsWithNotOk");
        String filename = "xcabcde.txt";

        Rule.Filter filter = new Rule.Filter();
        filter.setType(FilterType.STARTS_WITH);
        filter.setValue("ab");

        FilenameFilter instance = new FilenameFilter(filter);

        boolean expResult = false;
        boolean result = instance.filter(filename);

        assertEquals(expResult, result);
    }

    @Test
    public void testFilterEndsWithOk() throws Exception {
        System.out.println("testFilterEndsWithOk");
        String filename = "xcabcde.txt";

        Rule.Filter filter = new Rule.Filter();
        filter.setType(FilterType.ENDS_WITH);
        filter.setValue("txt");

        FilenameFilter instance = new FilenameFilter(filter);

        boolean expResult = true;
        boolean result = instance.filter(filename);

        assertEquals(expResult, result);
    }

    @Test
    public void testFilterEndsWithNotOk() throws Exception {
        System.out.println("testFilterEndsWithNotOk");
        String filename = "xcabcde.txt";

        Rule.Filter filter = new Rule.Filter();
        filter.setType(FilterType.ENDS_WITH);
        filter.setValue("jpg");

        FilenameFilter instance = new FilenameFilter(filter);

        boolean expResult = false;
        boolean result = instance.filter(filename);

        assertEquals(expResult, result);
    }

    @Test(expected = FilterException.class)
    public void testFilterRegexOk() throws Exception {
        System.out.println("testFilterRegexOk");
        String filename = "abc.txt";

        Rule.Filter filter = new Rule.Filter();
        filter.setType(FilterType.REGEX);
        filter.setValue("abc.txt");

        FilenameFilter instance = new FilenameFilter(filter);

        boolean expResult = false;
        boolean result = instance.filter(filename);

        assertEquals(expResult, result);
    }

    /**
     * Test of createFromConfig method, of class FilenameFilter.
     */
    @Test
    public void testCreateFromConfig() {
//        System.out.println("createFromConfig");
//        Config.Rule configRule = new Rule();
//        configRule.setName("rule");
//        
//        Rule.Filter filter = new Rule.Filter();
//        configRule.setFilter(filter);
//        
//        FilenameFilter expResult = null;
//        FilenameFilter result = FilenameFilter.createFromConfig(configRule);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

}
