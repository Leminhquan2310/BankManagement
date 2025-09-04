package exam.codegym;

import exam.codegym.exception.NotFoundBankAccountException;
import exam.codegym.service.BankAccountService;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BankAccountService service = new BankAccountService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== BANK ACCOUNT MANAGEMENT =====");
            System.out.println("1. Add new account");
            System.out.println("2. Delete account");
            System.out.println("3. Show account list");
            System.out.println("4. Search accounts");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            String choice = sc.nextLine();
            try {
                switch (choice) {
                    case "1":
                        service.addAccount(sc);
                        break;
                    case "2":
                        service.deleteAccount(sc);
                        break;
                    case "3":
                        service.showAccounts();
                        break;
                    case "4":
                        service.searchAccounts(sc);
                        break;
                    case "5":
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (NotFoundBankAccountException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}