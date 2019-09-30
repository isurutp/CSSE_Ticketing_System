package com.csse.ticketing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class Welcome extends AppCompatActivity {

    private EditText username;
    private EditText location;
    private EditText balance;
    private EditText amount;
    private Button submit;

    private TextView pincode;
    private TextView pinMsg;

    private Spinner starting;
    private Spinner ending;

    SpringConnect springConnect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        username = findViewById(R.id.name);
        location = findViewById(R.id.location);
        balance = findViewById(R.id.balance);
        amount = findViewById(R.id.amount);
        starting = findViewById(R.id.spinner);
        ending = findViewById(R.id.spinner2);
        submit = findViewById(R.id.loginButton2);
        pincode = findViewById(R.id.pinCode);
        pinMsg = findViewById(R.id.showPin);

        pincode.setVisibility(View.INVISIBLE);
        pinMsg.setVisibility(View.INVISIBLE);

        springConnect = new SpringConnect();
        springConnect.getAddress(MainActivity.username);
        springConnect.getAmount(MainActivity.username);

        username.setText(MainActivity.username);
        location.setText(MainActivity.location);
        balance.setText(String.valueOf(MainActivity.balance));


        ending.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                if(starting.getSelectedItem().toString().equals(ending.getSelectedItem().toString()))
                {
                    amount.setText(null);
                    submit.setEnabled(false);
                    submit.setAlpha(0.5f);
                }
                else if(ending.getSelectedItem().toString().equalsIgnoreCase("Kaduwela"))
                {
                    amount.setText(String.valueOf(50.00));
                    submit.setEnabled(true);
                    submit.setAlpha(1f);
                }
                else if(ending.getSelectedItem().toString().equalsIgnoreCase("Kandy"))
                {
                    amount.setText(String.valueOf(250.00));
                    submit.setEnabled(true);
                    submit.setAlpha(1f);
                }
                else if(ending.getSelectedItem().toString().equalsIgnoreCase("Kollupitiya"))
                {
                    amount.setText(String.valueOf(150.00));
                    submit.setEnabled(true);
                    submit.setAlpha(1f);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    public void logout(View view)
    {
        MainActivity.balance = 0;
        MainActivity.username = "";
        MainActivity.location = "";

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void submitButton(View view)
    {
        if(Double.valueOf(balance.getText().toString()) <= Double.valueOf(amount.getText().toString()))
        {
            Toast.makeText(getApplicationContext(), "Not enough money in account", Toast.LENGTH_LONG).show();
            return;
        }

        boolean successful = springConnect.ReduceFare(MainActivity.username,amount.getText().toString());

        if(successful)
        {
            pincode.setVisibility(View.VISIBLE);
            pinMsg.setVisibility(View.VISIBLE);
            String token = null;

            while(token == null || !springConnect.checkTokenID(token))
            {
                Random rnd = new Random();
                int number = rnd.nextInt(999999);
                token = String.format("%06d", number);
            }

            pincode.setText(token);

            successful = springConnect.setJourney(  MainActivity.username,
                                                    starting.getSelectedItem().toString(),
                                                    ending.getSelectedItem().toString(),
                                                    amount.getText().toString(),
                                                    pincode.getText().toString()
                                                );
            if(successful)
            {
                submit.setAlpha(0.5f);
                submit.setEnabled(false);
                starting.setEnabled(false);
                ending.setEnabled(false);
                springConnect.getAmount(MainActivity.username);
                balance.setText(String.valueOf(MainActivity.balance));
            }
            else
            {
                Toast.makeText(getApplicationContext(), "An error occurred, Unable to book journey", Toast.LENGTH_LONG).show();
            }

        }
        else
        {
            Toast.makeText(getApplicationContext(), "An error occurred, Unable to book journey", Toast.LENGTH_LONG).show();
        }

    }

    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Back button is disabled in this Screen", Toast.LENGTH_LONG).show();
    }
}
