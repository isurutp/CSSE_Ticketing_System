package com.csse.ticketing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    private EditText usernameET;
    private EditText password;

    public static String username;
    public static String location;
    public static double balance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameET = findViewById(R.id.username);
        password = findViewById(R.id.password);
    }

    public void registerButton(View view)
    {
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
    }

    public void loginButton(View view)
    {
        SpringConnect springConnect = new SpringConnect();
        boolean successful = springConnect.checkLoginDetails(usernameET.getText().toString(),password.getText().toString());

        if(successful)
        {
            username = usernameET.getText().toString();

            Intent intent = new Intent(this, Welcome.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Login details are incorrect", Toast.LENGTH_LONG).show();
        }
    }


    public void onBackPressed() {
        this.finishAffinity();
        System.exit(0);
    }
}
