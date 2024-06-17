package org.example.entities;

public class PoupanceAccount extends Account{

    public PoupanceAccount(Client client) {
        super(client);
    }

    @Override
    public void printStatement() {
        System.out.println("Statement  poupance account");
        super.printCommonInfos();
    }

    @Override
    public  void printTransactions(){
        System.out.println("----------transactions Poupance----------");
        super.printTransactions();

    }
}
