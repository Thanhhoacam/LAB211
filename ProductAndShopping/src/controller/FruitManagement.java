/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import library.ThuVien;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import model.Fruit;
import model.Order;

import view.Menu;
import view.Validation;

/**
 *
 * @author Thanh
 */
public class FruitManagement extends Menu {

    ArrayList<Fruit> list_F = new ArrayList<>();
    Hashtable<String, ArrayList<Order>> ht = new Hashtable<>();
    ThuVien tv = new ThuVien();
    private final Validation val = new Validation();

    static String[] menu = {"Create fuit",
        "View Order",
        "Shopping",
        "Exit"
    };

    public FruitManagement() throws IOException {
        super("======== Fruit program ========", menu);

    }

    @Override
    public void execute(int choice) {
        switch (choice) {

            case 1:
                tv.createFruit(list_F);

                break;

            case 2:

                tv.viewListOrder(ht);

                break;

            case 3:
                tv.shopping(list_F, ht);
                break;

            case 4:
                System.out.println("Exit successfully");
                System.exit(0);

            default:
        }
    }

    // function 
}
