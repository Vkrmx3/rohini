package com.employeeException;

/**
* This class deals with Exception in all my applications
*
*/
public class EmployeeException extends Exception {
    public EmployeeException(String message, Throwable throwable) {
        super(message, throwable);    
    }    
}