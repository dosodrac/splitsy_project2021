package com.softwareTeam.splitsy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SignUp extends AppCompatActivity {

    Button continuebtn; // continue button
    TextView signin; //sign in link

    //register
    EditText editEmail,editPassword;
    TextView info;
    //btn
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editEmail = findViewById(R.id.emailInput);
        editPassword = findViewById(R.id.passwordInput);
        info = findViewById(R.id.message);

        //----------continue button-------------
        continuebtn = (Button) findViewById(R.id.accountContinueButton);
        continuebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Async().execute();
                // startActivity(new Intent(SignUp.this, MainActivity.class));
            }
        });// ------------end continue button------------


        //---------sign in link----------------
        signin = (TextView) findViewById(R.id.signInLink);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this, Sign_In.class));
            }
        });
    }


    class Async extends AsyncTask<Void, Void, Void> {
        String txtEmail = editEmail.getText().toString();
        String txtPassword = editPassword.getText().toString();
        String msg = "";

        @Override
        protected Void doInBackground(Void... voids) {
            if (txtEmail.trim().equals("") || txtPassword.trim().equals(""))
                msg = "Please enter all fields";
            else {
                try {
                    //jdbc class
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://igor.gold.ac.uk:3307/dcard001_splitsy", "dcard001", "134114");
                    String sql = "INSERT INTO user(email,password) VALUES(?,?)";

                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, editEmail.getText().toString());
                    statement.setString(2, editPassword.getText().toString());

                    int rows = statement.executeUpdate();
                    if (rows > 0) {
                        startActivity(new Intent(SignUp.this, AccountDetails.class));
                        msg = " Success";
                    }
                    connection.close();

                } catch (Exception e) {
                    info.setText("Please try again!");
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            info.setText(msg);
        }
    }
}