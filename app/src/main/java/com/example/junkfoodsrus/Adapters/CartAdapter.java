package com.example.junkfoodsrus.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.junkfoodsrus.Model.Food;
import com.example.junkfoodsrus.R;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.FoodViewHolder> {

    private HashMap<Food,Integer> cart;
    private List<Food> cartFoodList;

    public CartAdapter(HashMap<Food,Integer> cart) {
        this.cart = cart;
        cartFoodList = (List) Arrays.asList(cart.keySet().toArray());
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_food_layout, parent, false);
        return new FoodViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food food = cartFoodList.get(position);
        holder.name.setText(food.getName());
        holder.number.setText(String.valueOf(cart.get(food)));
    }

    @Override
    public int getItemCount() {
        return cart.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView number;

        public FoodViewHolder(View v) {
            super(v);
            this.name = (TextView) v.findViewById(R.id.cart_name);
            this.number = (TextView) v.findViewById(R.id.cart_quantity);
        }
    }

}
