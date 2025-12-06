/*
* Name: Angelo Burke 
* Date: Dec 5, 2025 
* Assignment: SDC330 Course Project - Class Implementation
* Description: Handles Add, Update, Search, Delete operations for customers. 
*/ 
import java.util.ArrayList; 
public class CustomerDatabase {   
    private ArrayList<Customer> customers;   
    public CustomerDatabase() { 
        customers = new ArrayList<>(); 
    } 
  
    // ADD 
    public void addCustomer(Customer c) { 
        customers.add(c); 
        System.out.println("Customer added successfully!"); 
    } 
  
    // SEARCH by email 
    public Customer searchCustomer(String email) { 
        for (Customer c : customers) { 
            if (c.getEmail().equalsIgnoreCase(email)) { 
                return c; 
            } 
        } 
        return null; 
    } 
  
    // UPDATE email 
    public boolean updateCustomerEmail(String oldEmail, String newEmail) { 
        Customer c = searchCustomer(oldEmail); 
        if (c != null) { 
            // Since email is private, we modify through reflection of fields 
            try { 
                java.lang.reflect.Field f = Customer.class.getDeclaredField("email"); 
                f.setAccessible(true); 
                f.set(c, newEmail); 
            } catch (Exception e) { 
                System.out.println("Update failed."); 
                return false; 
            } 
            return true; 
        } 
        return false; 
    } 
  
    // DELETE 
    public boolean deleteCustomer(String email) { 
        Customer c = searchCustomer(email); 
        if (c != null) { 
            customers.remove(c); 
            return true; 
        } 
        return false; 
    } 
 
    // Show all (optional) 
    public void listAll() { 
        System.out.println("\n--- All Customers ---"); 
        for (Customer c : customers) { 
            System.out.println(c); 
        } 
        System.out.println("----------------------\n"); 
    } 
} 