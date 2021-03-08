package com.example.application.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application.R;
import com.example.application.model.CategoryList;
import com.example.application.model.StoreList;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.CustomViewHolder> {
    private Context context;
    private ArrayList<CategoryList.Datum> menuCategoryArrayList = null;
    public MenuAdapter(WeakReference<Context> context, ArrayList<CategoryList.Datum> menuCategoryArrayList) {
        this.context = context.get();
        this.menuCategoryArrayList = menuCategoryArrayList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //return new MenuAdapter.CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.productby_category, parent, false), viewType);
        View view = LayoutInflater.from(context).inflate(R.layout.view_item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        //holder.actvCategory.setVisibility(hasCategory(position) ? View.VISIBLE : View.GONE);
        //holder.actvCategory.setText(menuCategoryArrayList.get(position).getCategoria().getNombremenu().trim());
        holder.actvStoreName.setText("Item :".concat(menuCategoryArrayList.get(position).getNombre()).trim());

    }

    @Override
    public int getItemCount() {
        return menuCategoryArrayList.size() ;
    }

    private boolean hasCategory(int position) {
        if (position == 0)
            return true;
        return !menuCategoryArrayList.get(position).getCategoria().getNombremenu().equals(menuCategoryArrayList.get(position - 1).getCategoria().getNombremenu().toString());
    }
    public class CustomViewHolder extends RecyclerView.ViewHolder {
        private AppCompatTextView actvStoreName,actvCategory;
        public CustomViewHolder(View view, int type) {
            super(view);
           // actvStoreName = (AppCompatTextView) view.findViewById(R.id.actv_name);
            //actvCategory = (AppCompatTextView) view.findViewById(R.id.actv_category);
        }

        public CustomViewHolder(View view) {
            super(view);
            actvStoreName = (AppCompatTextView) view.findViewById(R.id.tv_item);
        }
    }
}
