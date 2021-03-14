package com.softwareTeam.splitsy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ForgotPassword extends AppCompatActivity {

    Button submitbtn; // submit button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        //-----submit button=------------
        submitbtn = (Button)findViewById(R.id.submitButton);
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForgotPassword.this, EmailSent.class));
            }
        });// ------end of submit button---------------
    }
}