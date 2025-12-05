/*
* Name: Angelo Burke 
* Date: Dec 4, 2025 
* Assignment: SDC330 Course Project - Class Implementation
* Description: Main application used to demonstrate and test all classes. 
*/ 
import java.util.Scanner; 
import java.util.List; 
public class App {  
public static void main(String[] args) { 
    Scanner scanner = new Scanner(System.in); 
    CustomerDatabase customerDB = new CustomerDatabase(); 
   System.out.println("Welcome to Angelo's Pizza!\n"); 

    while (true) { 
        System.out.println("Select an option:"); 
        System.out.println("1. Place an Order"); 
        System.out.println("2. Manage Customers"); 
        System.out.println("3. Exit"); 
        System.out.print("Choice: "); 
        int mainChoice = scanner.nextInt(); 
        scanner.nextLine();
 
        if (mainChoice == 3) break; 
 
        switch (mainChoice) { 
            case 1:
                placeOrder(scanner, customerDB); 
                break; 
            case 2: 
                manageCustomers(scanner, customerDB); 
                break; 
            default: 
                System.out.println("Invalid choice."); 
        } 
    } 
 
    scanner.close(); 
    System.out.println("Thank you for using Angelo's Pizza!"); 
} 
 
private static void placeOrder(Scanner scanner, CustomerDatabase customerDB) { 
    // Menu with different kind of pizzas 
    Menu menu = new Menu(10); 
    menu.addPizza(new Pizza("Cheese Pizza", 12.99, "Large")); 
    menu.addPizza(new Pizza("Pepperoni Pizza", 13.99, "Large")); 
    menu.addPizza(new Pizza("Meat Lovers", 15.99, "Medium")); 
    menu.addPizza(new Pizza("BBQ Chicken", 14.50, "Large")); 
    menu.addPizza(new Pizza("Hawaiian", 11.00, "Medium")); 
    menu.addPizza(new Pizza("Mix & Match", 6.99, "Small")); 
    menu.showMenu(); 
 
    // Ask for customer information 
    System.out.print("Enter your first name: "); 
    String firstName = scanner.nextLine(); 
    System.out.print("Enter your last name: "); 
    String lastName = scanner.nextLine(); 
    System.out.print("Enter your email: "); 
    String email = scanner.nextLine(); 
 
    // Check if customer exists 
    Customer customer = customerDB.findCustomer(email); 
    if (customer == null) { 
        System.out.print("Enter your street address: "); 
        String street = scanner.nextLine(); 
        System.out.print("Enter your city: "); 
        String city = scanner.nextLine(); 
        System.out.print("Enter your state: "); 
        String state = scanner.nextLine(); 
        Address address = new Address(street, city, state); 
        customer = new Customer(firstName, lastName, email, address); 
        customerDB.addCustomer(customer); 
    } else { 
        System.out.println("Welcome back, " + customer.getFullName() + "!"); 
    } 
 
    Cart cart = new Cart(10); 
    System.out.println("\nEnter the numbers of the pizzas you want to order. Type 0 when finished."); 
    while (true) { 
        System.out.print("Pizza number: "); 
        int choice = scanner.nextInt(); 
        if (choice == 0) break; 
        else if (choice < 1 || choice > menu.getPizzas().length) System.out.println("Invalid choice, try again."); 
        else { 
            cart.addPizza(menu.getPizzas()[choice - 1]); 
            System.out.println(menu.getPizzas()[choice - 1].getName() + " added to cart."); 
        } 
    } 
    Order order = new Order(customer, cart); 
 
    // Display order summary 
    System.out.println("\n" + order); 
} 
 
private static void manageCustomers(Scanner scanner, CustomerDatabase db) { 
    while (true) { 
        System.out.println("\n--- Manage Customers ---"); 
        System.out.println("1. List All Customers"); 
        System.out.println("2. Search Customer by Email"); 
        System.out.println("3. Update Customer"); 
        System.out.println("4. Delete Customer"); 
        System.out.println("5. Back to Main Menu"); 
        System.out.print("Choice: "); 
        int choice = scanner.nextInt(); 
        scanner.nextLine();  
 
        switch (choice) { 
            case 1:  
                List<Customer> all = db.getAllCustomers(); 
                for (Customer c : all) System.out.println(c); 
                break; 
            case 2: 
                System.out.print("Enter email to search: "); 
                String searchEmail = scanner.nextLine(); 
                Customer found = db.findCustomer(searchEmail); 
                if (found != null) System.out.println(found); 
                else System.out.println("Customer not found."); 
                break; 
            case 3: 
                System.out.print("Enter email to update: "); 
                String email = scanner.nextLine(); 
                Customer toUpdate = db.findCustomer(email); 
                if (toUpdate != null) { 
                    System.out.print("New first name: "); 
                    toUpdate.setFirstName(scanner.nextLine()); 
                    System.out.print("New last name: "); 
                    toUpdate.setLastName(scanner.nextLine()); 
                    System.out.print("New street: "); 
                    String street = scanner.nextLine(); 
                    System.out.print("New city: "); 
                    String city = scanner.nextLine(); 
                    System.out.print("New state: "); 
                    String state = scanner.nextLine(); 
                    toUpdate.setAddress(new Address(street, city, state)); 
                    db.updateCustomer(toUpdate); 
                    System.out.println("Customer updated."); 
                } else System.out.println("Customer not found."); 
                break; 
            case 4: 
                System.out.print("Enter email to delete: "); 
                String delEmail = scanner.nextLine(); 
                db.deleteCustomer(delEmail); 
                System.out.println("Customer deleted."); 
                break; 
            case 5: 
                return; 
            default: 
                System.out.println("Invalid choice."); 
        } 
    } 
} 
} 