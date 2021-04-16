package com.softwareTeam.splitsy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ScanYourReceipt extends AppCompatActivity {

    TextView clicktext; // click link
    ImageView photoimglink; //click link camera
    Button createbtn; //continue button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_your_receipt);

        // ---------Bottom navigation code
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bottom);
        bottomNavigationView.setSelectedItemId(R.id.newBill);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.pastBills:
                        startActivity(new Intent(ScanYourReceipt.this, Past_Bills.class));
                        return true;
                    case R.id.newBill:
                        startActivity(new Intent(ScanYourReceipt.this, New_Bill.class));
                        return true;
                    case R.id.account:
                        startActivity(new Intent(ScanYourReceipt.this, Your_Account.class));
                        return true;
                }
                return false;
            }
        });// --------end of Botton navigation

        // --------------link code--------
        clicktext = (TextView)findViewById(R.id.clickHereText);
        clicktext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScanYourReceipt.this, CameraPermission.class));
            }
        });
        photoimglink = (ImageView)findViewById(R.id.photoImage);
        photoimglink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScanYourReceipt.this, CameraAPI.class));
            }
        });// ----------------end link code------------------

        //-----scan create button-----
        createbtn = (Button)findViewById(R.id.scanCreateButton);
        createbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScanYourReceipt.this, CheckItems.class));
            }
        });
    }
}