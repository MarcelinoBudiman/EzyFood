package org.meicode.ezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton imgButton;
    private Button button;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imgButton = (ImageButton) findViewById(R.id.buttonToDrinks);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDrinks();
            }
        });

        button = (Button) findViewById(R.id.buttonToMyOrder);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOrder();
            }
        });
    }

    public void openDrinks(){
        Intent intent = new Intent(this, Drinks.class);
        startActivity(intent);
    }

    public void openOrder(){
        Intent intent = new Intent(this, MyOrder.class);
        startActivity(intent);
    }
}