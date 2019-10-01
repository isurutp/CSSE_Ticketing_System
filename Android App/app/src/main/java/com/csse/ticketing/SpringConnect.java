package com.csse.ticketing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public class SpringConnect
{
    public final String ipAddress = "http://192.168.8.110:8080"; //Need to add to network_security_config.xml

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

    /**
     * Reduces fare from user's balance by connecting to spring backend
     * @param username
     * @param amount The fare charge to deduct from the balance
     */
    public Boolean ReduceFare(final String username,final String amount)
    {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Thread thread =  new Thread() {
            public void run() {
                try {

                    String url = ipAddress + "/ReduceFare?fareDetails=" + username + "," + amount;
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
     * sends Journey details to spring backend
     * @param username
     */
    public Boolean setJourney(final String username,final String starting, final String ending, final String fare, final String tokenID)
    {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Thread thread =  new Thread() {
            public void run() {
                try {
                    String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
                    String url = ipAddress + "/setJourney?journeyDetails=" + username + "," + starting + "," + ending + "," + fare + "," + tokenID + "," + date;
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
     * Checks if token ID is usable by connecting to spring backend
     * @param tokenID
     */
    public Boolean checkTokenID(final String tokenID)
    {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Thread thread =  new Thread() {
            public void run() {
                try {

                    String url = ipAddress + "/checkToken?token="+tokenID;
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



}
