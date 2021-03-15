package com.softwareTeam.splitsy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Pay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        // ---------Bottom navigation code
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bottom);
        bottomNavigationView.setSelectedItemId(R.id.pastBills);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.pastBills:
                        startActivity(new Intent(Pay.this,Past_Bills.class));
                        return true;
                    case R.id.newBill:
                        startActivity(new Intent(Pay.this,New_Bill.class));
                        return true;
                    case R.id.account:
                        startActivity(new Intent(Pay.this, Your_Account.class));
                        return true;
                }
                return false;
            }
        });// --------end of Botton navigation
    }
}