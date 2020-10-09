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
    }

    private void execute(String[] args) throws Exception {
        LOG.debug("Main execute");
    }
}
