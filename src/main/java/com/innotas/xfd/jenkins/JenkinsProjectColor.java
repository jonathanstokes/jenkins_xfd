package com.innotas.xfd.jenkins;

/**
 * The color of a Jenkins project, as described by Jenkins.
 *
 * Jenkins uses blue/yellow/red, plus disabled and aborted.
 *
 * @author jstokes
 */
public enum JenkinsProjectColor {

    BLUE,
    BLUE_ANIME,
    DISABLED,
    ABORTED,
    ABORTED_ANIME,
    YELLOW,
    YELLOW_ANIME,
    RED,
    RED_ANIME,
    ;

    /** Determines if the current color indicates a building job. */
    public boolean isBuilding() {
        return toString().contains("_ANIME");
    }

    /** Determines if the current color indicates a failing job. */
    public boolean isFailing() {
        return this != DISABLED && this != BLUE && this != BLUE_ANIME;
    }
}
