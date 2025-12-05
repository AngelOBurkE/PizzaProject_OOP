/*
* Name: Angelo Burke 
* Date: Dec 4, 2025 
* Assignment: SDC330 Course Project - Class Implementation
* Description: Represents a single pizza item. 
*/
public class Pizza { 
private String name; 
private double price; 
private String size; 
public Pizza(String name, double price, String size) { 
    this.name = name; 
    this.price = price; 
    this.size = size; 
} 
 
public String getName() { return name; } 
public double getPrice() { return price; } 
public String getSize() { return size; } 
 
@Override 
public String toString() { 
    return size + " " + name + " - $" + String.format("%.2f", price); 
} 
} 