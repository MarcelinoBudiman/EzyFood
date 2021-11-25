package org.meicode.ezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class OrderComplete extends AppCompatActivity {

    ListView listView;


    String[] drinks = {"Mineral Water", "Coca Cola", "Orange Smoothies", "Strawberry Milkshake"};
    String[] price = {"2 x Rp. 5.000", "2 x Rp. 10.000", "4 x Rp. 25.000", "1 x Rp. 20.000"};
    int[] images = {R.drawable.mineralwater, R.drawable.cocacola, R.drawable.orangesmoothies, R.drawable.strawberrymilkshake};

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete);

        listView = findViewById(R.id.listViewOrderComplete);

        AdapterOrderComplete adapter = new AdapterOrderComplete(getApplicationContext(), drinks, price, images);
        listView.setAdapter(adapter);

        button = (Button) findViewById(R.id.buttonToHome);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHome();
            }
        });

    }

    public void openHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}