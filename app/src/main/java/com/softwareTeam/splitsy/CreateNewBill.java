package com.softwareTeam.splitsy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CreateNewBill extends AppCompatActivity {

    Button createbtn; // create new bill button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_bill);

        // ---------Bottom navigation code
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bottom);
        bottomNavigationView.setSelectedItemId(R.id.newBill);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.pastBills:
                        startActivity(new Intent(CreateNewBill.this, Past_Bills.class));
                        return true;
                    case R.id.newBill:
                        startActivity(new Intent(CreateNewBill.this, New_Bill.class));
                        return true;
                    case R.id.account:
                        startActivity(new Intent(CreateNewBill.this, Your_Account.class));
                        return true;
                }
                return false;
            }
        });// --------end of Botton navigation

        // ----- create new bill button-----
        createbtn = (Button) findViewById(R.id.scanCreateButton);
        createbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreateNewBill.this, EnterBillDetails.class));
            }
        });// end of create new bill button-----
    }
}