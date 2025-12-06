/* 
* Name: Angelo Burke 
* Date: Dec 5, 2025 
* Assignment: SDC330 Course Project - Class Implementation
* Description: Represents a customer with personal information to help with the order. 
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
 
public String getFirstName() { return firstName; } 
public void setFirstName(String firstName) { this.firstName = firstName; } 
public String getLastName() { return lastName; } 
public void setLastName(String lastName) { this.lastName = lastName; } 
public String getEmail() { return email; } 
public void setEmail(String email) { this.email = email; } 
public Address getAddress() { return address; } 
public void setAddress(Address address) { this.address = address; } 
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