/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.complex.svntools.tools;

import de.complex.svntools.config.Config;
import de.complex.svntools.config.Config.Rule;
import de.complex.svntools.config.Config.Rule.Filter;
import de.complex.svntools.config.ObjectFactory;
import de.complex.svntools.config.exception.ConfigException;

import java.io.File;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Andreas Kunkel
 */
public class ConfigToolTest {

    public ConfigToolTest() {
    }

    /**
     * Test of loadConfig method, of class ConfigTool.
     *
     * @throws de.complex.svntools.config.exception.ConfigException
     */
    @Test
    public void testLoadConfig() throws ConfigException {
        System.out.println("testLoadConfig");

        File configXml = new File("src/test/resources/schema/config.xml");

        ObjectFactory of = new ObjectFactory();

        Config expResult = of.createConfig();

        Rule rule = of.createConfigRule();
        rule.setName("rule1");

        Filter filter = of.createConfigRuleFilter();
        filter.setValue("f1");
        rule.setFilter(filter);
        expResult.getRule().add(rule);

        Config result = ConfigTool.loadConfig(configXml);

        assertEquals(expResult.getRule().get(0).getFilter().getValue(), result.getRule().get(0).getFilter().getValue());
        assertEquals(3, result.getRule().get(0).getMustHave().size());
        assertEquals(3, result.getRule().get(0).getNotAllowed().size());
    }

    @Test(expected = ConfigException.class)
    public void testLoadConfigWithFailure() throws ConfigException {
        System.out.println("testLoadConfigWithFailure");

        File configXml = new File("src/test/resources/schema/config_not_ok.xml");

        ObjectFactory of = new ObjectFactory();

        Config expResult = of.createConfig();

        Rule rule = of.createConfigRule();
        rule.setName("rule1");

        Filter filter = of.createConfigRuleFilter();
        filter.setValue("f1");
        rule.setFilter(filter);
        expResult.getRule().add(rule);

        Config result = ConfigTool.loadConfig(configXml);

        assertEquals(expResult.getRule().get(0).getFilter().getValue(), result.getRule().get(0).getFilter().getValue());
        assertEquals(3, result.getRule().get(0).getMustHave().size());
        assertEquals(3, result.getRule().get(0).getNotAllowed().size());
    }
}
