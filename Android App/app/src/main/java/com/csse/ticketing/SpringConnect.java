package com.csse.ticketing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

public class SpringConnect
{
    public final String ipAddress = "http://192.168.43.156:8080"; //Need to add to network_security_config.xml

    /**
     * Checking login details by connecting to spring backend
     * @param username
     * @param password
     * @return true if login is valid
     */
    public boolean checkLoginDetails(final String username, final String password)
    {
        boolean result = false;

        String url = ipAddress + "/login?userDetails=" + username + "," + password;
        if (getResult(url).equalsIgnoreCase("true"))
        {
            result = true;
        }
        return result;
    }

    /**
     * Adding a new user by connecting to spring backend
     * @param username
     * @param password
     * @return true if login is valid
     */
    public boolean registerNewUser(String username, String NIC, String location, String dob, String password, String email)
    {
        boolean result = false;

        String url = ipAddress + "/register?userDetails=" + username + "," + NIC + "," + location+ "," + dob+ "," + password+ "," + email;
        if (getResult(url).equalsIgnoreCase("true"))
        {
            result = true;
        }
        return result;
    }

    /**
     * Updates user's address by connecting to spring backend
     * @param username
     */
    public void getAddress(String username)
    {
        String url = ipAddress + "/getAddress?username=" + username;
        MainActivity.location = getResult(url);
    }

    /**
     * Updates user's balance by connecting to spring backend
     * @param username
     */
    public void getBalance(String username)
    {
        String url = ipAddress + "/getAmount?username=" + username;
        MainActivity.balance = Double.valueOf(getResult(url));
    }

    /**
     * Reduces fare from user's balance by connecting to spring backend
     * @param username
     * @param amount The fare charge to deduct from the balance
     */
    public Boolean ReduceFare(String username,String amount)
    {
        boolean result = false;

        String url = ipAddress + "/ReduceFare?fareDetails=" + username + "," + amount;
        if (getResult(url).trim().equalsIgnoreCase("true"))
        {
            result = true;
        }
        return result;
    }

    /**
     * Adds to user's balance by connecting to spring backend
     * @param username
     * @param amount The fare to add from the balance
     */
    public Boolean transferCredit(String username,String amount)
    {
        boolean result = false;

        String url = ipAddress + "/transferCredit?amountDetails=" + username + "," + amount;
        if (getResult(url).trim().equalsIgnoreCase("true"))
        {
            result = true;
        }
        return result;
    }


    /**
     * sends Journey details to spring backend
     * @param username
     */
    public Boolean setJourney(String username,String starting,  String ending, String fare, String tokenID)
    {
        boolean result = false;

        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        String url = ipAddress + "/setJourney?journeyDetails=" + username + "," + starting + "," + ending + "," + fare + "," + tokenID + "," + date;

        if (getResult(url).trim().equalsIgnoreCase("true"))
        {
            result = true;
        }
        return result;
    }

    /**
     * Checks if token ID is usable by connecting to spring backend
     * @param tokenID
     */
    public Boolean checkTokenID(String tokenID)
    {
        boolean result = false;

        String url = ipAddress + "/checkToken?token="+tokenID;
        if (getResult(url).trim().equalsIgnoreCase("true"))
        {
            result = true;
        }
        return result;
    }

    /**
     * Checks if user is inside a bus by connecting to spring backend
     * @param name
     * @return busID
     */
    public String checkUserInBus(String name)
    {
        String url = ipAddress + "/checkUserInBus?username="+name;
        return getResult(url);
    }

    /**
     * gets time user go onto bus by connecting to spring backend
     * @param name
     * @return Time
     */
    public String checkTime(String name)
    {
        String url = ipAddress + "/checkTime?username="+name;
        return getResult(url);
    }


    /**
     * Get the fare of a completed Journey
     * @param name
     * @return The amount charged
     */
    public String getFare(String name)
    {
        String url = ipAddress + "/getFare?username="+name;
        return getResult(url);
    }

    /**
     * Reset tokens on journey complete
     * @param name
     * @return The amount charged
     */
    public void resetTokens(String name)
    {
        String url = ipAddress + "/resetTokens?username="+name;
        getResult(url);
    }




    /**
     * Will get the reply obtained from the URL passed.
     * @param url
     * @return the reply as a string
     */
    public String getResult(final String url)
    {
        final AtomicReference<String> result = new AtomicReference<>();

        final Thread thread =  new Thread() {
            public void run() {
                try {
                    //Pasing URL and making connection
                    URL aURL = new URL(url);
                    HttpURLConnection connection = (HttpURLConnection) aURL.openConnection();
                    connection.setRequestMethod("GET");
                    connection.connect();

                    //Preparing to receive the response
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(
                                    connection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String currentLine;

                    //Reading the response and storing it in 'response'
                    while ((currentLine = in.readLine()) != null)
                        response.append(currentLine);

                    in.close();
                    result.set(response.toString());
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                    result.set("");
                }
            }
        };
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result.get();
    }


    /**
     * Checking login details by connecting to spring backend
     * @param token
     * @return true if login is valid
     */
    public boolean checkTempPassenger( final String token)
    {
        boolean result = false;

        String url = ipAddress + "/checkTemp?token=" + token;
        if (getResult(url).equalsIgnoreCase("true"))
        {
            result = true;
        }
        return result;
    }

    /**
     * Checking login details by connecting to spring backend
     * @param token
     * @return true if login is valid
     */
    public boolean createTempPassenger( final String token)
    {
        boolean result = false;

        String url = ipAddress + "/setTemp?token=" + token;
        if (getResult(url).equalsIgnoreCase("true"))
        {
            result = true;
        }
        return result;
    }


}
