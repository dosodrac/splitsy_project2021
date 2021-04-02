package com.softwareTeam.splitsy;

import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)

public class LoginUnitTest {
    private static final String FAKE_STRING = "Login was successful";

    @Mock
    Context mMockContext;

    @Test
    public void readStringFromContext_LocalizedString() {

        Sign_In myObjectUnderTest = new Sign_In(mMockContext);

// ...when the string is returned from the object under test...
        String result = myObjectUnderTest.validate("user","user");

        // ...then the result should be the expected one.
        assertThat(result, is(FAKE_STRING));
    }


}