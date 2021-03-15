package com.softwareTeam.splitsy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PaymentPending extends AppCompatActivity {

    Button homebtn; // home button
    Button billdetailbtn; // bill details button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_pending);

        // home button code
        homebtn = (Button)findViewById(R.id.homeButton);
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PaymentPending.this, New_Bill.class));
            }
        });// end home button code

        billdetailbtn = (Button)findViewById(R.id.viewBillDetailsButton);
        billdetailbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PaymentPending.this, BillDetail.class));
            }
        });
    }
}