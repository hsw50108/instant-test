package com.example.instanttest.exception.user;

//TODO : exception global handler 만들기
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
