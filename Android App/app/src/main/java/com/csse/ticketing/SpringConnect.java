package com.csse.ticketing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

public class SpringConnect
{
    public final String ipAddress = "http://192.168.8.110:8080";

    /**
     * Checking login details by connecting to spring backend
     * @param username
     * @param password
     * @return true if login is valid
     */
    public boolean checkLoginDetails(final String username, final String password)
    {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Thread thread =  new Thread() {
            public void run() {
                try {

                    String url = ipAddress + "/login?userDetails=" + username + "," + password;
                    URL aURL = new URL(url);

                    HttpURLConnection connection = (HttpURLConnection) aURL.openConnection();
                    connection.setRequestMethod("GET");
                    connection.connect();

                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(
                                    connection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String currentLine;

                    while ((currentLine = in.readLine()) != null)
                        response.append(currentLine);

                    in.close();

                    if (response.toString().trim().equalsIgnoreCase("true"))
                    {
                            atomicBoolean.set(true);
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        };
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return atomicBoolean.get();
    }

    /**
     * Adding a new user by connecting to spring backend
     * @param username
     * @param password
     * @return true if login is valid
     */
    public boolean registerNewUser(final String username, final String NIC, final String location, final String dob, final String password, final String email)
    {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Thread thread =  new Thread() {
            public void run() {
                try {

                    String url = ipAddress + "/register?userDetails=" + username + "," + NIC + "," + location+ "," + dob+ "," + password+ "," + email;
                    URL aURL = new URL(url);

                    HttpURLConnection connection = (HttpURLConnection) aURL.openConnection();
                    connection.setRequestMethod("GET");
                    connection.connect();

                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(
                                    connection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String currentLine;

                    while ((currentLine = in.readLine()) != null)
                        response.append(currentLine);

                    in.close();

                    if (response.toString().trim().equalsIgnoreCase("true"))
                    {
                        atomicBoolean.set(true);
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        };
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return atomicBoolean.get();
    }

    /**
     * Updates user's address by connecting to spring backend
     * @param username
     */
    public void getAddress(final String username)
    {
        final Thread thread =  new Thread() {
            public void run() {
                try {

                    String url = ipAddress + "/getAddress?username=" + username;
                    URL aURL = new URL(url);

                    HttpURLConnection connection = (HttpURLConnection) aURL.openConnection();
                    connection.setRequestMethod("GET");
                    connection.connect();

                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(
                                    connection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String currentLine;

                    while ((currentLine = in.readLine()) != null)
                        response.append(currentLine);
                    in.close();

                    MainActivity.location = response.toString();


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        };
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates user's balance by connecting to spring backend
     * @param username
     */
    public void getAmount(final String username)
    {
        final Thread thread =  new Thread() {
            public void run() {
                try {

                    String url = ipAddress + "/getAmount?username=" + username;
                    URL aURL = new URL(url);

                    HttpURLConnection connection = (HttpURLConnection) aURL.openConnection();
                    connection.setRequestMethod("GET");
                    connection.connect();

                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(
                                    connection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String currentLine;

                    while ((currentLine = in.readLine()) != null)
                        response.append(currentLine);
                    in.close();

                    MainActivity.balance = Double.valueOf(response.toString());


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        };
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
