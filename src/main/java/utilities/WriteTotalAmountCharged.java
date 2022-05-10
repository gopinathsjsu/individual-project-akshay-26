package utilities;

import com.project.card.CardList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Map;

import com.google.gson.Gson;
import com.project.card.CardList;
import com.project.category.Category;
import com.project.category.CategoryLimit;
import com.project.item.Item;
import com.project.item.ItemList;
import com.project.mapping.ItemCategory;
import com.project.order.OrderList;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Map;

public class WriteTotalAmountCharged {

    public static void writeTotalAmountCharged(String cardChargedfileName, CardList card, ItemList item) {
        DecimalFormat df = new DecimalFormat("0.00");

        try {
            BufferedWriter bw= new BufferedWriter(new FileWriter( cardChargedfileName, true));
            PrintWriter out1 = new PrintWriter(bw);
            String message = "Item,Quantity, Price";
            System.out.println(message);
            out1.println(message);
            Double total = 0.0;
            for(Map.Entry<String,Item> itemVal: item.getCart().entrySet() ) {
                message = itemVal.getValue().getItemName() + " " + itemVal.getValue().getQuantity() + " " + itemVal.getValue().getPrice()*itemVal.getValue().getQuantity();
                System.out.println(message);
                out1.println(message);
                total = total + itemVal.getValue().getPrice()* itemVal.getValue().getQuantity();

            }
            out1.println("Total Amount: "+total.toString());
            out1.flush();
        } catch (IOException e) {
            System.out.println("EXCEPTION caught: for deleteIfExists:"+cardChargedfileName);
        }
    }
}
