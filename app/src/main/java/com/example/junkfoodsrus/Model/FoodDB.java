package com.example.junkfoodsrus.Model;

import com.example.junkfoodsrus.R;

import java.util.HashMap;

public class FoodDB {
    public static double totalPrice;

    // where all the default food is stored
    public static HashMap<Integer, Food> food = new HashMap<Integer, Food>();

    // where all the ordered foods will be stored
    public static HashMap<Food, Integer> orderCart = new HashMap<Food,Integer>();

    static{
        food.put(1, new Food(1, R.drawable.lebigmac, "Le Big Mac", 5.50, "A Big Mac's a Big Mac but they call it Le Big Mac"));
        food.put(2, new Food(2, R.drawable.royale, "Royale With Cheese", 6.50, "You know what they call a quarter pounder with Cheese?"));
        food.put(3, new Food(3, R.drawable.kahuna, "Big Kahuna Burger", 7.00, "That's that Hawaiian burger joint"));
        food.put(4, new Food(4, R.drawable.whitecastle, "White Castle Burger", 4.50, "Just thinking about those teeny little White Castle burgers"));
        food.put(5, new Food(5, R.drawable.wrap, "Twista", 6.49, "Crazy spicy wraps!"));
        food.put(6, new Food(6, R.drawable.ice, "Ice Cream", 1.49, "For all you dessert lovers!"));
        food.put(7, new Food(7, R.drawable.fries, "Fries", 2.49, "High in calories but sacrifices must be made for enjoyment!"));
        food.put(8, new Food(8, R.drawable.nuggets, "Nuggets", 3.49, "Our best selling chicken nuggets!"));
        food.put(9, new Food(9, R.drawable.hash, "Hash Brown", 1.49, "For all you potato lovers!"));
        food.put(10, new Food(10, R.drawable.dog, "Hot Dog", 3.99, "Better than your usual hot dogs!"));
        food.put(11, new Food(11, R.drawable.snack, "Snack Pack", 7.49, "Though the snack pack phase is over, this one will still hit the spot!"));
        food.put(12, new Food(12, R.drawable.coke, "Coke", 2.99, "Classic coke is where it's at!"));
        food.put(13, new Food(13, R.drawable.diet, "Diet Coke", 2.99, "Just like coke except diet!"));
        food.put(14, new Food(14, R.drawable.pepsi, "Pepsi", 2.99, "Fake coke!"));
        food.put(15, new Food(15, R.drawable.orange, "Fanta", 2.99, "Orange coke!"));
    }
}
