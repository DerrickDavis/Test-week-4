package com.example.samsungct.model.datasource.remote.retrofit;

import android.util.Log;
import android.widget.Toast;
import com.example.samsungct.model.picsource.SamsungApp;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.samsungct.model.datasource.remote.retrofit.Constants.GALL_URL;

public class Retrofit_funcs {

    public Retrofit getRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl(GALL_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public ranRetroSrvc getService(){

        return  getRetrofitInstance().create(ranRetroSrvc.class);
    }

    public static void getPic(final PicHldIntf picHldIntf){

       Retrofit_funcs retrofitHelper = new Retrofit_funcs();
        retrofitHelper.getService().getRandpic().enqueue(new Callback<List<SamsungApp>>() {
            @Override
            public void onResponse(Call<List<SamsungApp>> call, Response<List<SamsungApp>> response) {

                String firstInList = response.body().get(0).getThumbnailUrl();
                List<SamsungApp> list = response.body();

                Log.d("TAG_RETROFIT",firstInList);

                picHldIntf.getList(list);

            }

            @Override
            public void onFailure(Call<List<SamsungApp>> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }
}





//(new Callback<SamsungApp>() {
//
//            @Override
//            public void onResponse(Call<SamsungApp> call, Response<SamsungApp> response) {
//
//                String firstInList = response.body().getThumbnailUrl();
//                Log.d("TAG_RETROFIT",firstInList);
//
//            }
//
//            @Override
//            public void onFailure(Call<SamsungApp> call, Throwable t) {
//                Log.e("Error", t.getMessage());
//                //Toast.makeText( "Error Fetching Data!", Toast.LENGTH_SHORT).show();
//            }
//        }