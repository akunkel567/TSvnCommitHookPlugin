/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.complex.svntools.hook.filter;

import de.complex.svntools.config.Config;
import de.complex.svntools.hook.filter.exception.FilterException;
import de.complex.svntools.tools.StringTools;

/**
 * @author Andreas Kunkel
 */
public class FilenameFilter implements Filter {

    Config.Rule.Filter filter;

    public FilenameFilter(Config.Rule.Filter filter) {
        this.filter = filter;
    }

    @Override
    public boolean filter(String filename) throws FilterException {

        if (filename == null) {
            return false;
        }

        switch (filter.getType()) {
            case CONTAINS:
                return filename.toUpperCase().contains(filter.getValue().toUpperCase());

            case STARTS_WITH:
                return filename.toUpperCase().startsWith(filter.getValue().toUpperCase());

            case ENDS_WITH:
                return filename.toUpperCase().endsWith(filter.getValue().toUpperCase());

            case EQUALS:
                return filename.equalsIgnoreCase(filter.getValue());

            case REGEX:
                throw new FilterException("Regex-Filter is not implemented yet.");

            default:
                throw new FilterException("Filtertype unknown.");
        }
    }

    public static FilenameFilter createFromConfig(de.complex.svntools.config.Config.Rule configRule) {

        FilenameFilter filter = new FilenameFilter(configRule.getFilter());

        return filter;
    }
}
