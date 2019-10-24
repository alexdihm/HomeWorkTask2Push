package com.example.junkfoodsrus.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.junkfoodsrus.Adapters.CartAdapter;
import com.example.junkfoodsrus.Model.Food;
import com.example.junkfoodsrus.Model.FoodDB;
import com.example.junkfoodsrus.R;

import java.util.HashMap;

public class CartActivity extends AppCompatActivity {

    TextView cartPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartPrice = findViewById(R.id.cart_price);
        cartPrice.setText(String.format("$%.2f", FoodDB.totalPrice));
        HashMap<Food, Integer> orderCart = FoodDB.orderCart;

        CartAdapter foodAdapter = new CartAdapter(orderCart);

        // initialises the recyclerview for the cart activity page
        RecyclerView view = findViewById(R.id.recyclerview_cart);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        view.setLayoutManager(layoutManager);

        view.setAdapter(foodAdapter);
    }

    // returns to main activity after the return button is clicked
    public void onReturnButtonClick(View v){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
