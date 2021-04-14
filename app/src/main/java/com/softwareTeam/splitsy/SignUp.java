package com.softwareTeam.splitsy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SignUp extends AppCompatActivity {

    Button continuebtn; // continue botton
    TextView signin; //sign in link

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //----------continue button-------------
        continuebtn = (Button)findViewById(R.id.accountContinueButton);
        continuebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this, AccountDetails.class));
            }
        });// ------------end continue button------------

        //---------sign in link----------------
        signin = (TextView)findViewById(R.id.signInLink);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this, Sign_In.class));
            }
        });
    }
}