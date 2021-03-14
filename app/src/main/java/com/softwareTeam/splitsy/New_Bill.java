package com.softwareTeam.splitsy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class New_Bill extends AppCompatActivity {

    Button createnewbillbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__bill);

        // ---------Bottom navigation code
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bottom);
        bottomNavigationView.setSelectedItemId(R.id.newBill);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.pastBills:
                        startActivity(new Intent(New_Bill.this, Past_Bills.class));
                        return true;
                    case R.id.newBill:
                        return true;
                    case R.id.account:
                        startActivity(new Intent(New_Bill.this, Your_Account.class));
                        return true;
                }
                return false;
            }
        });// --------end of Botton navigation

        createnewbillbtn = (Button)findViewById(R.id.createNewBillButton);
        createnewbillbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(New_Bill.this, CreateNewBill.class));
            }
        });
    }
}