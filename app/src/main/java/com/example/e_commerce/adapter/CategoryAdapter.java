package com.example.e_commerce.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_commerce.MainActivity;
import com.example.e_commerce.R;
import com.example.e_commerce.model.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    // we have two main parametres
    Context context;
    List<Category> categories;

    public CategoryAdapter(Context context, List<Category> categories) {
        this.context = context;
        this.categories = categories;
    }

    @NonNull
    @Override
    //for each elemeent we use some design
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View categoryItems = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false);
        return new CategoryViewHolder(categoryItems); //each elelement will work with Category view Holder class
    }

    //onBindVIewHolder creates an object based on class CategoryViewHolder
    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
    holder.categoryTitle.setText(categories.get(position).getTitle());

    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        //when pressing on categories we run showcoursesbyCategory method while taking ID as parameter
        // 1-games 2- 3- 4-
        public void onClick(View view) {
            MainActivity.showCoursesByCategory(categories.get(position).getId());
        }
    });

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static final class CategoryViewHolder extends RecyclerView.ViewHolder{
        TextView categoryTitle;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryTitle = itemView.findViewById(R.id.categoryTitle);

        }
    }
}
