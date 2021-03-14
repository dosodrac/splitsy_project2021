package com.softwareTeam.splitsy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Past_Bills extends AppCompatActivity {

    Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past__bills);

        //filter menu
        myDialog = new Dialog(this);


        // ---------Bottom navigation code
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bottom);
        bottomNavigationView.setSelectedItemId(R.id.pastBills);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.pastBills:
                        return true;
                    case R.id.newBill:
                        startActivity(new Intent(Past_Bills.this,New_Bill.class));
                        return true;
                    case R.id.account:
                        startActivity(new Intent(Past_Bills.this, Your_Account.class));
                        return true;
                }
                return false;
            }
        });// --------end of Botton navigation
     }


    // code for the filter menu
    public void ShowPopUp(View view) {
        Button btnClose;
        RadioButton radioBtnPaid;
        RadioButton radioBtnPending;
        RadioButton radioBtnTags;
        RadioButton radioBtnAmount;
        RadioButton radioBtnDate;
        RadioButton radioBtnAscending;
        RadioButton radioBtnDescending;
        myDialog.setContentView(R.layout.activity_filter_menu);
        btnClose = (Button) myDialog.findViewById(R.id.filterbutton);
        radioBtnPaid = (RadioButton) myDialog.findViewById(R.id.paidradiobutton);
        radioBtnPending = (RadioButton) myDialog.findViewById(R.id.pendingradiobutton);
        radioBtnTags = (RadioButton) myDialog.findViewById(R.id.tagsradiobutton);
        radioBtnAmount = (RadioButton) myDialog.findViewById(R.id.amountradiobutton);
        radioBtnDate = (RadioButton) myDialog.findViewById(R.id.dateradiobutton);
        radioBtnAscending = (RadioButton) myDialog.findViewById(R.id.ascendingrariobutton);
        radioBtnDescending = (RadioButton) myDialog.findViewById(R.id.descendingradiobutton);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               myDialog.dismiss();
            }
        });
        myDialog.show();
    }// end of the filter menu code

}