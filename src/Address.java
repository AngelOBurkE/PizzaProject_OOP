/*
* Name: Angelo Burke 
* Date: Dec 4, 2025 
* Assignment: SDC330 Course Project - Class Implementation
* Description: Represents a customer address. 
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
  
    public String getStreet() { return street; } 
    public String getCity() { return city; } 
    public String getState() { return state; } 

    @Override  
    public String toString() {  
        return street + ", " + city + ", " + state;  
    }  
} 