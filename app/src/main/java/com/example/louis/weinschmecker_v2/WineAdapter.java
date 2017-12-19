package com.example.louis.weinschmecker_v2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.louis.weinschmecker_v2.database.entity.WineEntity;
import com.squareup.picasso.Picasso;


import java.util.List;

/**
 * Created by Betti on 19.12.17.
 */

public class WineAdapter extends RecyclerView.Adapter<WineAdapter.ProductViewHolder>{

    private final List<WineEntity> list;

    public WineAdapter(List<WineEntity> list) { this.list = list; }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_list_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView name;

        public ProductViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.wine_image);
            name = itemView.findViewById(R.id.wine_name);
        }

        public void bind(WineEntity wineEntity) {
            String price = itemView.getContext().getString(R.string.preis_format, String.valueOf(wineEntity.getPreis()));
            name.setText(wineEntity.getWeinName() + "-" + price);
            Picasso.with(itemView.getContext()).load(wineEntity.getBild()).into(image);
        }
    }

}
