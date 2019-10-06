package com.csse.ticketing;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.csse.ticketing.com.csse.ticketing.util.TokenDB;

import java.util.Random;

public class TemporaryToken extends AppCompatActivity {

    public TokenDB db;
    public String token;
    public TextView text_token;
    public TextView showPin;
    SpringConnect springConnect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_temporary_token);
          db = new TokenDB(this);
        springConnect = new SpringConnect();
        text_token = findViewById(R.id.text_token);
        showPin = findViewById(R.id.showPin);
        text_token.setText(getToken());
        token = getToken();



        WaitTillJourneyComplete();
    }


    public String createToken(){
        SpringConnect  springConnect = new SpringConnect();

        String token = null;
        while(token == null) {
            Random rnd = new Random();
            int number = rnd.nextInt(999999);
            token = String.format("%06d", number);
        }
        springConnect.registerNewUser(token,"","","","","");
        springConnect.transferCredit(token,"200");
        return token;
    }


    public String getToken(){
        SharedPreferences prefs = getSharedPreferences("tokenValue", MODE_PRIVATE);
        String token = prefs.getString("token", "");
        if(token.equals("")) {
            token = createToken();
            SharedPreferences.Editor editor = getSharedPreferences("tokenValue", MODE_PRIVATE).edit();
            editor.putString("token", token);
            editor.apply();
        }
        return token;
    }

    public void exit(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void end(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confromation Message");
        builder.setMessage("are you sure you want to go back?\n all information will be lost");
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                end();
            }
        });
        builder.setNegativeButton("Return", null);
        builder.show();


    }

    public void end(){
        SharedPreferences.Editor editor = getSharedPreferences("tokenValue", MODE_PRIVATE).edit();
        editor.putString("token", "");
        editor.apply();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }




    public void WaitTillJourneyComplete()
    {
        Thread thread =  new Thread() {
            public void run() {
                while(springConnect.checkUserInBus(token).equals("none"))
                {
                    try {
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //this will run on UI thread, so its safe to modify UI views.
                        String busID = springConnect.checkUserInBus(token);
                        String date = springConnect.checkTime(token);
                        String dateInfo[] = date.split(" ");

                        showPin.setText("You have got onto bus "+busID+" on "+dateInfo[1]+" "+dateInfo[2]+" at "+dateInfo[3]);
                    }
                });
                WaitTillOutsideBus();
            }
        };
        thread.setDaemon(true);
        thread.start();

    }

    public void WaitTillOutsideBus()
    {
        Thread thread =  new Thread() {
            public void run() {
                while(!springConnect.checkUserInBus(token).equals("none"))
                {
                    try {
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //this will run on UI thread, so its safe to modify UI views.
                        String fare = springConnect.getFare(token);
                        showPin.setText("Your journey has ended. Please pay the driver Rs."+fare);

                        text_token.setText("000000");
                        SharedPreferences.Editor editor = getSharedPreferences("tokenValue", MODE_PRIVATE).edit();
                        editor.putString("token", "");
                        editor.apply();

                    }
                });
                WaitTillJourneyComplete();

            }
        };
        thread.setDaemon(true);
        thread.start();

    }

}
