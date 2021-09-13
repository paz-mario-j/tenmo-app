package com.techelevator.tenmo.exceptions;

public class InsufficientFunds extends Exception{
    public InsufficientFunds() {
        super("You're broke, bud!");
    }

}
