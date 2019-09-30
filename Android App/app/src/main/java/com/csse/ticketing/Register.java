package com.csse.ticketing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    private EditText username;
    private EditText nic;
    private EditText City;
    private EditText dob;
    private EditText password;
    private EditText password2;
    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.username4);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        password2 = findViewById(R.id.password2);
        nic = findViewById(R.id.NIC2);
        City = findViewById(R.id.City);
        dob = findViewById(R.id.dob);
    }

    public void loginInsteadButton(View view)
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void submitButton(View view)
    {
        if(!password.getText().toString().equals(password2.getText().toString()))
        {
            Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_LONG).show();
            return;
        }

        SpringConnect springConnect = new SpringConnect();
        boolean successful = springConnect.registerNewUser( username.getText().toString(),
                                                            nic.getText().toString(),
                                                            City.getText().toString(),
                                                            dob.getText().toString(),
                                                            password.getText().toString(),
                                                            email.getText().toString()
                                                        );

        if(successful)
        {
            Toast.makeText(getApplicationContext(), "Please check email to validate account", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Something went wrong, Unable to create account", Toast.LENGTH_LONG).show();
        }
    }
}
