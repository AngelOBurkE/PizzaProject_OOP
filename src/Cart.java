/*
* Name: Angelo Burke 
* Date: Dec 5, 2025 
* Assignment: SDC330 Course Project - Class Implementation
* Description: Stores pizzas the customer wants to order. 
*/
public class Cart { 
private Pizza[] items; 
private int count; 
public Cart(int maxItems) { 
    items = new Pizza[maxItems]; 
    count = 0; 
} 
 
public void addPizza(Pizza pizza) { 
    if (count < items.length) { 
        items[count] = pizza; 
        count++; 
    } else { 
        System.out.println("Cart is full!"); 
    } 
} 
 
public void removePizza(int index) { 
    if (index >= 0 && index < count) { 
        for (int i = index; i < count - 1; i++) { 
            items[i] = items[i + 1]; 
        } 
        items[count - 1] = null; 
        count--; 
    } else { 
        System.out.println("Invalid index."); 
    } 
} 
 
public Pizza[] getItems() { 
    Pizza[] current = new Pizza[count]; 
    for (int i = 0; i < count; i++) { 
        current[i] = items[i]; 
    } 
    return current; 
} 
 
public double getTotal() { 
    double sum = 0; 
    for (int i = 0; i < count; i++) { 
        sum += items[i].getPrice(); 
    } 
    return sum; 
} 
 
@Override 
public String toString() { 
    String s = "Cart Contents:\n"; 
    for (int i = 0; i < count; i++) { 
        s += items[i] + "\n"; 
    } 
    s += "Total: $" + String.format("%.2f", getTotal()); 
    return s; 
} 
} 