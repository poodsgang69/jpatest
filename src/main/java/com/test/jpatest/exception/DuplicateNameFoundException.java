package com.test.jpatest.exception;

public class DuplicateNameFoundException extends RuntimeException{
    public DuplicateNameFoundException (String name) {
        super("Duplicate name found in the DB -> " + name);
    }
}
