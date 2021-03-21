package com.softwareTeam.splitsy;


import org.junit.Assert;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

public class UtilsTest {

    @Test
    public void testIsEmailValid() {
        String testEmail = "anupamchugh@gmail.com";
        Assert.assertThat(String.format("Email Validity Test failed for %s ", testEmail), Utils.checkEmailForValidity(testEmail), is(true));
    }

    @Test
    public void testEmailValidityPartTwo() {
        String testEmail = "   anupamchugh@gmail.com  ";
        Assert.assertThat(String.format("Email Validity Test failed for %s ", testEmail), Utils.checkEmailForValidity(testEmail), is(true));
    }

}
