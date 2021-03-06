package com.example.smartkart.Adapters;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartkart.DataUtils;
import com.example.smartkart.Models.Category;
import com.example.smartkart.R;
import com.example.smartkart.ShoppingActivity;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    Context context;
    ArrayList<Category> categoryList;

    public CategoryAdapter(Context context){
        super();
        this.context = context;
        this.categoryList = DataUtils.getCategoryList();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_category_card, parent,
                false);
        return new CategoryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category category = DataUtils.getCategoryList().get(position);
        holder.categoryNameTextView.setText(category.getCategoryName());
        holder.categoryDescTextView.setText(category.getMessage());
        holder.categoryImageView.setImageDrawable(context.getResources().getDrawable(category.getResId()));
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ShoppingActivity.class);
            intent.putExtra("shop_category", DataUtils.getCategoryList().get(holder.getAdapterPosition()).getCategoryName());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return DataUtils.getCategoryList().size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView categoryNameTextView, categoryDescTextView;
        ImageView categoryImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryNameTextView = itemView.findViewById(R.id.sample_category_name);
            categoryDescTextView = itemView.findViewById(R.id.sample_category_description);
            categoryImageView = itemView.findViewById(R.id.sample_category_resource);
        }
    }
}
