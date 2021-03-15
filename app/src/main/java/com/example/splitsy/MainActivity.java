package com.example.splitsy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.*;

public class MainActivity extends AppCompatActivity {
    private EditText emailInput;
    private EditText passwordInput;
    private TextView info;
    //private int counter = 10; TODO

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        emailInput = (EditText)findViewById(R.id.emailInput);
        passwordInput = (EditText)findViewById(R.id.passwordInput);
        Button signInButton = (Button) findViewById(R.id.signInButton);
        info = (TextView)findViewById(R.id.loginInfo);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Task().execute();
            }
        });
    }

    class Task extends AsyncTask<Void, Void, Void>{
        /* String records = "", error=""; */

        @SuppressLint("SetTextI18n")
        @Override
        protected Void doInBackground(Void... voids){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://igor.gold.ac.uk:3307/dcard001_splitsy", "dcard001", "134114");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM user WHERE email='" + emailInput + "' AND password='" + passwordInput + "'");

                String password = passwordInput.getText().toString();
                while(resultSet.next()) {
                    if(resultSet.getString(3).equals(password)){
                        Intent i = new Intent(MainActivity.this,Account.class);
                        MainActivity.this.startActivity(i);
                    }
                }
            }catch(Exception e){
               info.setText("There was an error, please try again.");
            }
            return null;
        }
    }
}