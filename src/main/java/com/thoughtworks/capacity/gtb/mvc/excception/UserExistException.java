package com.thoughtworks.capacity.gtb.mvc.excception;


public class UserExistException extends RuntimeException {

    public UserExistException(String message) {
        super(message);
    }
}