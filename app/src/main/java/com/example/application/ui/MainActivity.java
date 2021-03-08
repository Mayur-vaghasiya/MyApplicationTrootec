package com.example.application.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.application.R;
import com.example.application.adapter.StoreListAdapter;
import com.example.application.api.ApiRequestData;
import com.example.application.custom_views.CustomProgressDialog;
import com.example.application.model.StoreList;
import com.example.application.retro.RetrofitInstance;
import com.example.application.util.NetworkStatus;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private Activity activity = null;
    private static final String TAG = "StoreListActivity";
    private Toolbar toolbar;
    private LinearLayoutManager layoutManager = null;
    private RecyclerView rvItemList = null;
    private ArrayList<StoreList.Franquicia> storeList = null;
    private StoreListAdapter storeListAdapter;
    private ApiRequestData service = null;
    private CustomProgressDialog progress = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = MainActivity.this;
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        rvItemList = (RecyclerView) findViewById(R.id.recyclerview_item);

        setSupportActionBar(toolbar);
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_back);
        upArrow.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        AppCompatTextView txtHeaderNname = (AppCompatTextView) toolbar.findViewById(R.id.actv_header_name);
        txtHeaderNname.setText(getString(R.string.store_list));

        layoutManager = new LinearLayoutManager(activity, layoutManager.VERTICAL, false);
        rvItemList.setLayoutManager(layoutManager);


        rvItemList.addOnItemTouchListener(new StoreListAdapter.RecyclerTouchListener(getApplicationContext(), rvItemList, new StoreListAdapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putString("APIKEY", storeList.get(position).getAPIKEY());
                Intent intent = new Intent(activity, MainActivity2.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
            @Override
            public void onLongClick(View view, int position) {

            }

        }));
    }

    private void gteStoreList() {
        service = RetrofitInstance.getRetrofitInstance().create(ApiRequestData.class);
        Call<StoreList> call = service.getAllStore();
        progress = new CustomProgressDialog(activity).
                setStyle(CustomProgressDialog.Style.SPIN_INDETERMINATE)
                .setDimAmount(0.5f)
                .show();
        call.enqueue(new Callback<StoreList>() {
            @Override
            public void onResponse(Call<StoreList> call, Response<StoreList> response) {

                Log.e(TAG, response.toString());
                //storeList.clear();
                storeList = (ArrayList<StoreList.Franquicia>) response.body().getFranquicias();
                setRecyclerViewData();
                progress.dismiss();
                Toast.makeText(activity, "Sync Data with Server", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<StoreList> call, Throwable t) {
                progress.dismiss();

                Toast.makeText(MainActivity.this, "Sync Fail!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (NetworkStatus.getConnectivityStatusString(activity)) {
            gteStoreList();
        } else {
            Toast.makeText(activity, "No Internet Connection!", Toast.LENGTH_LONG).show();
        }
    }

    private void setRecyclerViewData() {
        storeListAdapter = new StoreListAdapter(new WeakReference<Context>(activity), storeList);
        rvItemList.setAdapter(storeListAdapter);
    }
}