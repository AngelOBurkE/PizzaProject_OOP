/*
* Name: Angelo Burke 
* Date: Dec 4, 2025 
* Assignment: SDC330 Course Project - Class Implementation
* Description: Stores available pizzas and prints the menu. 
*/ 
public class Menu { 
private Pizza[] pizzas; 
private int count; 
public Menu(int maxPizzas) { 
    pizzas = new Pizza[maxPizzas]; 
    count = 0; 
} 
 
public void addPizza(Pizza pizza) { 
    if (count < pizzas.length) { 
        pizzas[count] = pizza; 
        count++; 
    } else { 
        System.out.println("Menu is full, cannot add more pizzas."); 
    } 
} 
 
public Pizza[] getPizzas() { 
    Pizza[] current = new Pizza[count]; 
    for (int i = 0; i < count; i++) { 
        current[i] = pizzas[i]; 
    } 
    return current; 
} 
 
public void showMenu() { 
    System.out.println("\n===== PIZZA MENU ====="); 
    for (int i = 0; i < count; i++) { 
        System.out.println((i+1) + ". " + pizzas[i]); 
    } 
    System.out.println("======================\n"); 
} 
} 