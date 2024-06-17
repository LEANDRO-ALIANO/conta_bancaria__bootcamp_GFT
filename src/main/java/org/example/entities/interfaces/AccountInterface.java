package org.example.entities.interfaces;

public interface AccountInterface {

    void withdraw(double value);

    void deposit(double value);

    void transfer(double value, AccountInterface contaDestino);

    void printStatement();

}
