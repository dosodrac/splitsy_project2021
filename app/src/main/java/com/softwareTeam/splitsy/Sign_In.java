package com.softwareTeam.splitsy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Sign_In extends AppCompatActivity {

    //Input buttons
    private EditText emailInput;
    private EditText passwordInput;
    private TextView info;

    Button btnsingIn; // sign in button
    TextView signup;// sign up link
    ImageView signupimg; // sign up link

    TextView forgotlink; // forgot password link
    ImageView forgotlinkimg; // forgot password link

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        // singIn button code--------------
        emailInput = (EditText)findViewById(R.id.emailInput);
        passwordInput = (EditText)findViewById(R.id.passwordInput);
        info = (TextView)findViewById(R.id.loginInfo);

        btnsingIn = (Button)findViewById(R.id.signInButton);
        btnsingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Async().execute();
            }
        });// end sign in button------------------------

        //-------------------------sign up link
        signup = (TextView)findViewById(R.id.signUpText);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sign_In.this, SignUp.class));
            }
        });
        signupimg = (ImageView) findViewById(R.id.signInImage);
        signupimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sign_In.this, SignUp.class));
            }
        });// -------------------end of sign up link



        ////--------------forgot links
        forgotlink = (TextView)findViewById(R.id.forgotText);
        forgotlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sign_In.this, ForgotPassword.class));
            }
        });
        forgotlinkimg = (ImageView)findViewById(R.id.forgotPasswordImage);
        forgotlinkimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sign_In.this, ForgotPassword.class));
            }
        });// --------------end of forgot links-----------------
    }

    class Async extends AsyncTask<Void, Void, Void>{

        boolean login = false;

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://igor.gold.ac.uk:3307/dcard001_splitsy", "dcard001", "134114");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT password FROM user WHERE email = '"+emailInput.getText().toString()+"'");

                while (resultSet.next()) {
                    if (passwordInput.getText().toString().equals(resultSet.getString(1))) {
                        startActivity(new Intent(Sign_In.this, Enable_Fingerprint.class));
                        login = true;
                    }
                }

            }
            catch (Exception e) {
                info.setText("There was an error.");
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            if (!login) {
                info.setText("Incorrect login information");
            }
            super.onPostExecute(aVoid);
        }
    }
}
