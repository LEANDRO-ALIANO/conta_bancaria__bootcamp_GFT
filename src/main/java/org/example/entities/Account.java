package org.example.entities;

import org.example.Exceptions.InvalidTransaction;
import org.example.entities.Enum.Transaction_Type;
import org.example.entities.interfaces.AccountInterface;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class Account  implements AccountInterface {
    private static final int STANDARD_AGENCY = 1;
    private static int SEQUENTIAL = 1;


    protected int agency;
    protected int number;
    protected double balance;
    protected Client client;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    protected  List<Transaction> transactions = new ArrayList<>();


    public Account( Client client) {
        this.agency = STANDARD_AGENCY;
        this.number = SEQUENTIAL ++;
        this.client = client;
    }

    @Override
    public void withdraw(double value) {
        try{
            if (balance < value){
                throw new InvalidTransaction("saldo insuficiente");
            }else{
                Transaction  transaction = new Transaction(LocalDateTime.now(), Transaction_Type.WITHDRAW);
                transactions.add(transaction);
                balance -= value;
            }
        }catch (InvalidTransaction e){
            System.out.println( "transação invalida: " + e.getMessage());
        }catch (Exception e){
            System.out.println("nao foi possivel realizar a transação: "+e.getMessage());
        }

    }

    @Override
    public void deposit(double value) {

        try{
            if (value < 0){
                throw new InvalidTransaction("insira um valor maior que 0");
            }else{
                Transaction  transaction = new Transaction(LocalDateTime.now(), Transaction_Type.DEPOSITY);
                transactions.add(transaction);
                balance += value;
            }
        }catch (InvalidTransaction e){
            System.out.println( "transação invalida: " + e.getMessage());
        }catch (Exception e){
            System.out.println("nao foi possivel realizar a transação: "+e.getMessage());
        }

    }

    @Override
    public void transfer(double value, AccountInterface accountDestiny) {




        Transaction  transaction = new Transaction(LocalDateTime.now(), Transaction_Type.TRANSFER);
        transactions.add(transaction);
        this.withdraw(value);
        accountDestiny.deposit(value);

    }

    @Override
    public void printStatement() {
        System.out.println("balance: " + balance);

    }

    public static int getSEQUENTIAL() {
        return SEQUENTIAL;
    }

    public int getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    protected void printCommonInfos() {
        System.out.println(String.format("Titular: %s", this.client.getName()));
        System.out.println(String.format("Agencia: %d", this.agency));
        System.out.println(String.format("Numero: %d", this.number));
        System.out.println(String.format("Saldo: %.2f", this.balance));
    }

    protected  void printTransactions(){
        for(Transaction transaction : transactions){
            System.out.println(transaction.toString());
        }
    }
}
