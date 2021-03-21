package com.softwareTeam.splitsy;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class Sign_InTest {

    @Rule
    public ActivityTestRule<Sign_In> sActivityTestRule=new ActivityTestRule<Sign_In>(Sign_In.class);
    private Sign_In signIn=null;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testLaunch(){
        View view= signIn.findViewById(R.id.emailInput);
        //assertNotNull(view);

    }

    @After
    public void tearDown() throws Exception {
    }
}