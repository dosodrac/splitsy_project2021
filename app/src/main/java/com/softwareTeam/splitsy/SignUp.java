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
import java.sql.SQLException;
import java.sql.Statement;

public class SignUp extends AppCompatActivity {

    Button continuebtn; // continue botton
    TextView signin; //sign in link

    EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email = findViewById(R.id.emailInput);
        password = findViewById(R.id.passwordInput);


        //----------continue button-------------
        continuebtn = (Button) findViewById(R.id.accountContinueButton);
        continuebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // startActivity(new Intent(SignUp.this, AccountDetails.class));
                boolean isValid = Utils.checkEmailForValidity(email.getText().toString());

                if (isValid) {
                    Toast.makeText(getApplicationContext(), "Email is valid", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Email not valid", Toast.LENGTH_LONG).show();
                }
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

    public void btnConn(View view) {
        Send objSend = new Send();
        objSend.execute("");
    }


    private class Send extends AsyncTask<String, String, String> {

        String txtPassword = password.getText().toString();
        String txtEmail = email.getText().toString();
        String msg="";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            if (txtPassword.trim().equals("") || txtEmail.trim().equals(""))
                Toast.makeText(SignUp.this, "Please enter all fields....", Toast.LENGTH_LONG).show();
            else {
                try {
                    //JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");

                    //connecting to mysql database using driver
                    Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.0.17:3306/mydb",
                            "root", "YourRootPassword");


                    if (conn == null) {
                        Toast.makeText(SignUp.this,"nullllls",Toast.LENGTH_LONG).show();

                    } else {
                        //insert into database table
                        String query1 = "INSERT INTO test9 (name,password,email) values(' " + txtEmail + " ',' " + txtPassword + " ',' " + txtEmail + " ')";
                        Statement stmt1 = conn.createStatement();
                        stmt1.executeUpdate(query1);

                   /*
                   //get data from database
                   String query="select * from members";
                    Statement statement=conn.createStatement();
                    ResultSet resultSet=statement.executeQuery(query);
                    while(resultSet.next()){
                        String data="";
                        for(int a=1;a<9;a++){
                            data+=resultSet.getString(a)+" : ";
                        }
                    }*/
                        msg = " success! ";
                        Toast.makeText(SignUp.this,"success",Toast.LENGTH_LONG).show();

                    }
                    conn.close();

                } catch (ClassNotFoundException e) {
                    msg = "connection error";
                    Toast.makeText(SignUp.this,"err class",Toast.LENGTH_LONG).show();

                    e.printStackTrace();
                } catch (SQLException throwables) {
                    msg = "error!!!";
                    Toast.makeText(SignUp.this,"sql err",Toast.LENGTH_LONG).show();

                    throwables.printStackTrace();
                }
            }
            return msg;

        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(SignUp.this,"finished",Toast.LENGTH_LONG).show();

        }
    }
}

