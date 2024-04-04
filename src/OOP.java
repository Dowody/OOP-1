import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class OOP {

    public static Scanner sc = new Scanner(System.in);
    public static BankAccount bankAccount;

    public static void main(String[] args)
    {
        bankAccount = new BankAccount(generateAccountNumber(), "Bogdan", 50);

        while (true)
        {
            System.out.println("\033[2J\033[1;1H");


            System.out.println("Account's No: " + bankAccount.getAccountNumber());
            System.out.println("Holder name: " + bankAccount.getAccountHolderName());
            System.out.println("Balance: $" + bankAccount.getBalance());

            System.out.println("\n1. Withdraw: \n2. Deposit\n3. Exit\n");

            try
            {
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

                switch (choice)
                {
                    case 1 -> {
                        withdrawBalance();
                    }
                    case 2 -> {
                        depositBalance();
                    }
                    case 3 -> {
                        System.exit(0);
                    }
                    default -> {
                        System.out.println("Invalid Choice!");
                        withdrawBalance();
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input!");
                break;
            }
        }
    }

    public static void withdrawBalance()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("Balance: " + bankAccount.getBalance() + "\n");
        System.out.print("Enter the amount you want to withdraw: ");

        int amount = sc.nextInt();

        if (amount > bankAccount.getBalance()) {

            System.out.println("Insufficent balance!");

        } else {

            double newBalance = bankAccount.getBalance() - amount;
            bankAccount.setBalance(newBalance);
        }
    }
    public static void depositBalance()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("Balance: " + bankAccount.getBalance() + "\n");
        System.out.print("Enter the amount you want to deposit: ");

        int amount = sc.nextInt();

        double newBalance = bankAccount.getBalance() + amount;
        bankAccount.setBalance(newBalance);
    }

    public static String generateAccountNumber()
    {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 16; i++)
        {
            if (i > 0 && i % 4 == 0)
            {
                sb.append(" ");
            }

            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }
}
