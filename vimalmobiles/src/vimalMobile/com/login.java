package vimalMobile.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class login {
    private final Map<String, String> users = new HashMap<>();
    private final List<User> userList = new ArrayList<>();

    // Add admin to the system
    public void addAdmin(String username, String password) {
        users.put(username, password);
        userList.add(new User(username, "admin"));
    }

    // Add customer to the system
    public void addCustomer(String username, String password) {
        if (users.containsKey(username)) {
            System.out.println("Customer username already exists.");
        } else {
            users.put(username, password);
            userList.add(new User(username, "customer"));
            System.out.println("Customer registered successfully.");
        }
    }

    // Sign up for general users (default role: "user")
    public void signUp() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = sc.nextLine();
        System.out.println("Enter password:");
        String password = sc.nextLine();
        if (users.containsKey(username)) {
            System.out.println("Username already exists.");
        } else {
            users.put(username, password);
            userList.add(new User(username, "user"));
            System.out.println("User registered successfully.");
        }
    }

    // Authenticate the user (admin, customer, or general user)
    public User authenticate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = sc.nextLine();
        System.out.println("Enter password:");
        String password = sc.nextLine();

        
        if (users.containsKey(username) && users.get(username).equals(password)) {
            // Find the user and return it
            return userList.stream()
                    .filter(user -> user.getUsername().equals(username))
                    .findFirst()
                    .orElse(null);  
        }
        System.out.println("failed to Login.");
        return null;
    }

    // Display all users (admins, customers, and general users)
    public void showUsers() {
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
