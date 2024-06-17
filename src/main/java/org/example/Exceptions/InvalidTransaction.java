package org.example.Exceptions;

public class InvalidTransaction  extends  RuntimeException{
    public InvalidTransaction(String msg){
        super(msg);
    }
}
