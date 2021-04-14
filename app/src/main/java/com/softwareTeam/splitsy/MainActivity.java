package com.softwareTeam.splitsy;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.*;

public class MainActivity extends AppCompatActivity {
    TextView text,errorText;
    Button show;


    Button go;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.testText1);
        errorText = (TextView) findViewById(R.id.noErrorTextText2);



        go=findViewById(R.id.go);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Sign_In.class));
            }
        });


        show = (Button) findViewById(R.id.button);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Async1().execute();
            }
        });
    }


    class Async1 extends AsyncTask<Void, Void, Void> {

        String records = "",error="";
        @Override
        protected Void doInBackground(Void... voids) {
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://igor.gold.ac.uk:3307/dcard001_splitsy", "dcard001", "134114");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT email FROM user");
                while(resultSet.next()) {
                    records += resultSet.getString(1) + "\n";

                }

            }
            catch(Exception e)
            {
                error = e.toString();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            text.setText(records);
            if (error != "")
                errorText.setText(error);
            super.onPostExecute(aVoid);
        }
    }
}