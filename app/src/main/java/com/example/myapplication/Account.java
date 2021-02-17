
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
        import android.widget.TextView;

        import com.google.android.material.bottomnavigation.BottomNavigationView;

        import java.net.CacheRequest;

public class Account extends AppCompatActivity {
    Button logout;
    TextView changepassword;


    //addcard
    TextView addcard;

    //navbar
    BottomNavigationView bottomNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);


        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

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

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            Intent i=new Intent(Account.this,MainActivity.class);
                            startActivity(i);

                            return true;
                        case R.id.nav_profile:
                            Intent intent=new Intent(Account.this,AddCard.class);
                            startActivity(intent);
                            return true;
                        case R.id.nav_setting:
                            Intent j =new Intent(Account.this,PastBill.class);
                            startActivity(j);
                            return true;
                    }
                    return false;
                }
            };
}