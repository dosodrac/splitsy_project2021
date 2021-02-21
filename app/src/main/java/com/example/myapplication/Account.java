
package com.example.myapplication;

import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.fragment.app.Fragment;
        import androidx.fragment.app.FragmentTransaction;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.TextView;

        import com.google.android.material.bottomnavigation.BottomNavigationView;

        import java.net.CacheRequest;

public class Account extends AppCompatActivity {
    Button logout;
    TextView changepassword;

    //addcard
    TextView addcard;

    //bottom navbar
    BottomNavigationView bottomNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        //bottom navbar
        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);



        //log out btn
        logout=findViewById(R.id.logoutbtn);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Account.this, MainActivity.class);
                startActivity(intent);
            }
        });


        //editpassword
        changepassword=findViewById(R.id.changepassword);

        changepassword.setOnClickListener(new View.OnClickListener() {
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

    //fragment transaction
    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    //bottom navigation listener and switch activity
    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            return true;
                        case R.id.nav_profile:
                            return true;
                        case R.id.nav_setting:
                            return true;
                    }
                    return false;
                }
            };
}