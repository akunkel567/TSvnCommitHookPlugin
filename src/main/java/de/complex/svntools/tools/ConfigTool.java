/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.complex.svntools.tools;

import de.complex.svntools.config.Config;
import de.complex.svntools.config.ConfigValidationEventHandler;
import de.complex.svntools.config.exception.ConfigException;

import java.io.File;
import java.net.URL;
import java.util.logging.Level;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.helpers.DefaultValidationEventHandler;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

/**
 * @author Andreas Kunkel
 */
public class ConfigTool {

    public static final Logger LOG = Logger.getLogger(ConfigTool.class);

    public static Config loadConfig(File configXml) throws ConfigException {

        try {
            JAXBContext jc = JAXBContext.newInstance(Config.class);
            Unmarshaller m = jc.createUnmarshaller();
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = null;

            String resPath = "/schema/config.xsd";

            URL schema_url = ConfigTool.class.getResource(resPath);
            schema = sf.newSchema(schema_url);
            m.setSchema(schema);

            ConfigValidationEventHandler handler = new ConfigValidationEventHandler();
            m.setEventHandler(handler);

            Config config = (Config) m.unmarshal(configXml);

            if (handler.hasEvents()) {
                throw new ConfigException(handler.getMessages());
            }

            return config;

        } catch (SAXException | JAXBException ex) {
            throw new ConfigException(ex);
        }
    }

}
