/*
* Name: Angelo Burke 
* Date: Dec 5, 2025 
* Assignment: SDC330 Course Project - Class Implementation
* Description: Main application used to demonstrate and test all classes. 
*/ 
import java.util.Scanner;   
public class App { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        CustomerDatabase db = new CustomerDatabase(); 
        while (true) {   
            System.out.println("\n===== ANGELO'S PIZZA ====="); 
            System.out.println("1. Place a Pizza Order"); 
            System.out.println("2. Add Customer Record"); 
            System.out.println("3. Search Customer Record"); 
            System.out.println("4. Update Customer Email"); 
            System.out.println("5. Delete Customer Record"); 
            System.out.println("6. Show All Customers"); 
            System.out.println("0. Exit"); 
            System.out.print("Choose an option: "); 
            int option = scanner.nextInt(); 
            scanner.nextLine();   
            switch (option) { 
                case 1: 
                    placeOrder(scanner); 
                    break;   
                case 2: 
                    addCustomer(scanner, db); 
                    break; 
                case 3: 
                    searchCustomer(scanner, db); 
                    break;  
                case 4: 
                    updateCustomer(scanner, db); 
                    break;   
                case 5: 
                    deleteCustomer(scanner, db); 
                    break;   
                case 6: 
                    db.listAll(); 
                    break;   
                case 0: 
                    System.out.println("Thanks for using Angelo's Pizza!"); 
                    scanner.close(); 
                    return; 
  
                default: 
                    System.out.println("Invalid option. Try again."); 
            } 
        } 
    } 
  
    private static void placeOrder(Scanner scanner) { 
          System.out.println("\nWelcome to Angelo's Pizza!\n"); 
          Menu menu = new Menu(10); 
        menu.addPizza(new Pizza("Cheese Pizza", 12.99, "Large")); 
        menu.addPizza(new Pizza("Pepperoni Pizza", 13.99, "Large")); 
        menu.addPizza(new Pizza("Meat Lovers", 15.99, "Medium")); 
        menu.addPizza(new Pizza("BBQ Chicken", 14.50, "Large")); 
        menu.addPizza(new Pizza("Hawaiian", 11.00, "Medium")); 
        menu.addPizza(new Pizza("Mix & Match", 6.99, "Small")); 
        menu.showMenu(); 
  
        // Customer info 
        System.out.print("Enter your first name: "); 
        String first = scanner.nextLine();  
        System.out.print("Enter your last name: "); 
        String last = scanner.nextLine(); 
        System.out.print("Enter your email: "); 
        String email = scanner.nextLine(); 
        System.out.print("Enter your street address: "); 
        String street = scanner.nextLine(); 
        System.out.print("Enter your city: "); 
        String city = scanner.nextLine(); 
        System.out.print("Enter your state: "); 
        String state = scanner.nextLine(); 
        Address address = new Address(street, city, state); 
        Customer customer = new Customer(first, last, email, address); 
        Cart cart = new Cart(10); 
        System.out.println("\nEnter pizza numbers to add to cart. Type 0 to finish."); 
        while (true) { 
            System.out.print("Pizza number: "); 
            int choice = scanner.nextInt();   
            if (choice == 0) break; 
            if (choice < 1 || choice > menu.getPizzas().length) { 
                System.out.println("Invalid choice."); 
            } else { 
                cart.addPizza(menu.getPizzas()[choice - 1]); 
                System.out.println(menu.getPizzas()[choice - 1].getName() + " added."); 
            } 
        } 
        Order order = new Order(customer, cart); 
        System.out.println("\n" + order);   
        scanner.nextLine();
    } 

    private static void addCustomer(Scanner scanner, CustomerDatabase db) {  
        System.out.print("First name: "); 
        String first = scanner.nextLine();   
        System.out.print("Last name: "); 
        String last = scanner.nextLine();   
        System.out.print("Email: "); 
        String email = scanner.nextLine();   
        System.out.print("Street: "); 
        String street = scanner.nextLine();  
        System.out.print("City: "); 
        String city = scanner.nextLine();   
        System.out.print("State: "); 
        String state = scanner.nextLine();   
        Address addr = new Address(street, city, state); 
        Customer c = new Customer(first, last, email, addr);   
        db.addCustomer(c); 
    } 

    private static void searchCustomer(Scanner scanner, CustomerDatabase db) {   
        System.out.print("Enter email to search: "); 
        String email = scanner.nextLine();   
        Customer c = db.searchCustomer(email);   
        if (c == null) { 
            System.out.println("Customer not found."); 
        } else { 
            System.out.println("\nCustomer Found:\n" + c); 
        } 
    } 

    private static void updateCustomer(Scanner scanner, CustomerDatabase db) {   
        System.out.print("Enter current email: "); 
        String oldEmail = scanner.nextLine();   
        System.out.print("Enter new email: "); 
        String newEmail = scanner.nextLine();   
        boolean success = db.updateCustomerEmail(oldEmail, newEmail);   
        if (success) { 
            System.out.println("Email updated successfully."); 
        } else { 
            System.out.println("Update failed. Customer not found."); 
        } 
    } 

    private static void deleteCustomer(Scanner scanner, CustomerDatabase db) {   
        System.out.print("Enter email to delete: "); 
        String email = scanner.nextLine();   
        boolean success = db.deleteCustomer(email);   
        if (success) { 
            System.out.println("Customer deleted."); 
        } else { 
            System.out.println("Customer not found."); 
        } 
    } 
}  