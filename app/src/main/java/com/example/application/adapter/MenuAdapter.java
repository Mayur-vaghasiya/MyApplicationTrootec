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
        return new MenuAdapter.CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.storelist_view, parent, false), viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.actvStoreName.setText("Store :".concat(menuCategoryArrayList.get(position).getCategoria().getNombremenu()).trim());
    }

    @Override
    public int getItemCount() {
        return menuCategoryArrayList.size() ;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        private AppCompatTextView actvStoreName;
        public CustomViewHolder(View view, int type) {
            super(view);
            actvStoreName = (AppCompatTextView) view.findViewById(R.id.actv_name);
        }
    }
}
