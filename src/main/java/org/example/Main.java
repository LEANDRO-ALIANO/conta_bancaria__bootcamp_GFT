package org.example;

import org.example.entities.Client;
import org.example.entities.CurrentAccount;
import org.example.entities.PoupanceAccount;

public class Main {
    public static void main(String[] args) {

        Client leandro = new Client("leandro", "1234567");
        CurrentAccount  cc = new CurrentAccount(leandro);
        PoupanceAccount poupance =  new PoupanceAccount(leandro);

        cc.deposit(30);
        poupance.deposit(10);

        cc.printStatement();
        poupance.printStatement();

        cc.transfer(20 , poupance);
        System.out.println("/----------------------------------------------------------------------");
        cc.printStatement();
        poupance.printStatement();

        cc.printTransactions();
        poupance.printTransactions();

    }
}