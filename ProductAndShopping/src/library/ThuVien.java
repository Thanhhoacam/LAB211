package library;

import model.Fruit;
import model.Order;
import java.util.ArrayList;
import java.util.Hashtable;

import view.Validation;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Thanh
 */
public class ThuVien {

    Validation val = new Validation();

    public int generateID(ArrayList<Fruit> list_F) {
        int id = 0;
        if (list_F.isEmpty()) {
            return 1;
        } else {
            for (Fruit fruit : list_F) {
                if (fruit.getId() == list_F.size() - 1) {
                    id = fruit.getId();
                }
            }
        }
        return id;
    }

    public void createFruit(ArrayList<Fruit> list_F) {
        int id = generateID(list_F);
        String name = val.getString("Enter fruit name: ");
        double price = val.getDouble("Enter price: ");

        int quantity = val.getInt("Enter quantity: ", 1, 100);

        String origin = val.getString("Enter origin: ");
        list_F.add(new Fruit(id, name, price, quantity, origin));

    }
//| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |  	
//           1 		Coconut	      Vietnam	      2$
//           2 		Orange		US		3$
//           3 		Apple		Thailand	4$
//           4 		Grape		France	      6$

    public void displayFruit(ArrayList<Fruit> list_F) {
        System.out.println("List of Fruit: ");
        String format = "| %-12s | %-17s | %-13s | %-13s |\n";
        System.out.printf(format, "++ Item ++", "++ Fruit Name ++", "++ Origin ++", "++ Price ++");
        for (Fruit fruit : list_F) {

            System.out.printf(format, fruit.getId(), fruit.getName(), fruit.getOrigin(), fruit.getPrice());

        }
    }

    public void shopping(ArrayList<Fruit> list_F, Hashtable<String, ArrayList<Order>> ht) {
        displayFruit(list_F);
        String name = val.getString("Enter fruit name: ");
        int quantityBuy = 0;
        ArrayList<Order> list_O = new ArrayList<>(); // list for order
        for (Fruit fruit : list_F) {
            if (name.equals(fruit.getName())) { // find fruit in list Fruits
                quantityBuy = val.getInt("Enter quantity: ", 0, 1000);
                while (true) {

                    if ((fruit.getQuantity() - quantityBuy) < 0) {
                        System.err.println("we only have " + fruit.getQuantity());
                        quantityBuy = val.getInt("Enter quantity: ", 0, 1000);

                    } else {
                        fruit.setQuantity(fruit.getQuantity() - quantityBuy);
                        break;
                    }
                }

                int id = fruit.getId();

                double price = fruit.getPrice();

                list_O.add(new Order(id, name, quantityBuy, price));
                displayListOrder(list_O);
                String customer = val.getName("Enter your name: ");
                ht.put(customer, list_O);
                System.out.println("Add successfully");
            }
        }

    }
//Product | Quantity | Price | Amount
// Coconut     3	 2$	6$
//Total: 6$

    private void displayListOrder(ArrayList<Order> list_O) {
        double amount = 0;
        String format = "| %-5s | %-14s | %-9s | %-6s |\n";
        System.out.printf(format, "Product", "Quantity", "Price", "Amount");
        for (Order order : list_O) {
            amount += order.getPrice() * order.getQuantity();

            System.out.printf(format, order.getName(), order.getQuantity(), order.getPrice(), amount);

        }
        System.out.println("Total: " + amount + "$");
    }

    public void viewListOrder(Hashtable<String, ArrayList<Order>> ht) {
        if (ht.isEmpty()) {
            return;
        }
        for (String name : ht.keySet()) {
            System.out.println("Customer: " + name);
            ArrayList<Order> array_o = ht.get(name);
            displayListOrder(array_o);
        }
    }
}
