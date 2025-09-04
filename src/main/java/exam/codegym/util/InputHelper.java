package exam.codegym.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputHelper {
    private final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public int inputInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên!");
            }
        }
    }

    public Long inputLong(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Long.parseLong(line);
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên!");
            }
        }
    }

    public double inputDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số thực!");
            }
        }
    }

    public String inputString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) return line;
            System.out.println("Chuỗi không được để trống!");
        }
    }

    public LocalDate inputDate(String prompt) {
        while (true) {
            System.out.print(prompt + " (dd/MM/yyyy): ");
            String line = scanner.nextLine().trim();
            try {
                return LocalDate.parse(line, DF);
            } catch (DateTimeParseException e) {
                System.out.println("Ngày không hợp lệ, định dạng đúng là dd/MM/yyyy!");
            }
        }
    }
}
