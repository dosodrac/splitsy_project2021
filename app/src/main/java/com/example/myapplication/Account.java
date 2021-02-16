
package com.example.myapplication;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

public class Account extends AppCompatActivity {
    Button logout;
    TextView editpass;

    //addcard
    TextView addcard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        logout=findViewById(R.id.logoutbtn);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Account.this, MainActivity.class);
                startActivity(intent);
            }
        });


        //editpassword
        editpass=findViewById(R.id.changepassword);

        editpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Account.this, EditPassword.class);
                startActivity(intent);
            }
        });



        //editpassword
        addcard=findViewById(R.id.addcard);

        addcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Account.this, AddCard.class);
                startActivity(intent);
            }
        });

    }
}