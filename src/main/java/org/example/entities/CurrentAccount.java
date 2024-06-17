package org.example.entities;

import java.util.ArrayList;
import java.util.List;

public class CurrentAccount extends Account{


    public CurrentAccount(Client client) {
        super(client);
    }

    @Override
    public void printStatement() {
        System.out.println("current account statement");
        super.printCommonInfos();
    }
  @Override
    public  void printTransactions(){
      System.out.println("----------transactions Current account----------");
      super.printTransactions();

  }
}
