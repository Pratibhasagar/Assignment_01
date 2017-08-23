package com.tw.vapasi.assignment;

import java.util.HashMap;
import java.util.Map;

public class ShoppingForFruits {

    public static void main(String[] args) {

        HashMap<String, Double> fruitMap = new HashMap<String, Double>();
        fruitMap.putIfAbsent("Apple", (double) 100);
        fruitMap.putIfAbsent("Orange", (double) 80);
        fruitMap.putIfAbsent("Banana", (double) 30);
        fruitMap.putIfAbsent("Kiwi ", (double) 120);

        HashMap<String, Double> shoppingList = new HashMap<String, Double>();
        shoppingList.putIfAbsent("Apple", (double) 2);
        shoppingList.putIfAbsent("Orange", 1.5);
        shoppingList.putIfAbsent("Banana", 0.5);
        shoppingList.putIfAbsent("Kiwi", 0.75);

        printReceipt(fruitMap, shoppingList);
    }

    private static void printReceipt(HashMap<String, Double> fruitMap, HashMap<String, Double> shoppingList) {

        Double sumTotal = (double) 0;
        boolean matchFound = false;

        System.out.println("Fruit\tQty(kg)\tAmount");
        System.out.println("===========================");

        for (Map.Entry<String, Double> item : shoppingList.entrySet()) {
            for (Map.Entry<String, Double> fruit : fruitMap.entrySet()) {
                if (item.getKey().compareToIgnoreCase(fruit.getKey()) == 0) {
                    System.out.println(item.getKey().toUpperCase() + "\t" +
                            item.getValue() + " \t" +
                            (fruit.getValue()) * item.getValue());
                    sumTotal += fruit.getValue() * item.getValue();
                    matchFound = true;
                    break;
                }
            }
            if (matchFound == false) {
                System.out.println(item.getKey().toUpperCase() + " is not available today. :(");
            } else {
                // Reset the flag
                matchFound = false;
            }
        }
        System.out.println("===========================");
        System.out.println("Total amount  \t" + sumTotal);
    }
}
