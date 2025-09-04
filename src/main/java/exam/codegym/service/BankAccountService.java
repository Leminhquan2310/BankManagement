package exam.codegym.service;

import exam.codegym.exception.NotFoundBankAccountException;
import exam.codegym.model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class BankAccountService {
    private static final String FILE_PATH = "data/bank_accounts.csv";
    private List<BankAccount> accounts = new ArrayList<>();

    public BankAccountService() {
        loadFromFile();
    }

    // ================== File Operations ==================
    private void loadFromFile() {
        accounts.clear();
        File file = new File(FILE_PATH);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");
                if (p.length == 8) {
                    accounts.add(new SavingAccount(
                            Integer.parseInt(p[0]), p[1], p[2], LocalDate.parse(p[3]),
                            Double.parseDouble(p[4]), LocalDate.parse(p[5]),
                            Double.parseDouble(p[6]), Integer.parseInt(p[7])));
                } else if (p.length == 6) {
                    accounts.add(new PaymentAccount(
                            Integer.parseInt(p[0]), p[1], p[2], LocalDate.parse(p[3]),
                            p[4], Double.parseDouble(p[5])));
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (BankAccount acc : accounts) {
                pw.println(acc.toCSV());
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    private int getNextId() {
        if (accounts.isEmpty()) return 1;
        return accounts.get(accounts.size() - 1).getId() + 1;
    }

    // ================== CRUD Operations ==================
    public void addAccount(Scanner sc) {
        System.out.println("Choose account type:");
        System.out.println("1. Saving Account");
        System.out.println("2. Payment Account");
        System.out.print("Enter choice: ");
        int choice = Integer.parseInt(sc.nextLine());

        int id = getNextId();
        System.out.print("Enter account code: ");
        String code = sc.nextLine();
        System.out.print("Enter owner name: ");
        String name = sc.nextLine();
        LocalDate createdDate = LocalDate.now();

        if (choice == 1) {
            System.out.print("Deposit amount: ");
            double deposit = Double.parseDouble(sc.nextLine());
            System.out.print("Deposit date (yyyy-MM-dd): ");
            LocalDate depositDate = LocalDate.parse(sc.nextLine());
            System.out.print("Interest rate: ");
            double rate = Double.parseDouble(sc.nextLine());
            System.out.print("Term months: ");
            int term = Integer.parseInt(sc.nextLine());

            accounts.add(new SavingAccount(id, code, name, createdDate, deposit, depositDate, rate, term));
        } else {
            System.out.print("Card number: ");
            String card = sc.nextLine();
            System.out.print("Balance: ");
            double balance = Double.parseDouble(sc.nextLine());

            accounts.add(new PaymentAccount(id, code, name, createdDate, card, balance));
        }
        saveToFile();
        System.out.println("Account added successfully!");
    }

    public void deleteAccount(Scanner sc) throws NotFoundBankAccountException {
        System.out.print("Enter account code to delete: ");
        String code = sc.nextLine();
        BankAccount found = null;
        for (BankAccount acc : accounts) {
            if (acc.getAccountCode().equals(code)) {
                found = acc; break;
            }
        }
        if (found == null) throw new NotFoundBankAccountException("Account not found.");

        System.out.print("Are you sure you want to delete? (Yes/No): ");
        String confirm = sc.nextLine();
        if (confirm.equalsIgnoreCase("Yes")) {
            accounts.remove(found);
            saveToFile();
            System.out.println("Account deleted!");
        }
    }

    public void showAccounts() {
        for (BankAccount acc : accounts) {
            System.out.println(acc);
        }
    }

    public void searchAccounts(Scanner sc) {
        System.out.print("Enter keyword: ");
        String key = sc.nextLine().toLowerCase();
        for (BankAccount acc : accounts) {
            if (acc.getAccountCode().toLowerCase().contains(key) ||
                    acc.getOwnerName().toLowerCase().contains(key)) {
                System.out.println(acc);
            }
        }
    }
}
