package com.softwareTeam.splitsy;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {


    public static boolean checkEmailForValidity(String email) {
       // email = email.trim();

        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();

    }

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);



}
