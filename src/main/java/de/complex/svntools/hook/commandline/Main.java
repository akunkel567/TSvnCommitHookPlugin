/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.complex.svntools.hook.commandline;

import de.complex.svntools.config.Config;
import org.apache.log4j.*;
import org.apache.log4j.xml.DOMConfigurator;

import javax.xml.parsers.FactoryConfigurationError;
import java.io.File;
import java.io.IOException;

/**
 * @author Andreas Kunkel
 */
public class Main {

    public static final Logger LOG = Logger.getLogger(Main.class);

    private File configFile = null;
    private Config config = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        initLogging();

        Main main = null;
        try {
            main = new Main();
        } catch (Exception ex) {
            LOG.error("Init", ex);
            System.err.append(ex.getMessage());
            System.exit(2);
        }

        try {
            main.execute(args);
        } catch (Exception ex) {
            LOG.error("Execute", ex);
            System.err.append(ex.getMessage());
            System.exit(3);
        }
    }

    public Main() throws Exception {
        checkConfigParameters();
    }

    private static void initLogging() throws FactoryConfigurationError {
        try {
            String log4jconfig = System.getProperty("log4j");
            if (log4jconfig == null) {
                throw new MainConfigException("The log4-config-value is not defined.");
            }

            File log4j = new File(log4jconfig);
            if (!log4j.exists()) {
                throw new MainConfigException("The log4-config-file does not exist.");
            }

            DOMConfigurator.configure(log4j.getAbsolutePath());
        } catch (MainConfigException ex) {
            try {
                SimpleLayout layout = new SimpleLayout();
                FileAppender fileAppender = new FileAppender(layout, "./commitHook.log");
                BasicConfigurator.configure(fileAppender);
                Logger.getRootLogger().setLevel(Level.ALL);

                LOG.warn(ex.getMessage());
            } catch (Exception e) {
                System.err.append(e.getMessage());
                System.exit(1);
            }
        }
    }

    private void execute(String[] args) throws Exception {
        LOG.debug("Main execute");
    }

    private void checkConfigParameters() throws Exception {
        String configFileName = System.getProperty("config");

        if (configFileName == null) {
            String msg = "config is a required value.";
            LOG.fatal(msg);
            throw new Exception(msg);
        }

        configFile = new File(configFileName);
        if (!configFile.exists()) {
            String msg = String.format("ConfigFile '%s' not exists.", configFileName);
            LOG.fatal(msg);
            throw new Exception(msg);
        }

        this.config = ConfigTool.loadConfig(configFile);

        String hook_type = System.getProperty("hook_type");
        if (hook_type == null) {
            String msg = "hook_type is a required value.";
            LOG.fatal(msg);
            throw new Exception(msg);
        }

        hookType = HookType.findByValue(hook_type);
        if (hookType == null) {
            String msg = String.format("hook_type '%s' is not a valid value.", hook_type);
            LOG.fatal(msg);
            throw new Exception(msg);
        }

        LOG.debug("hookType: " + hookType);
    }
}
