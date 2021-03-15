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
    Button byitembtn; // by item button
    Button equallybtn; // equally button
    boolean byItemSelected = false;
    boolean equallySelected = false;

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

        // ---- BY ITEM button ----
        byitembtn = (Button) findViewById(R.id.byItemButton);
        byitembtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byItemSelected = true;
                equallySelected = false;

                byitembtn.setBackgroundResource(R.drawable.format_button_selected);
                int imgResource = R.drawable.ic_fork_white;
                ((Button)byitembtn).setCompoundDrawablesWithIntrinsicBounds(imgResource, 0, 0, 0);
                ((Button)byitembtn).setTextColor(getColor(R.color.white));

                equallybtn.setBackgroundResource(R.drawable.format_button_outline);
                int imgResource2 = R.drawable.ic_pie_chart_green;
                ((Button)equallybtn).setCompoundDrawablesWithIntrinsicBounds(imgResource2, 0, 0, 0);
                ((Button)equallybtn).setTextColor(getColor(R.color.logoGreen));
            }
        }); //end of BY ITEM button

        // ---- EQUALLY button ----
        equallybtn = (Button) findViewById(R.id.equallyButton);
        equallybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equallySelected = true;
                byItemSelected = false;

                equallybtn.setBackgroundResource(R.drawable.format_button_selected);
                int imgResource = R.drawable.ic_pie_chart_white;
                ((Button)equallybtn).setCompoundDrawablesWithIntrinsicBounds(imgResource, 0, 0, 0);
                ((Button)equallybtn).setTextColor(getColor(R.color.white));

                byitembtn.setBackgroundResource(R.drawable.format_button_outline);
                int imgResource2 = R.drawable.ic_fork_green;
                ((Button)byitembtn).setCompoundDrawablesWithIntrinsicBounds(imgResource2, 0, 0, 0);
                ((Button)byitembtn).setTextColor(getColor(R.color.logoGreen));
            }
        });

        // ----- create new bill button-----
        createbtn = (Button) findViewById(R.id.scanCreateButton);
        createbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              
                if (equallySelected) {
                    startActivity(new Intent(CreateNewBill.this, EnterBillDetails.class));
                }

                else if (byItemSelected) {
                    startActivity(new Intent(CreateNewBill.this, ScanYourReceipt.class));
                }

            }
        });// end of create new bill button-----
    }
}