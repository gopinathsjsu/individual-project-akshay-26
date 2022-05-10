package com.project.item;

import java.util.HashMap;
import java.util.Map;

public class ItemList {
    Map<String, Item> itemlist;

    Map<String, Item> cart;
    public ItemList() {

        itemlist = new HashMap<>();
        cart = new HashMap<>();
    }

    //overloading add method
    public void add(Item item) {

        itemlist.put(item.getItemName().toLowerCase(), item);

    }
    public void addToCart(Item item) {

        cart.put(item.getItemName().toLowerCase(), item);

    }

    public Map<String, Item> getItemlist() {
        return itemlist;
    }
    public Map<String, Item> getCart() {
        return cart;
    }

    public double getCharge(String item) {
        return itemlist.get(item).getPrice();
    }
}
