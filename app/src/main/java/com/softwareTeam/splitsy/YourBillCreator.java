package com.softwareTeam.splitsy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class YourBillCreator extends AppCompatActivity {

    Button homebtn; // home button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_bill_creator);

        // home button code
        homebtn = (Button)findViewById(R.id.homeButton);
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(YourBillCreator.this, New_Bill.class));
            }
        });// end home button code

    }
}