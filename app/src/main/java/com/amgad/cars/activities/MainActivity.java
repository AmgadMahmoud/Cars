package com.amgad.cars.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.amgad.cars.R;
import com.amgad.cars.adapters.CarsAdapter;
import com.amgad.cars.api.ApiClient;
import com.amgad.cars.api.ApiInterface;
import com.amgad.cars.models.Car;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    RecyclerView carsRecyclerView;
    CarsAdapter adapter;

    ArrayList<Car> cars_array;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cars_array = new ArrayList<>();


        initRecyclerView();
    }

    public void getCars() {
        cars_array.clear();

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ArrayList<Car>> call = apiService.getCars(1);
        call.enqueue(new Callback<ArrayList<Car>>() {
            @Override
            public void onResponse(Call<ArrayList<Car>> call, retrofit2.Response<ArrayList<Car>> response) {
                Log.e("getCars", response.code() + "  " + response.raw().request());

                if (response.isSuccessful()) {
                    Log.e("getCars", "response successful ");

                    cars_array = response.body();
                    adapter.setCarsList(cars_array);
                    carsRecyclerView.setAdapter(adapter);
                    carsRecyclerView.getAdapter().notifyDataSetChanged();
                } else {
                    Log.e("getCars", "response not successful ");
                }

            }

            @Override
            public void onFailure(Call<ArrayList<Car>> call, Throwable t) {
                Log.e("getCars", "on failure");
            }

        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        getCars();
    }

    private void initRecyclerView() {
        carsRecyclerView = findViewById(R.id.cars_recyclerview);
        adapter = new CarsAdapter(this, cars_array);
        carsRecyclerView.setAdapter(adapter);
        carsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
