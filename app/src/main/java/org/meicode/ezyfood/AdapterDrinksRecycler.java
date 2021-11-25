package org.meicode.ezyfood;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterDrinksRecycler extends RecyclerView.Adapter<AdapterDrinksRecycler.mViewHolder> {

    Context context;
    String[] drinksHolder;
    String[] priceHolder;
    int[] imagesHolder;

    public AdapterDrinksRecycler(Context c, String[] drinks, String[] price, int[] images){
        context = c;
        drinksHolder = drinks;
        imagesHolder = images;
        priceHolder = price;
    }

    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.grid_recyclerview, parent, false);
        return new mViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {
        holder.textDrinks.setText(drinksHolder[position]);
        holder.textPrice.setText(priceHolder[position]);
        holder.imagesDrinks.setImageResource(imagesHolder[position]);

        holder.drinksLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Order.class);
                intent.putExtra("imagesHolder", imagesHolder[position]);
                intent.putExtra("drinksHolder", drinksHolder[position]);
                intent.putExtra("priceHolder", priceHolder[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return drinksHolder.length;
    }

    public class mViewHolder extends RecyclerView.ViewHolder{

        TextView textDrinks;
        TextView textPrice;
        ImageView imagesDrinks;
        LinearLayout drinksLayout;

        public mViewHolder(@NonNull View itemView) {
            super(itemView);
            textDrinks = itemView.findViewById(R.id.textRecyclerViewName);
            textPrice = itemView.findViewById(R.id.textRecyclerViewPrice);
            imagesDrinks = itemView.findViewById(R.id.imageRecyclerView);
            drinksLayout = itemView.findViewById(R.id.drinksLayout);
        }
    }
}
