package com.softwareTeam.splitsy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ShareCode extends AppCompatActivity {

    Button sharebtn; // share button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_code);

        // ---------Bottom navigation code
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bottom);
        bottomNavigationView.setSelectedItemId(R.id.newBill);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.pastBills:
                        startActivity(new Intent(ShareCode.this, Past_Bills.class));
                        return true;
                    case R.id.newBill:
                        startActivity(new Intent(ShareCode.this, New_Bill.class));
                        return true;
                    case R.id.account:
                        startActivity(new Intent(ShareCode.this, Your_Account.class));
                        return true;
                }
                return false;
            }
        });// --------end of Botton navigation

        // ------share button code
        sharebtn = (Button)findViewById(R.id.shareButton);
        sharebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShareCode.this, YourBillCreator.class));
            }
        });
    }
}