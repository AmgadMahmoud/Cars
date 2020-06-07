package com.amgad.cars.api;


import com.amgad.cars.models.Car;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {


    @GET("cars/{page}")
    Call<ArrayList<Car>> getCars(@Path("page") int page);

}
