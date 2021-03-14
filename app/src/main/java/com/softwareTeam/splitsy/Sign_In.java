package com.softwareTeam.splitsy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sign_In extends AppCompatActivity {

    Button btnsingIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        btnsingIn = (Button)findViewById(R.id.signInButton);
        btnsingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sign_In.this, Enable_Fingerprint.class));
            }
        });
    }
}