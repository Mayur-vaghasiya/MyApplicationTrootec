package com.example.application.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
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
import com.example.application.adapter.MenuAdapter;
import com.example.application.adapter.StoreListAdapter;
import com.example.application.api.ApiRequestData;
import com.example.application.custom_views.CustomProgressDialog;
import com.example.application.model.CategoryList;
import com.example.application.model.StoreList;
import com.example.application.retro.RetrofitInstance;
import com.example.application.util.NetworkStatus;
import com.example.application.util.RecyclerSectionItemDecoration;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {
    private Activity activity = null;
    private static final String TAG = "MenuListActivity";
    private Toolbar toolbar;
    private LinearLayoutManager layoutManager = null;
    private RecyclerView rvMenuItemList = null;
    private ArrayList<CategoryList.Datum> categoryList = null;
    private MenuAdapter menuListAdapter;
    private ApiRequestData service = null;
    private CustomProgressDialog progress = null;
    private String apiKey = "bd_suvlasmarbellapos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            apiKey = bundle.getString("APIKEY");
        }

        activity = MainActivity2.this;
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        rvMenuItemList = (RecyclerView) findViewById(R.id.recyclerview_menuitem);
        setSupportActionBar(toolbar);
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_back);
        upArrow.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(activity, MainActivity.class));
                overridePendingTransition(R.anim.left_in, R.anim.right_out);
                finish();
            }
        });
        AppCompatTextView txtHeaderNname = (AppCompatTextView) toolbar.findViewById(R.id.actv_header_name);
        txtHeaderNname.setText(getString(R.string.menu_list));

        layoutManager = new LinearLayoutManager(activity, layoutManager.VERTICAL, false);
        rvMenuItemList.setLayoutManager(layoutManager);


    }

    private RecyclerSectionItemDecoration.SectionCallback getSectionCallback(final ArrayList<CategoryList.Datum> categoryList) {
        return new RecyclerSectionItemDecoration.SectionCallback() {
            @Override
            public boolean isSection(int position) {
                return position == 0
                        || categoryList.get(position).getCategoria().getNombremenu()
                        .charAt(0) != categoryList.get(position - 1).getCategoria().getNombremenu().charAt(0);
            }

            @Override
            public CharSequence getSectionHeader(int position) {
                return categoryList.get(position).getCategoria().getNombremenu();
            }
        };
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(activity, MainActivity.class));
        overridePendingTransition(R.anim.left_in, R.anim.right_out);
        finish();

    }

    private void getStoreList() {
        service = RetrofitInstance.getRetrofitInstance().create(ApiRequestData.class);

        Call<CategoryList> call = service.getAllMenubyCahegorywise(apiKey);
        progress = new CustomProgressDialog(activity).
                setStyle(CustomProgressDialog.Style.SPIN_INDETERMINATE)
                .setDimAmount(0.5f)
                .show();
        call.enqueue(new Callback<CategoryList>() {
            @Override
            public void onResponse(Call<CategoryList> call, Response<CategoryList> response) {

                Log.e(TAG, response.toString());
                categoryList = (ArrayList<CategoryList.Datum>) response.body().getData();

                RecyclerSectionItemDecoration sectionItemDecoration =
                        new RecyclerSectionItemDecoration(getResources().getDimensionPixelSize(R.dimen.height_width_40),
                                true,
                                getSectionCallback(categoryList));
                rvMenuItemList.addItemDecoration(sectionItemDecoration);
                setRecyclerViewData();
                progress.dismiss();
                Toast.makeText(activity, "Sync Data with Server", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<CategoryList> call, Throwable t) {
                progress.dismiss();

                Toast.makeText(MainActivity2.this, "Sync Fail!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (NetworkStatus.getConnectivityStatusString(activity)) {
            getStoreList();
        } else {
            Toast.makeText(activity, "No Internet Connection!", Toast.LENGTH_LONG).show();
        }
    }

    private void setRecyclerViewData() {
        menuListAdapter = new MenuAdapter(new WeakReference<Context>(activity), categoryList);
        rvMenuItemList.setAdapter(menuListAdapter);
    }
}