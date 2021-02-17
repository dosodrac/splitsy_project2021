package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button pro;

    //bill
    Button bill;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        pro=findViewById(R.id.pro);

        //bill
        bill=findViewById(R.id.bill);


        pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, Account.class);
                startActivity(intent);
            }
        });

        //bill

        bill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, PastBill.class);
                startActivity(intent);
            }
        });

    }
}