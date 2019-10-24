package com.example.junkfoodsrus.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.junkfoodsrus.Model.Food;
import com.example.junkfoodsrus.R;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private List<Food> foodList;
    private onFoodClickListener listenerInterface;

    public FoodAdapter(onFoodClickListener listenerInterface, List<Food> food) {
        this.listenerInterface = listenerInterface;
        this.foodList = food;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_layout, parent, false);
        return new FoodViewHolder(v, listenerInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food i = foodList.get(position);
        holder.name.setText(i.getName());
        holder.imageView.setImageResource(i.getImageID());
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name;
        public ImageView imageView;
        public onFoodClickListener listenerInterface;

        public FoodViewHolder(View v, onFoodClickListener listenerInterface) {
            super(v);
            this.name = (TextView) v.findViewById(R.id.id_name);
            this.imageView = (ImageView) v.findViewById(R.id.id_imageView);
            this.listenerInterface = listenerInterface;
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listenerInterface.onFoodClick(getAdapterPosition());
        }
    }

    // listens for a click on the food_layout
    public interface onFoodClickListener {
        void onFoodClick(int position);
    }
}
