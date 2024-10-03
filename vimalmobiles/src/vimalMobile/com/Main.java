package vimalMobile.com;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Inventory store = new Inventory();
    private static final String AD = "vimal";
    private static final String ADMIN_PASSWORD = "vim";
    private static final login loginSystem = new login();

    public static void main(String[] args) throws usererror {
        Scanner sc = new Scanner(System.in);
        User currentUser;

        loginSystem.addAdmin(AD, ADMIN_PASSWORD);
        System.out.println("***** Welcome to MobileInventoryTracker ******");

        while (true) {
            System.out.println("\n\n1. Sign up");
            System.out.println("2. Login");
            System.out.println("3. Show Users");
            System.out.println("4. Exit");
            int opt = sc.nextInt();
            sc.nextLine(); 
            switch (opt) {
                case 1:
                    signUpWithOTP(sc);
                    break;
                case 2:
                    currentUser = loginSystem.authenticate();
                    if (currentUser != null) {
                        if ("admin".equals(currentUser.getRole())) {
                            adminActions(sc, currentUser);
                        } else if ("user".equals(currentUser.getRole())) {
                            customerActions(sc, currentUser);
                        } else if ("customer".equals(currentUser.getRole())) {
                            customerActions(sc, currentUser);
                        }
                    }
                    break;
                case 3:
                    loginSystem.showUsers();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

  
    static void signUpWithOTP(Scanner sc) {
        System.out.println("Enter your username:");
        String username = sc.nextLine();
        System.out.println("Enter your password:");
        String password = sc.nextLine();

        // Generate and display OTP
        int otp = generateOTP();
        System.out.println("OTP sent to your email/phone: " + otp); // Simulate OTP sending

        // Ask for OTP input
        System.out.println("Enter the OTP:");
        int enteredOTP = sc.nextInt();
        sc.nextLine();

        // Check if OTP matches
        if (otp == enteredOTP) {
            System.out.println("OTP verified successfully!");

   
            System.out.println("Do you want to sign up as a customer? (yes/no)");
            String roleOption = sc.nextLine();

            if (roleOption.equalsIgnoreCase("yes")) {
                loginSystem.addCustomer(username, password);
            } else {
                loginSystem.signUp();
            }

            System.out.println("Sign-up successful!");
        } else {
            System.out.println("Invalid OTP. Sign-up failed.");
        }
    }

    
    static int generateOTP() {
        Random rand = new Random();
        return 1000 + rand.nextInt(9000);
    }

    static void adminActions(Scanner sc, User admin) throws usererror {
        while (true) {
            System.out.println(" Welcome to Admin Menu:");
            System.out.println("1. Add ");
            System.out.println("2. Update ");
            System.out.println("3. Search ");
            System.out.println("4. Remove ");
            System.out.println("5. Show All ");
            System.out.println("6. Exit");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    mobile m = new mobile();
                    System.out.println("Enter the BrandName:");
                    m.setBrandname(sc.nextLine());
                    System.out.println("Enter the generation:");
                    m.setGeneration(sc.nextLine());
                    System.out.println("Enter the Model:");
                    m.setModel_name(sc.nextLine());
                    System.out.println("Enter the Price:");
                    m.setPrice(sc.nextInt());
                    sc.nextLine();
                    store.add(m);
                    break;
                case 2:
                    store.show();
                    System.out.println("Enter the id:");
                    String id = sc.nextLine();
                    store.update(id);
                    break;
                case 3:
                    store.show();
                    System.out.println("Enter the id:");
                    id = sc.nextLine();
                    try {
                        mobile mToSearch = store.search(id);
                        if (mToSearch != null) {
                            System.out.println(mToSearch);
                        } else {
                            throw new usererror("ID not found");
                        }
                    } catch (usererror e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    store.show();
                    System.out.println("Enter the id:");
                    id = sc.nextLine();
                    store.remove(id);
                    break;
                case 5:
                    store.show();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

   

    static void customerActions(Scanner sc, User customer) {
        System.out.println("Customer actions will go here.");
        while (true) {
            System.out.println("\n\ncustomer cart");
            System.out.println("1. Search mobiles");
            System.out.println("2. Show All Products");
            System.out.println("3. buy");
            System.out.println("4. Exit");
            int option = sc.nextInt();
            sc.nextLine(); // Consume newline after integer input

            switch (option) {
                case 1:
                    System.out.println("Enter the product ID to search:");
                    String id = sc.nextLine();
                    mobile m = store.search(id);
                    
                    
                    if (m != null) {
                        System.out.println("Product found: " + m);
                    } else {
                        System.out.println("Product with ID " + id + " not found.");
                    }
                    break;
                    
                case 2:
                    store.show(); 
                    break;
                    
                case 3:
                    store.show();
                    
                    System.out.println("\n\n\nEnter the id to buy:");
                    id = sc.nextLine();
                    store.remove(id);
                    System.out.println(" Thanks for purchasing\n\n");
                    break;
              
                    
                case 4:
                    System.out.println("Exiting user menu...");
                    return;
                    
                    
               
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
        
    }

