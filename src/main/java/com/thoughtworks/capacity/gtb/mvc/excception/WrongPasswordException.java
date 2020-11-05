package com.thoughtworks.capacity.gtb.mvc.excception;


public class WrongPasswordException extends RuntimeException {

    public WrongPasswordException(String message) {
        super(message);
    }
}