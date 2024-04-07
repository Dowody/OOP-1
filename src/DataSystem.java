import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataSystem {

    private static final String USERS_DATA_FILE = "users_data_file.txt";
    private static final String USERS_BOOKS = "users_books.txt";

    public static boolean registerUser(User user)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_DATA_FILE, true) ))
        {
            writer.write(user.getUsername() + ", " + user.getPassword());
            writer.newLine();
            writer.flush();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("\nError writing the data :" + e.getMessage());
            return false;
        }
    }

    public static List<User> readUser()
    {
        List<User> usersDataList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_DATA_FILE)))
        {
            String line;

            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split(",");
                String username = parts[0].trim();
                String password = parts[1].trim();

                usersDataList.add(new User(username, password));
            }

        } catch (IOException e) {
            System.out.println("\nError reading data :" + e.getMessage());
        }

        return usersDataList;
    }

    public static List <Book> readUserBooks()
    {
        List<Book> userBookList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_DATA_FILE)))
        {
            String line;

            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split(",");
                String title = parts[0].trim();
                String author = parts[1].trim();
                String ISBN = parts[2].trim();
                Boolean isAvailable = Boolean.parseBoolean(parts[3].trim());

                userBookList.add(new Book(title, author, ISBN, isAvailable));
            }

        } catch (IOException e) {
            System.out.println("\nError reading data :" + e.getMessage());
        }

        return userBookList;
    }
}
