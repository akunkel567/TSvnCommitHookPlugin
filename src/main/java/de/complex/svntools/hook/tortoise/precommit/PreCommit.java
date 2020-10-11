/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.complex.svntools.hook.tortoise.precommit;

import de.complex.svntools.hook.exception.SvnHookException;
import de.complex.svntools.hook.exception.SvnHookExecuteException;
import de.complex.svntools.hook.tortoise.TortoiseHook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

/**
 * @author Andreas Kunkel
 */
public class PreCommit implements TortoiseHook {

    private static final int PRE_COMMIT_INDEX_NUMBER = 4;
    private static final int PRE_COMMIT_PATH_INDEX = 0;
    private static final int PRE_COMMIT_DEPTH_INDEX = 1;
    private static final int PRE_COMMIT_MESSAGEFILE_INDEX = 2;
    private static final int PRE_COMMIT_PATH_CWD = 3;

    public static final Logger LOG = Logger.getLogger(PreCommit.class);

    String[] args;

    public PreCommit(String[] args) throws SvnHookException {

        if (args.length != PRE_COMMIT_INDEX_NUMBER) {
            throw new SvnHookException("The number of parameters for PreCommit must be 4.");
        }

        this.args = args;
    }

    @Override
    public List<String> getFilenames() throws SvnHookException {

        ArrayList<String> filenames = new ArrayList<>();

        File fileWithCommitedFiles = new File(args[PRE_COMMIT_PATH_INDEX]);
        LOG.debug("fileWithCommitedFiles: " + fileWithCommitedFiles.getAbsolutePath());
        String filePaths = null;
        try {
            filePaths = FileUtils.readFileToString(fileWithCommitedFiles);
        } catch (IOException ex) {
            throw new SvnHookExecuteException(String.format("Read Excption from File with Commit-Info '%s'", fileWithCommitedFiles.getAbsolutePath()), ex);
        }

        String commitedFilePaths[] = filePaths.split("\n");
        for (String commitedFilePath : commitedFilePaths) {
            commitedFilePath = commitedFilePath.trim();

            filenames.add(commitedFilePath);
        }

        return filenames;
    }

//    private boolean isFiltered(String commitedFilePath) {
//        LOG.debug("checkFilter: " + commitedFilePath);
//
//        boolean isFiltered = commitedFilePath.endsWith(".sql");
//        LOG.debug("isFiltered: " + isFiltered);
//
//        return isFiltered;
//    }
//
//    private void checkRules(String commitedFilePath) throws SvnHookExecuteException, SvnHookRuleException {
//        LOG.debug("checkRules for commitedFilePath");
//
//        File commitedFile = new File(commitedFilePath.trim());
//        LOG.debug("commitedFile: " + commitedFile.getAbsolutePath());
//
//        if (!commitedFile.exists()) {
//            LOG.error(String.format("Commited File '%s' not exists.", commitedFile.getAbsoluteFile()));
//        }
//
//        String stringToCheck = null;
//        try {
//            stringToCheck = FileUtils.readFileToString(commitedFile);
//        } catch (IOException ex) {
//            throw new SvnHookExecuteException(String.format("Read Excption from commited file '%s'", commitedFile.getAbsolutePath()), ex);
//        }
//
//        if (StringUtils.containsIgnoreCase(stringToCheck, "DEFINER")) {
//            throw new SvnHookRuleException("File " + commitedFile.getName() + " contains DEFINER.");
//        }
//    }
}
