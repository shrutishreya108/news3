package com.example.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CategoryRVAdapter extends RecyclerView.Adapter<CategoryRVAdapter.ViewHolder> {
    private ArrayList<CategoryRVModel> categoryRVModels;
    private Context context;
    private CategoryClickInterface categoryClickInterface;
    public CategoryRVAdapter(ArrayList<CategoryRVModel> categoryRVModels, Context context) {
        this.categoryRVModels = categoryRVModels;
        this.context = context;
    }

    public CategoryRVAdapter(ArrayList<CategoryRVModel> categoryRVModels, Context context, CategoryClickInterface categoryClickInterface) {
        this.categoryRVModels = categoryRVModels;
        this.context = context;
        this.categoryClickInterface = categoryClickInterface;
    }

    @Override
    public CategoryRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_rv_item,parent,false);
        return new CategoryRVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryRVAdapter.ViewHolder holder, int position) {
        CategoryRVModel categoryRVModel = categoryRVModels.get(position);
        holder.textView.setText(categoryRVModel.getCategory());
        Picasso.get().load(categoryRVModel.getImageUrl()).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryClickInterface.OnCategoryClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryRVModels.size();
    }
    public interface CategoryClickInterface{
        void OnCategoryClick(int position);
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.idTVCategory);
            imageView = itemView.findViewById(R.id.idIVCategory);
        }
    }
}
