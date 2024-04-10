package com.example.instanttest.exception.user;

public class UserEmailDuplicateException extends RuntimeException {

    public UserEmailDuplicateException(String message) {
        super(message);
    }

}
