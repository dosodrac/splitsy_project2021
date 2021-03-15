package com.softwareTeam.splitsy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class EnterBillDetails extends AppCompatActivity {

    Button createbtn; // enter bill details button create

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_bill_details);

        // ---------Bottom navigation code
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bottom);
        bottomNavigationView.setSelectedItemId(R.id.newBill);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.pastBills:
                        startActivity(new Intent(EnterBillDetails.this, Past_Bills.class));
                        return true;
                    case R.id.newBill:
                        startActivity(new Intent(EnterBillDetails.this, New_Bill.class));
                        return true;
                    case R.id.account:
                        startActivity(new Intent(EnterBillDetails.this, Your_Account.class));
                        return true;
                }
                return false;
            }
        });// --------end of Botton navigation

        //----create button------
        createbtn = (Button) findViewById(R.id.createButton);
        createbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EnterBillDetails.this,ShareCode.class));
            }
        });
        // ---end of create button-----
    }
}