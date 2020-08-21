package com.alex.shoppingcart.customExceptions;

public class ItemNotFoundException extends Exception {

    public ItemNotFoundException(String message) {
        super(message);
    }

    public ItemNotFoundException(String message, Throwable err) {
        super(message, err);
    }

}