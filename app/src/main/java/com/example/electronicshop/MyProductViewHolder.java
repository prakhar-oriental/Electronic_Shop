package com.example.electronicshop;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ComponentActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MyProductViewHolder extends RecyclerView.ViewHolder {
    ImageView productImage;
    TextView productText;
    TextView price;
    TextView pdescription;
    public MyProductViewHolder(@NonNull View itemView) {
        super(itemView);
     productImage = itemView.findViewById(R.id.productimageView);
     productText = itemView.findViewById(R.id.header);
     price = itemView.findViewById(R.id.price);
     pdescription = itemView.findViewById(R.id.description);

    }
}
