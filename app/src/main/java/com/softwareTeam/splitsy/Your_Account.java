package com.softwareTeam.splitsy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Your_Account extends AppCompatActivity {

    Button logoutbtn; // log out button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your__account);

        // ---------Bottom navigation code
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bottom);
        bottomNavigationView.setSelectedItemId(R.id.account);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.pastBills:
                        startActivity(new Intent(Your_Account.this, Past_Bills.class));
                        return true;
                    case R.id.newBill:
                        startActivity(new Intent(Your_Account.this, New_Bill.class));
                        return true;
                    case R.id.account:
                        return true;
                }
                return false;
            }
        });// --------end of Botton navigation

        // ----log out button
        logoutbtn = (Button)findViewById(R.id.logoutButton);
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Your_Account.this, Sign_In.class));

            }
        });
    }
}