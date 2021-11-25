package org.meicode.ezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Drinks extends AppCompatActivity {

    RecyclerView recyclerView;

    private Button button;

    String[] drinks = {"Mineral Water", "Coca Cola", "Orange Smoothies", "Strawberry Milkshake"};
    String[] price = {"Rp. 5.000", "Rp. 10.000", "Rp. 25.000", "Rp. 20.000"};
    int[] images = {R.drawable.mineralwater, R.drawable.cocacola, R.drawable.orangesmoothies, R.drawable.strawberrymilkshake};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        recyclerView = findViewById(R.id.drinksRecyclerView);

        AdapterDrinksRecycler adapter = new AdapterDrinksRecycler(this, drinks, price,  images);
        recyclerView.setAdapter(adapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        button = (Button) findViewById(R.id.buttonToMyOrder);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOrder();
            }
        });

    }

    public void openOrder(){
        Intent intent = new Intent(this, MyOrder.class);
        startActivity(intent);
    }
}