package com.softwareTeam.splitsy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BiometricSignIn extends AppCompatActivity {

    TextView changelink; // change account link

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biometric_sign_in);

        changelink = (TextView)findViewById(R.id.changeAccountText);
        changelink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BiometricSignIn.this, Sign_In.class));
            }
        });
    }
}