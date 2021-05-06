package com.example.electronicshop;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyProductAdapter extends RecyclerView.Adapter<MyProductViewHolder> implements Filterable {
    ArrayList<Model> data;
    ArrayList<Model> backup;
    Context context;
   public static int value;
    public MyProductAdapter(ArrayList<Model> data,Context context)
    {
        this.data = data;
        this.context = context;
        backup = new ArrayList<>(data);
       // backup = data;
    }
    @NonNull
    @Override
    public MyProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater Inflater = LayoutInflater.from(parent.getContext());
        View view = Inflater.inflate(R.layout.electronic_gadget,parent,false);
        MyProductViewHolder myProductViewHolder = new MyProductViewHolder(view);
        return  myProductViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyProductViewHolder holder, int position) {
         final Model temp = data.get(position);
          value = temp.getPrice();
        holder.productImage.setImageResource(data.get(position).getProductimage());
        holder.productText.setText(data.get(position).getProductheader());
        holder.price.setText(Integer.toString(data.get(position).getPrice()));
        holder.pdescription.setText(data.get(position).getProductdescription());
        holder.productImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DescriptionActivity.class);
                intent.putExtra("dimage",temp.getProductimage());
                intent.putExtra("dheader",temp.getProductheader());
                intent.putExtra("dprice",temp.getPrice());
                intent.putExtra("dwarrenty",temp.getWarrenty());
                intent.putExtra("dreplacement",temp.getReplacementpolicy());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }
    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence keyword) {
            ArrayList<Model> filterdata  = new ArrayList<>();
            if(keyword.toString().isEmpty()) {
                filterdata.addAll(backup);
            }else
            {
                for(Model obj:backup)
                {
                   if(obj.getProductheader().toString().toLowerCase().contains(keyword.toString().toLowerCase()))
                       filterdata.add(obj);
                }
            }
            FilterResults results = new FilterResults();
            results.values = filterdata;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
           data.clear();
           data.addAll((ArrayList<Model>)results.values);
           notifyDataSetChanged();
        }
    };
}
