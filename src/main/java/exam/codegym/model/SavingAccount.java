package exam.codegym.model;

import java.time.LocalDate;

public class SavingAccount extends BankAccount {
    private double depositAmount;
    private LocalDate depositDate;
    private double interestRate;
    private int termMonths;

    public SavingAccount(int id, String accountCode, String ownerName, LocalDate createdDate,
                         double depositAmount, LocalDate depositDate, double interestRate, int termMonths) {
        super(id, accountCode, ownerName, createdDate);
        this.depositAmount = depositAmount;
        this.depositDate = depositDate;
        this.interestRate = interestRate;
        this.termMonths = termMonths;
    }

    @Override
    public String toCSV() {
        return id + "," + accountCode + "," + ownerName + "," + createdDate + ","
                + depositAmount + "," + depositDate + "," + interestRate + "," + termMonths;
    }

    @Override
    public String toString() {
        return "SavingAccount{" +
                "id=" + id +
                ", accountCode='" + accountCode + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", createdDate=" + createdDate +
                ", depositAmount=" + depositAmount +
                ", depositDate=" + depositDate +
                ", interestRate=" + interestRate +
                ", termMonths=" + termMonths +
                '}';
    }
}
