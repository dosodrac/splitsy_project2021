package com.softwareTeam.splitsy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class EnterCode extends AppCompatActivity {

    Button continuebtn; //continuebtn
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_code);

        // ---------Bottom navigation code
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bottom);
        bottomNavigationView.setSelectedItemId(R.id.newBill);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.pastBills:
                        startActivity(new Intent(EnterCode.this, Past_Bills.class));
                        return true;
                    case R.id.newBill:
                        startActivity(new Intent(EnterCode.this, New_Bill.class));
                        return true;
                    case R.id.account:
                        startActivity(new Intent(EnterCode.this, Your_Account.class));
                        return true;
                }
                return false;
            }
        });// --------end of Botton navigation

        // button code
        continuebtn = (Button)findViewById(R.id.continuebtn);
        continuebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EnterCode.this, CheckItems.class));
            }
        });
    }
}