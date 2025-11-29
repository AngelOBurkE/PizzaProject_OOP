/** 
Name: Angelo Burke 
Date: Nov 29, 2025 
Assignment: SDC330 Course Project - Class Implementation
Description: Represents a customer with personal information to help with the order. 
*/ 
public class Customer { 
private String firstName; 
private String lastName; 
private String email; 
private Address address; 
public Customer(String firstName, String lastName, String email, Address address) { 
    this.firstName = firstName; 
    this.lastName = lastName; 
    this.email = email; 
    this.address = address; 
} 
 
public String getFullName() { 
    return firstName + " " + lastName; 
} 
 
@Override 
public String toString() { 
    return "Name: " + getFullName() + "\n" + 
           "Email: " + email + "\n" + 
           "Address: " + address + "\n"; 
} 
} 