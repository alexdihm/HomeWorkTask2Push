package com.example.junkfoodsrus.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.junkfoodsrus.Model.Food;
import com.example.junkfoodsrus.Model.FoodDB;
import com.example.junkfoodsrus.R;

public class AddToOrderActivity extends AppCompatActivity {

    private static int currentQuantity;
    private static final int ERROR = -1;
    private static final String ADD = "Add";
    private static final String RETURN = "Return";

    ImageView image;
    TextView name;
    TextView description;
    TextView price;
    EditText quantity;
    Button addOrReturnButton;
    Food food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        findViews();

        //by default quantity should always be set to one upon entering this activity
        currentQuantity = 1;

        quantity.setEnabled(false);
        addOrReturnButton.setText(ADD);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id",ERROR);

        if(id > 0) {
            food = FoodDB.food.get(id);
            image.setImageResource(food.getImageID());
            name.setText(food.getName());
            description.setText(food.getDescription());
            price.setText("$" + String.valueOf(food.getPrice()));
            quantity.setText(String.valueOf(currentQuantity));
        } else {
            intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }

    }

    public void onClickPlus(View v) {
        currentQuantity++;
        quantity.setText(String.valueOf(currentQuantity));
        addOrReturnButton.setText(ADD);
    }

    public void onClickMinus(View v){
        // prevents quantity from going below 0
        if(currentQuantity > 0) {
            currentQuantity--;
            quantity.setText(String.valueOf(currentQuantity));
        }
        if(currentQuantity == 0){
            addOrReturnButton.setText(RETURN);
        }
    }

    public void onClickAdd(View v){
        double amount = currentQuantity * food.getPrice();
        FoodDB.totalPrice += amount;
        if(FoodDB.orderCart.containsKey(food)) {
            int howManyInCart = FoodDB.orderCart.get(food);
            howManyInCart += currentQuantity;
            FoodDB.orderCart.put(food, howManyInCart);
        } else {
            FoodDB.orderCart.put(food, currentQuantity);
        }
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    private void findViews(){
        image = findViewById(R.id.id_ordering_image);
        name = findViewById(R.id.id_name);
        description = findViewById(R.id.id_description);
        price = findViewById(R.id.order_price);
        quantity = findViewById(R.id.order_quantity);
        addOrReturnButton = findViewById(R.id.add_or_return);
    }

}
