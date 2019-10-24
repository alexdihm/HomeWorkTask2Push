package com.example.junkfoodsrus.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.junkfoodsrus.Adapters.FoodAdapter;
import com.example.junkfoodsrus.Model.Food;
import com.example.junkfoodsrus.Model.FoodDB;
import com.example.junkfoodsrus.R;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FoodAdapter.onFoodClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        HashMap<Integer, Food> foodMap = FoodDB.food;
        List<Food> foodList = (List) Arrays.asList(foodMap.values().toArray());
        FoodAdapter foodAdapter = new FoodAdapter(this, foodList);

        // initialises the recyclerview for the main activity page
        RecyclerView view = findViewById(R.id.rv_main);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        view.setLayoutManager(layoutManager);
        view.setAdapter(foodAdapter);
    }

    @Override
    public void onFoodClick(int position) {
        Intent intent = new Intent(getApplicationContext(), AddToOrderActivity.class);
        intent.putExtra("id", position + 1);
        startActivity(intent);
    }

    public void onViewOrderClick(View v){
        Intent intent = new Intent(getApplicationContext(), CartActivity.class);
        startActivity(intent);
    }


}
