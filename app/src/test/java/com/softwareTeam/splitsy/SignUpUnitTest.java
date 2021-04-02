package com.softwareTeam.splitsy;

import android.content.Context;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)

public class SignUpUnitTest {
    private static final String FAKE_STRING = "SignUp was successful";
    @Mock
    Context mMockContext;

    @Test
    public void readStringFromContext_LocalizedString() {
        SignUp myObjectUnderTest = new SignUp(mMockContext);

// ...when the string is returned from the object under test...
        String result = myObjectUnderTest.validate("user","user");

        // ...then the result should be the expected one.
        assertThat(result, is(FAKE_STRING));
    }


    @Test
    public void testIsEmailValid() {
        String testEmail ="anupamchugh@gmailcom";
        Assert.assertThat(String.format("Email Validity Test failed for %s ", testEmail),
                SignUp.checkEmailForValidity(testEmail), is(false));
    }


}