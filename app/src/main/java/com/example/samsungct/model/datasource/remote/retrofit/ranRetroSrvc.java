package com.example.samsungct.model.datasource.remote.retrofit;

import com.example.samsungct.model.picsource.SamsungApp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import static com.example.samsungct.model.datasource.remote.retrofit.Constants.PHOTOS;



public interface ranRetroSrvc {

    @GET(PHOTOS)

    Call<List<SamsungApp>> getRandpic();


}
