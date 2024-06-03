package com.test.jpatest.exception;

public class DuplicateEmailFoundException extends RuntimeException{
    public DuplicateEmailFoundException (String email) {
        super("Duplicate email found in the DB -> " + email);
    }
}
