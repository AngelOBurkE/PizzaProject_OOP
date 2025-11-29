/*
Name: Angelo Burke 
Date: Nov 29, 2025 
Assignment: SDC330 Course Project - Class Implementation
Description: Represents an order with customer, cart, tax, and estimated delivery. 
*/ 
public class Order { 
private Customer customer; 
private Cart cart; 
private double taxRate = 0.07; 
private int estimatedDeliveryMinutes = 30; 
public Order(Customer customer, Cart cart) { 
    this.customer = customer; 
    this.cart = cart; 
} 
 
public double getTax() { 
    return cart.getTotal() * taxRate; 
} 
 
public double getFinalTotal() { 
    return cart.getTotal() + getTax(); 
} 
 
@Override 
public String toString() { 
    return "===== ORDER SUMMARY =====\n" + 
           customer + 
           cart + "\n" + 
           "Tax: $" + String.format("%.2f", getTax()) + "\n" + 
           "Final Total: $" + String.format("%.2f", getFinalTotal()) + "\n" + 
           "Estimated Delivery Time: " + estimatedDeliveryMinutes + " minutes\n"; 
} 
}  