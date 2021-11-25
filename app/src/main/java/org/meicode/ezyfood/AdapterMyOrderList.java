package org.meicode.ezyfood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterMyOrderList extends BaseAdapter {

    Context c;
    String[] drinksHolder;
    String[] priceHolder;
    int[] imagesHolder;
    LayoutInflater inflater;


    public AdapterMyOrderList(Context ct, String[] drinks, String[] price, int[] images) {
        c = ct;
        drinksHolder = drinks;
        priceHolder = price;
        imagesHolder = images;
        inflater = (LayoutInflater.from(ct));
    }

    @Override
    public int getCount() {
        return drinksHolder.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.list_view_my_order, null);
        ImageView image = (ImageView) view.findViewById(R.id.imageListView);
        TextView drinks = (TextView) view.findViewById(R.id.nameListView);
        TextView price = (TextView) view.findViewById(R.id.priceListView);
        image.setImageResource(imagesHolder[i]);
        drinks.setText(drinksHolder[i]);
        price.setText(priceHolder[i]);
        return view;
    }
}
