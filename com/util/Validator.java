package com.util;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;  

/**
* This class is used for validation 
* validates the employee entity
*/
public class Validator {

    /**
    * Method that validates the alphabets only in string
    * 
    */
    public static boolean isValidAlphabet(String employeeName) {
        for (char c : employeeName.toCharArray()) {
            if (!(Character.isLetter(c))) {
                return false; 
            }
        }
        return true;
    }

    /**
    * The method that validates the date of birth and calculate the age 
    */
    public static int calculateAge(String employeeDOB) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false); 

        /**
        * Validate date format using String methods
        */ 
        if (employeeDOB.length() != 10 || 
            !employeeDOB.matches("\\d{2}/\\d{2}/\\d{4}")) {
            return -1; 
        }
        String[] dateParts = employeeDOB.split("/");
        int day = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]) - 1; 
        int year = Integer.parseInt(dateParts[2]);

        /**
        * Validate date with calendar 
        */
        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false);
        if (!isValidDate(day, month, year)) {
            return -1; 
        }

        /** 
        * Calculate age
        */
        Calendar today = Calendar.getInstance();
        int currentYear = today.get(Calendar.YEAR);  
        int birthYear = year;
        int age = currentYear - birthYear;
        int currentMonth = today.get(Calendar.MONTH);
        int birthMonth = month;
        int birthDay = day;

        if (birthYear > currentYear) {
            return -1; 
        } else if ((birthYear == currentYear) && 
            ((currentMonth < birthMonth) || (currentMonth == birthMonth) && (today.get(Calendar.DAY_OF_MONTH) < birthDay))) {
            age--;
        }

        return age;
    }

    public static boolean isValidDate(int day, int month, int year) {
        try {
            Calendar cal = Calendar.getInstance();
            cal.set(year, month, day);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    
    /**
    * Validates contact number accepts only 10 digits and the number starts with 6 or 7 or 8 or  9
    *
    */
    public static boolean isValidContact(String contactNumberString) {  
        Pattern ptrn = Pattern.compile("(0/91)?[6-9][0-9]{9}");  
        Matcher match = ptrn.matcher(contactNumberString);  
        return (match.find() && match.group().equals(contactNumberString));  
    } 

    /**
    * Validate mail id with regrex pattern, if matches the pattern returns as true or false
    */
    public static boolean isValidMail(String emailId) {
        String regex = "^[a-z0-9_+&*]+@(.+)$"; 
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emailId);
        return matcher.matches(); 
    }
}