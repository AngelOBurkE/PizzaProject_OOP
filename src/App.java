/** 
Name: Angelo Burke 
Date: Nov 29, 2025 
Assignment: SDC330 Course Project - Class Implementation
Description: Main application used to demonstrate and test all classes. 
*/ 
import java.util.Scanner; 
public class App { 
public static void main(String[] args) { 
    Scanner scanner = new Scanner(System.in); 
    System.out.println("Welcome to Angelo's Pizza!\n"); 
 
    // Menu with different kind of pizza's
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
    System.out.print("Enter your street address: "); 
    String street = scanner.nextLine(); 
    System.out.print("Enter your city: "); 
    String city = scanner.nextLine(); 
    System.out.print("Enter your state: "); 
    String state = scanner.nextLine(); 
    Address address = new Address(street, city, state); 
    Customer customer = new Customer(firstName, lastName, email, address); 
    Cart cart = new Cart(10); 
    System.out.println("\nEnter the numbers of the pizzas you want to order. Type 0 when finished."); 
    while (true) { 
        System.out.print("Pizza number: "); 
        int choice = scanner.nextInt(); 
        if (choice == 0) { 
            break; 
        } else if (choice < 1 || choice > menu.getPizzas().length) { 
            System.out.println("Invalid choice, try again."); 
        } else { 
            cart.addPizza(menu.getPizzas()[choice - 1]); 
            System.out.println(menu.getPizzas()[choice - 1].getName() + " added to cart."); 
        } 
    }  
    Order order = new Order(customer, cart); 
 
    // Display order summary 
    System.out.println("\n" + order); 
    scanner.close(); 
} 
} 