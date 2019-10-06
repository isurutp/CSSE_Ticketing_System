package com.csse.ticketing;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
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
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
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
//        pinMsg.setVisibility(View.INVISIBLE);
        pinMsg.setText("Please tell The bus driver your name");

        springConnect = new SpringConnect();
        springConnect.getAddress(MainActivity.username);
        springConnect.getBalance(MainActivity.username);

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

        WaitTillInsideBus();


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
            new AlertDialog.Builder(this)
                .setTitle("Confirm Journey")
                .setMessage("Do you really want to book a trip from "+starting.getSelectedItem().toString()+
                            " to "+ending.getSelectedItem().toString()+
                            " for Rs"+amount.getText().toString())
                .setIcon(android.R.drawable.ic_dialog_alert)

                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener()
                {
                public void onClick(DialogInterface dialog, int whichButton) {
                        pincode.setVisibility(View.VISIBLE);
                        pinMsg.setVisibility(View.VISIBLE);
                        String token = null;
                        while(token == null || !springConnect.checkTokenID(token) || token.equals("000000"))
                        {
                            Random rnd = new Random();
                            int number = rnd.nextInt(999999);
                            token = String.format("%06d", number);
                        }

                        springConnect.getBalance(MainActivity.username);
                        balance.setText(String.valueOf(MainActivity.balance));
                        pinMsg.setText("Your Journey has been Booked Successfully");
                        pincode.setText(token);
                        ending.setSelection(0);
//                        boolean successful = springConnect.setJourney(  MainActivity.username,
//                                starting.getSelectedItem().toString(),
//                                ending.getSelectedItem().toString(),
//                                amount.getText().toString(),
//                                pincode.getText().toString()
////                        );
//                        if(successful)
//                        {
//                            submit.setAlpha(0.5f);
//                            submit.setEnabled(false);
//                            starting.setEnabled(false);
//                            ending.setEnabled(false);
//                            springConnect.getBalance(MainActivity.username);
//                            balance.setText(String.valueOf(MainActivity.balance));
//                        }
//                        else
//                        {
//                            Toast.makeText(getApplicationContext(), "An error occurred, Unable to book journey", Toast.LENGTH_LONG).show();
//                        }

                }})

                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        Toast.makeText(getApplicationContext(), "Journey was not booked", Toast.LENGTH_LONG).show();
                    }}).show();

        }
        else
        {
            Toast.makeText(getApplicationContext(), "An error occurred, Unable to book journey", Toast.LENGTH_LONG).show();
        }

    }

    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Back button is disabled in this Screen", Toast.LENGTH_LONG).show();
    }


    //Waits till user gets into a bus
    public void WaitTillInsideBus()
    {
        Thread thread =  new Thread() {
            public void run() {
                while(springConnect.checkUserInBus(MainActivity.username).equals("none"))
                {
                    try {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                springConnect.getBalance(MainActivity.username);
                                balance.setText(String.valueOf(MainActivity.balance));
                            }
                        });

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //this will run on UI thread, so its safe to modify UI views.
                        String busID = springConnect.checkUserInBus(MainActivity.username);
                        String date = springConnect.checkTime(MainActivity.username);
                        String dateInfo[] = date.split(" ");

                        pincode.setVisibility(View.INVISIBLE);
                        pinMsg.setText("You have got onto bus "+busID+" on "+dateInfo[1]+" "+dateInfo[2]+" at "+dateInfo[3]);
                        pinMsg.setVisibility(View.VISIBLE);
                        submit.setEnabled(false);
                        starting.setEnabled(false);
                        ending.setEnabled(false);
                    }
                });
                WaitTillOutsideBus();

            }
        };
        thread.start();

    }

    //Waits till user gets out of a bus
    public void WaitTillOutsideBus()
    {
        Thread thread =  new Thread() {
            public void run() {
                while(!springConnect.checkUserInBus(MainActivity.username).equals("none"))
                {
                    try {
                        Thread.sleep(1000);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                springConnect.getBalance(MainActivity.username);
                                balance.setText(String.valueOf(MainActivity.balance));
                            }
                        });

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //this will run on UI thread, so its safe to modify UI views.
                        String fare = springConnect.getFare(MainActivity.username);
                        springConnect.resetTokens(MainActivity.username);
                        springConnect.ReduceFare(MainActivity.username,fare);
                        springConnect.getBalance(MainActivity.username);
                        balance.setText(String.valueOf(MainActivity.balance));

                        pincode.setVisibility(View.INVISIBLE);
                        pinMsg.setText("Your journey has ended. You have been charged "+fare);
                        pinMsg.setVisibility(View.VISIBLE);
                        submit.setEnabled(true);
                        starting.setEnabled(true);
                        ending.setEnabled(true);
                    }
                });
                WaitTillInsideBus();

            }
        };
        thread.start();

    }
}
