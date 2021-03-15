package com.softwareTeam.splitsy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Your_Account extends AppCompatActivity {

    Button logoutbtn; // log out button
    ImageView settingbtn; //settings button
    TextView change_email_link; // change email link
    TextView change_passw_link; // change password link
    TextView add_card_link; // edit card link

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
        }); // ----end log out button----

        // ---settings button----
        settingbtn = (ImageView)findViewById(R.id.settingsImage);
        settingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Your_Account.this, Settings.class));
            }
        });//  end settings button---------

        //----change email link-----
        change_email_link = (TextView)findViewById(R.id.changeEmailText);
        change_email_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Your_Account.this, ChangeEmail.class));

            }
        });//  ---- end change email link----

        //-----change password link-----
        change_passw_link = (TextView)findViewById(R.id.changePasswordText);
        change_passw_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Your_Account.this, ChangePassword.class));


            }
        });// end change password link-------

        //----add card link----
        add_card_link = (TextView)findViewById(R.id.addCardText);
        add_card_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Your_Account.this, AddNewCard.class));


            }
        });//-----end add card link


    }
}