package org.meicode.ezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Order extends AppCompatActivity {


    ImageView selectedImage;
    TextView name, price;

    String drinksName, drinksPrice;
    int drinksImage;

    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        selectedImage = findViewById(R.id.imageOrder);
        name = findViewById(R.id.textOrderName);
        price = findViewById(R.id.textOrderPrice);

        getData();
        setData();

        button1 = (Button) findViewById(R.id.buttonToMyOrder);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOrder();
            }
        });

        button2 = (Button) findViewById(R.id.buttonToDrinks);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDrinks();
            }
        });

    }

    public void openOrder(){
        Intent intent = new Intent(this, MyOrder.class);
        startActivity(intent);
    }

    public void openDrinks(){
        Intent intent = new Intent(this, Drinks.class);
        startActivity(intent);
    }

    private void getData(){
        if(getIntent().hasExtra("imagesHolder") && getIntent().hasExtra("drinksHolder") && getIntent().hasExtra("priceHolder")){

            drinksName = getIntent().getStringExtra("drinksHolder");
            drinksPrice = getIntent().getStringExtra("priceHolder");
            drinksImage = getIntent().getIntExtra("imagesHolder", 1);

        } else {
            Toast.makeText(this, "EMPTY", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        name.setText(drinksName);
        price.setText(drinksPrice);
        selectedImage.setImageResource(drinksImage);
    }
}