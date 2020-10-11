/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.complex.svntools.hook.executor;

import de.complex.svntools.config.Config;
import de.complex.svntools.config.Config.Rule;
import de.complex.svntools.hook.content.FileContent;
import de.complex.svntools.hook.content.exception.ContentException;
import de.complex.svntools.hook.exception.SvnHookException;
import de.complex.svntools.hook.filter.FilenameFilter;
import de.complex.svntools.hook.filter.exception.FilterException;
import de.complex.svntools.hook.tortoise.precommit.PreCommit;
import de.complex.svntools.hook.validator.ContentValidator;
import de.complex.svntools.hook.validator.exception.ValidateException;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * @author Andreas Kunkel
 */
public class PreCommitExecutor implements Executor {

    public static final Logger LOG = Logger.getLogger(PreCommitExecutor.class);

    String[] args;
    Config config;

    public PreCommitExecutor(String[] args, Config config) {
        this.args = args;
        this.config = config;
    }

    @Override
    public void execute() throws SvnHookException {

        LOG.debug(args);

        PreCommit preCommit = new PreCommit(args);
        List<String> filenames = preCommit.getFilenames();
        LOG.debug(filenames);

        for (Rule rule : config.getRule()) {

            FilenameFilter filter = FilenameFilter.createFromConfig(rule);
            ContentValidator validator = ContentValidator.createFromConfig(rule);

            for (String filename : filenames) {
                LOG.debug("filename: " + filename);

                try {
                    if (filter.filter(filename)) {
                        LOG.debug("filtered: " + filename);

                        // Datei bei Delete Commits nicht vorhanden
                        if (!(new File(filename)).exists()) {
                            LOG.debug(String.format("File '%s' not exists. Probably a delete commit.", filename));
                            continue;
                        }

                        FileContent fileContent = new FileContent(filename);

                        try {
                            LOG.debug("fileContent: " + fileContent.getValue());
                        } catch (ContentException ex) {
                            throw new SvnHookException(ex);
                        }

                        try {
                            LOG.debug("before validate");
                            validator.validate(fileContent);
                            LOG.debug("after validate");
                        } catch (ValidateException ex) {
                            throw new SvnHookException(String.format("%s - %s", fileContent.getFilename(), ex.getMessage()), ex);
                        }
                    }
                } catch (FilterException ex) {
                    throw new SvnHookException(ex);
                }
            }
        }
    }
}
