package com.softwareTeam.splitsy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BankCardAdded extends AppCompatActivity {

    Button continuebtn; // continue button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_card_added);

        //----continue button-----
        continuebtn = (Button)findViewById(R.id.continueButton);
        continuebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BankCardAdded.this, Your_Account.class));
            }
        }); // end of continuew button
    }
}