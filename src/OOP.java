import javax.xml.crypto.Data;
import java.io.IOException;
import java.lang.ref.Cleaner;
import java.util.*;

public class OOP
{
    public static Scanner sc = new Scanner(System.in);

    public static List<User> usersDataList = DataSystem.readUser();
    public static List<Book> usersBookList = DataSystem.readUserBooks();
    public static String currentUser;

    public static void main(String[] args)
    {

        while (true)
        {
            clearTerminal();
            System.out.println("\nLibrary Management System\n");

            System.out.println("1. Register\n2. Login\n3. Exit");
            System.out.print("\nEnter your choice: ");

            try
            {
                int choice = sc.nextInt();

                switch (choice)
                {
                    case 1 -> registerUser();
                    case 2 -> loginUser();
                    case 3 -> System.exit(0);
                    default -> {
                        clearTerminal();
                        System.out.println("Invalid choice!");
                        delay();
                    }
                }

            } catch (InputMismatchException e) {
                clearTerminal();
                System.out.println("Invalid choice!");
                delay();
                break;
            }
        }
    }

    public static void registerUser()
    {
        clearTerminal();
        System.out.println("\nRegister Menu\n");

        System.out.print("Enter a username: ");
        String username = sc.next();

        System.out.print("Enter a password: ");
        String password = sc.next();

        User user = new User(username, password);

        if (DataSystem.registerUser(user))
        {
            clearTerminal();
            System.out.println("\nRegister successful! You can log in now");
            delay();
        }
        else
        {
            clearTerminal();
            System.out.println("\nUnsuccesful register. Try again");
            delay();
            registerUser();
        }
    }

    public static void loginUser()
    {
        clearTerminal();
        System.out.println("\nLogin Menu\n");

        sc.nextLine();
        System.out.print("Enter your username: ");
        String username = sc.nextLine();

        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        boolean userFound = false;
        for (User user: usersDataList)
        {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword()))
            {
                clearTerminal();
                System.out.println("\nLogin successful! Welcome to the library!");
                delay();

                currentUser = username;
                userFound = true;
                mainMenu();
                break;
            }
        }
        if (!userFound)
        {
            clearTerminal();
            System.out.println("\nUnsuccesful login! Try again.");
            delay();
        }
    }

    public static void mainMenu()
    {
        clearTerminal();
        System.out.println("\nMain Menu\n");

        System.out.println("Your name: " + currentUser);
        System.out.println("1. See your borrowed books\n2. Borrow a book\n3. Return a book\n4. Log out");
        System.out.print("\nEnter your choice: ");

        try
        {
            int choice = sc.nextInt();

            switch (choice)
            {
                case 1 -> seeBorrowedBooks();
//                case 2 -> borrowABook();
//                case 3 -> returnABook();
                case 4 -> {
                    break;
                }
                default -> {
                    clearTerminal();
                    System.out.println("Invalid choice!");
                    delay();
                    mainMenu();
                }
            }

        } catch (InputMismatchException e) {
            clearTerminal();
            System.out.println("Invalid choice!");
            delay();
            mainMenu();
        }
    }

    public static void seeBorrowedBooks()
    {
        clearTerminal();
        System.out.println("\nYour Borrowed Books\n");

        if (DataSystem.readUserBooks() == null)
        {
            System.out.println("\nNo books borrowed");
        }
        else
        {
            for (Book books: usersBookList)
            {
                System.out.println("Book's INB");
            }
        }
    }

    // UI METHODS

    public static void clearTerminal()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public  static void delay()
    {
        for (int i = 0; i < 4; i++)
        {
            try
            {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

