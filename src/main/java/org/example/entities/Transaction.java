package org.example.entities;

import org.example.entities.Enum.Transaction_Type;

import java.time.LocalDateTime;

public class Transaction {
    LocalDateTime dateTime;

    Transaction_Type transactionType;

    public Transaction(LocalDateTime dateTime, Transaction_Type transactionType) {
        this.dateTime = dateTime;
        this.transactionType = transactionType;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Transactions " +
                "dateTime: " + dateTime +
                ", transactionType: " + transactionType
        ;
    }
}
