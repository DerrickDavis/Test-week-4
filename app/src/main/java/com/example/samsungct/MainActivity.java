package com.example.samsungct;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.samsungct.model.datasource.remote.retrofit.PicHldIntf;
import com.example.samsungct.model.datasource.remote.retrofit.Retrofit_funcs;
import com.example.samsungct.model.datasource.remote.retrofit.ranRetroSrvc;
import com.example.samsungct.model.picsource.SamsungApp;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.samsungct.model.datasource.remote.retrofit.Retrofit_funcs.getPic;

public class MainActivity extends AppCompatActivity implements PicHldIntf {

    RecyclerView picassoPicList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        picassoPicList = findViewById(R.id.rv_picholder);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPic(this);

    }


    @Override
    public void getList(List<SamsungApp> smgApp) {
        String firstInList = smgApp.get(0).getThumbnailUrl();

        Log.d("TAG_List",firstInList);

        GridLayoutManager llppView = new GridLayoutManager(this,2);

        rvAdaptr  displayPp = new rvAdaptr(this,smgApp);

        picassoPicList.setLayoutManager(llppView);

        picassoPicList.setAdapter(displayPp);
    }
}


