/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.complex.svntools.hook.tortoise;

/**
 * @author Andreas Kunkel
 */
public enum HookType {
    PreCommitHook("pre_commit_hook"),
    CheckCommitHook("check_commit_hook");

    private final String value;

    private HookType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static HookType findByValue(String name) {
        if (name != null) {
            for (HookType hookType : HookType.values()) {
                if (hookType.getValue().equalsIgnoreCase(name)) {
                    return hookType;
                }
            }
        }
        return null;
    }
}
