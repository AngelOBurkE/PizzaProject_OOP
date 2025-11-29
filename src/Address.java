/** 
Name: Angelo Burke 
Date: Nov 29, 2025 
Assignment: SDC330 Course Project - Class Implementation
Description: Represents a customer address. 
*/ 
public class Address { 
private String street; 
private String city; 
private String state; 
public Address(String street, String city, String state) { 
    this.street = street; 
    this.city = city; 
    this.state = state; 
} 
 
@Override 
public String toString() { 
    return street + ", " + city + ", " + state; 
} 
} 