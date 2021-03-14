package com.softwareTeam.splitsy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Sign_In extends AppCompatActivity {

    Button btnsingIn; // sign in button
    TextView signup;// sign up linl
    ImageView signupimg; // sign up link

    TextView forgotlink; // forgot password link
    ImageView forgotlinkimg; // forgot password link

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        // singIn button code--------------
        btnsingIn = (Button)findViewById(R.id.signInButton);
        btnsingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sign_In.this, Enable_Fingerprint.class));
            }
        });// end sign in button------------------------

        //-------------------------sign up link
        signup = (TextView)findViewById(R.id.signUpText);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sign_In.this, SignUp.class));
            }
        });
        signupimg = (ImageView) findViewById(R.id.signInImage);
        signupimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sign_In.this, SignUp.class));
            }
        });// -------------------end of sign up link



        ////--------------forgot links
        forgotlink = (TextView)findViewById(R.id.forgotText);
        forgotlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sign_In.this, ForgotPassword.class));
            }
        });
        forgotlinkimg = (ImageView)findViewById(R.id.forgotPasswordImage);
        forgotlinkimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sign_In.this, ForgotPassword.class));
            }
        });// --------------end of forgot links-----------------

    }
}