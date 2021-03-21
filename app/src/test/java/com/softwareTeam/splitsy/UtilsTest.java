package com.softwareTeam.splitsy;


import org.junit.Assert;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UtilsTest {

    @Test
    public void testIsEmailValid() {
        String testEmail = "anupamchugh@gmail.com";
        Assert.assertThat(String.format("Email Validity Test failed for %s ", testEmail),
                Utils.checkEmailForValidity(testEmail), is(true));
    }

    @Test
    public void testEmailValidityPartTwo() {
        String testEmail = "    anupamchugh@gmail.com    ";
        Assert.assertThat(String.format("Email Validity Test failed for %s ", testEmail),
                Utils.checkEmailForValidity(testEmail), is(true));
    }
    @Test
    public void validatePassword_Null() {
        // setup
        String password = null;

        // execute
        boolean actual = Utils.validatePassword(password);

        // assert
        assertFalse(actual);
    }

    @Test
    public void validatePassword_EmptyString() {
        // setup
        String password = "";

        // execute
        boolean actual = Utils.validatePassword(password);

        // assert
        assertFalse(actual);
    }

    @Test
    public void validatePassword_Missing_OneNumber() {
        // setup
        String password = "Abcdefg#";

        // execute
        boolean actual = Utils.validatePassword(password);

        // assert
        assertFalse(actual);
    }

    @Test
    public void validatePassword_Missing_OneUpperCaseLetter() {
        // setup
        String password = "abcdefg5#";

        // execute
        boolean actual = Utils.validatePassword(password);

        // assert
        assertFalse(actual);
    }

    @Test
    public void validatePassword_Missing_OneLowerCaseLetter() {
        // setup
        String password = "ABCDEFG5#";

        // execute
        boolean actual = Utils.validatePassword(password);

        // assert
        assertFalse(actual);
    }

    @Test
    public void validatePassword_Missing_OneSymbol() {
        // setup
        String password = "Abcdefg5";

        // execute
        boolean actual = Utils.validatePassword(password);

        // assert
        assertFalse(actual);
    }

    @Test
    public void validatePassword_AllRulesMet() {
        // setup
        String password = "Abcdefg5#";

        // execute
        boolean actual = Utils.validatePassword(password);

        // assert
        assertTrue(actual);
    }

    @Test
    public void validatePassword_LengthTooLong() {
        // setup
        String password = "Abcdefg5#abcdefgabcd";

        // execute
        boolean actual = Utils.validatePassword(password);

        // assert
        assertFalse(actual);
    }
    public static boolean validatePassword(String password) {
        return true;
    }


}
