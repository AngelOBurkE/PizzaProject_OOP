/*
* Name: Angelo Burke 
* Date: Dec 4, 2025 
* Assignment: SDC330 Course Project - Class Implementation
* Description: Handles Add, Update, Search, Delete operations for customers. 
*/ 
import java.io.*; 
import java.util.ArrayList; 
import java.util.List; 
public class CustomerDatabase { 
    private static final String FILE_NAME = "customers.txt"; 

// Save a new customer 
public void addCustomer(Customer customer) { 
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) { 
        writer.write(serializeCustomer(customer)); 
        writer.newLine(); 
    } catch (IOException e) { 
        System.out.println("Error adding customer: " + e.getMessage()); 
    } 
} 
 
public List<Customer> getAllCustomers() { 
    List<Customer> customers = new ArrayList<>(); 
    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) { 
        String line; 
        while ((line = reader.readLine()) != null) { 
            customers.add(deserializeCustomer(line)); 
        } 
    } catch (FileNotFoundException e) { 
        // File may not exist yet 
    } catch (IOException e) { 
        System.out.println("Error reading customers: " + e.getMessage()); 
    } 
    return customers; 
} 
 
// Find customer by email 
public Customer findCustomer(String email) { 
    for (Customer c : getAllCustomers()) { 
        if (c.getEmail().equalsIgnoreCase(email)) { 
            return c; 
        } 
    } 
    return null; 
} 
 
// Update customer info 
public void updateCustomer(Customer updated) { 
    List<Customer> customers = getAllCustomers(); 
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) { 
        for (Customer c : customers) { 
            if (c.getEmail().equalsIgnoreCase(updated.getEmail())) { 
                writer.write(serializeCustomer(updated)); 
            } else { 
                writer.write(serializeCustomer(c)); 
            } 
            writer.newLine(); 
        } 
    } catch (IOException e) { 
        System.out.println("Error updating customer: " + e.getMessage()); 
    } 
} 
 
// Delete customer by email 
public void deleteCustomer(String email) { 
    List<Customer> customers = getAllCustomers(); 
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) { 
        for (Customer c : customers) { 
            if (!c.getEmail().equalsIgnoreCase(email)) { 
                writer.write(serializeCustomer(c)); 
                writer.newLine(); 
            } 
        } 
    } catch (IOException e) { 
        System.out.println("Error deleting customer: " + e.getMessage()); 
    } 
} 
 
// Helper: convert customer to string for storage 
private String serializeCustomer(Customer c) { 
    return c.getFirstName() + ";" + c.getLastName() + ";" + c.getEmail() + ";" + 
           c.getAddress().getStreet() + ";" + c.getAddress().getCity() + ";" + c.getAddress().getState(); 
} 
// Helper: convert stored string back to customer
private Customer deserializeCustomer(String line) { 
    String[] parts = line.split(";"); 
    Address addr = new Address(parts[3], parts[4], parts[5]); 
    return new Customer(parts[0], parts[1], parts[2], addr); 
} 
} 