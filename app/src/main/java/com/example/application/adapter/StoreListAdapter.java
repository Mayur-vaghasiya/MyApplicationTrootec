package com.example.application.adapter;

import android.content.Context;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application.R;
import com.example.application.model.StoreList;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;

public class StoreListAdapter extends RecyclerView.Adapter<StoreListAdapter.CustomViewHolder> {
    private Context context;
    private ArrayList<StoreList.Franquicia> storeFranquiciaArrayList = null;
    private static RecyclerViewClickListener itemListener;


    public StoreListAdapter(WeakReference<Context> context, ArrayList<StoreList.Franquicia> storeFranquiciaArrayList) {
        this.context = context.get();
        this.storeFranquiciaArrayList = storeFranquiciaArrayList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.storelist_view, parent, false), viewType);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.actvStoreName.setText(storeFranquiciaArrayList.get(position).getNegocio().trim());
    }

    @Override
    public int getItemCount() {
        return storeFranquiciaArrayList.size();
    }


    @Override
    public int getItemViewType(int position) {
        return storeFranquiciaArrayList.size();
    }

    public interface ClickListener {
        void onClick(View view, int position);
        void onLongClick(View view, int position);
    }

    public interface RecyclerViewClickListener {
        public void recyclerViewListClicked(View v, int position);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private AppCompatTextView actvStoreName;

        public CustomViewHolder(View view, int type) {
            super(view);
            actvStoreName = (AppCompatTextView) view.findViewById(R.id.actv_name);
        }

        @Override
        public void onClick(View v) {
            //itemListener.recyclerViewListClicked(v, this.getLayoutPosition());
        }
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private StoreListAdapter.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final StoreListAdapter.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildLayoutPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildLayoutPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
}
