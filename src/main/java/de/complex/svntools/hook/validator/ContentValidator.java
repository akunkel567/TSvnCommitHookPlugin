/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.complex.svntools.hook.validator;

import de.complex.svntools.hook.content.Content;
import de.complex.svntools.hook.validator.exception.ValidateException;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * @author Andreas Kunkel
 */
public class ContentValidator implements Validator {

    public static final Logger LOG = Logger.getLogger(ContentValidator.class);

    String validatorName;
    List<MustHave> mustHaves;
    List<NotAllowed> notAlloweds;

    public ContentValidator() {
        this.mustHaves = new ArrayList<>();
        this.notAlloweds = new ArrayList<>();
    }

    public ContentValidator(String validatorName) {
        this();
        this.validatorName = validatorName;
    }

    public List<MustHave> getMustHaves() {
        return mustHaves;
    }

    public List<NotAllowed> getNotAlloweds() {
        return notAlloweds;
    }

    @Override
    public void validate(Content content) throws ValidateException {

        LOG.debug(this.mustHaves);
        for (MustHave mustHave : this.mustHaves) {
            LOG.debug(mustHave);
            mustHave.validate(content);
        }

        LOG.debug(this.notAlloweds);
        for (NotAllowed notAllowed : this.notAlloweds) {
            LOG.debug(notAllowed);
            notAllowed.validate(content);
        }
    }

    public static ContentValidator createFromConfig(de.complex.svntools.config.Config.Rule configRule) {

        ContentValidator validator = new ContentValidator(configRule.getName());

        configRule.getMustHave().forEach((configMustHave) -> {
            validator.getMustHaves().add(new MustHave(configMustHave.getValue(), configMustHave.isRegex()));
        });

        configRule.getNotAllowed().forEach((configNotAllowed) -> {
            validator.getNotAlloweds().add(new NotAllowed(configNotAllowed.getValue(), configNotAllowed.isRegex()));
        });

        return validator;
    }
}
