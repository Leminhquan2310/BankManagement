package exam.codegym.model;

import java.time.LocalDate;

public abstract class BankAccount {
    protected int id;
    protected String accountCode;
    protected String ownerName;
    protected LocalDate createdDate;

    public BankAccount(int id, String accountCode, String ownerName, LocalDate createdDate) {
        this.id = id;
        this.accountCode = accountCode;
        this.ownerName = ownerName;
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    // Abstract methods
    public abstract String toCSV();

    @Override
    public abstract String toString();
}
