package exam.codegym.model;

import java.time.LocalDate;

public class PaymentAccount extends BankAccount {
    private String cardNumber;
    private double balance;

    public PaymentAccount(int id, String accountCode, String ownerName, LocalDate createdDate,
                          String cardNumber, double balance) {
        super(id, accountCode, ownerName, createdDate);
        this.cardNumber = cardNumber;
        this.balance = balance;
    }

    @Override
    public String toCSV() {
        return id + "," + accountCode + "," + ownerName + "," + createdDate + ","
                + cardNumber + "," + balance;
    }

    @Override
    public String toString() {
        return "PaymentAccount{" +
                "id=" + id +
                ", accountCode='" + accountCode + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", createdDate=" + createdDate +
                ", cardNumber='" + cardNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
