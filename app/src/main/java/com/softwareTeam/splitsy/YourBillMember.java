package com.softwareTeam.splitsy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class YourBillMember extends AppCompatActivity {

    Button paynowbtn; // pay now button
    Button paylaterbtn; // pay later button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_bill_member);

        // ---------Bottom navigation code
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bottom);
        bottomNavigationView.setSelectedItemId(R.id.newBill);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.pastBills:
                        startActivity(new Intent(YourBillMember.this, Past_Bills.class));
                        return true;
                    case R.id.newBill:
                        startActivity(new Intent(YourBillMember.this, New_Bill.class));
                        return true;
                    case R.id.account:
                        startActivity(new Intent(YourBillMember.this, Your_Account.class));
                        return true;
                }
                return false;
            }
        });// --------end of Botton navigation

        // ---- pay now button-----
        paynowbtn = (Button)findViewById(R.id.payNowButton);
        paynowbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(YourBillMember.this, Pay.class));
            }
        });

        // ---- pay later button----
        paylaterbtn = (Button)findViewById(R.id.payLaterButton);
        paylaterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(YourBillMember.this, PaymentPending.class));
            }
        });
    }
}