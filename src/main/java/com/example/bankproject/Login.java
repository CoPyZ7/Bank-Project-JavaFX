package com.example.bankproject;


public class Login{

    //defualt password
    private final static String username = "Boiken";
    private final static String password = "1234";

    //getters
    public static String getUsername() { return username; }

    public static String getPassword() { return password; }

    //login validator method
    public static boolean loginValidator(String usr, String pssw) {
        return usr.equals(getUsername()) && pssw.equals(getPassword());
    }
}



