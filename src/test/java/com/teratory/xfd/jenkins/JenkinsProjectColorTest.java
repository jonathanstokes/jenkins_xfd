package com.teratory.xfd.jenkins;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author jstokes
 */
public class JenkinsProjectColorTest {

    @Test
    public void testIsBuilding() throws Exception {
        assertFalse(JenkinsProjectColor.BLUE.isBuilding());
        assertFalse(JenkinsProjectColor.DISABLED.isBuilding());
        assertFalse(JenkinsProjectColor.ABORTED.isBuilding());
        assertFalse(JenkinsProjectColor.YELLOW.isBuilding());
        assertFalse(JenkinsProjectColor.RED.isBuilding());
        assertTrue(JenkinsProjectColor.BLUE_ANIME.isBuilding());
        assertTrue(JenkinsProjectColor.ABORTED_ANIME.isBuilding());
        assertTrue(JenkinsProjectColor.DISABLED_ANIME.isBuilding());
        assertTrue(JenkinsProjectColor.YELLOW_ANIME.isBuilding());
        assertTrue(JenkinsProjectColor.RED_ANIME.isBuilding());
    }

    @Test
    public void testIsFailing() throws Exception {
        assertFalse(JenkinsProjectColor.BLUE.isFailing());
        assertFalse(JenkinsProjectColor.BLUE_ANIME.isFailing());
        assertFalse(JenkinsProjectColor.DISABLED.isFailing());
        assertFalse(JenkinsProjectColor.DISABLED_ANIME.isFailing());
        assertTrue(JenkinsProjectColor.ABORTED.isFailing());  // not sure about this.
        assertTrue(JenkinsProjectColor.ABORTED_ANIME.isFailing()); // not sure about this.
        assertTrue(JenkinsProjectColor.YELLOW.isFailing());
        assertTrue(JenkinsProjectColor.YELLOW_ANIME.isFailing());
        assertTrue(JenkinsProjectColor.RED.isFailing());
        assertTrue(JenkinsProjectColor.RED_ANIME.isFailing());
    }

    @Test
    public void testIsDisabled() throws Exception {
        assertFalse(JenkinsProjectColor.BLUE.isDisabled());
        assertFalse(JenkinsProjectColor.BLUE_ANIME.isDisabled());
        assertTrue(JenkinsProjectColor.DISABLED.isDisabled());
        assertTrue(JenkinsProjectColor.DISABLED_ANIME.isDisabled());
        assertFalse(JenkinsProjectColor.ABORTED.isDisabled());
        assertFalse(JenkinsProjectColor.ABORTED_ANIME.isDisabled());
        assertFalse(JenkinsProjectColor.YELLOW.isDisabled());
        assertFalse(JenkinsProjectColor.YELLOW_ANIME.isDisabled());
        assertFalse(JenkinsProjectColor.RED.isDisabled());
        assertFalse(JenkinsProjectColor.RED_ANIME.isDisabled());
    }

    @Test
    public void testValueOf() throws Exception {
        String[] jenkinsStatusValues = new String[] {"blue", "blue_anime", "aborted", "aborted_anime", "disabled", "disabled_anime", "yellow", "yellow_anime", "red", "red_anime"};
        Set<JenkinsProjectColor> foundEnumValues = new HashSet<>();
        for (String jenkinsStatus : jenkinsStatusValues) {
            JenkinsProjectColor enumValue = JenkinsProjectColor.valueOf(jenkinsStatus.toUpperCase());
            if (foundEnumValues.contains(enumValue)) {
                fail("Value " + enumValue + " mapped to Jenkins status '" + jenkinsStatus + "' has already been found.");
            }
            foundEnumValues.add(enumValue);
        }
        for (JenkinsProjectColor color : JenkinsProjectColor.values()) {
            if (!foundEnumValues.contains(color)) {
                fail("Value " + color + " exists in the " + JenkinsProjectColor.class.getSimpleName() + " enumeration but was not tested.");
            }
        }
    }
}