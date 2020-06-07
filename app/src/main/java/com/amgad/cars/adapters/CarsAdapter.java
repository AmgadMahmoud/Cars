package com.amgad.cars.adapters;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amgad.cars.R;
import com.amgad.cars.models.Car;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Amgad Mahmoud on 07,June,2020
 */
public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.CarsViewHolder> {

    private Context mContext;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private ArrayList<Car> carsList = new ArrayList<>();

    public CarsAdapter(Context context, ArrayList<Car> cars_array) {
        this.carsList = cars_array;
        this.mContext = context;
    }

    @NonNull
    @Override
    public CarsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.car_item, viewGroup, false);
        CarsViewHolder holder = new CarsViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CarsViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return carsList.size();
    }

    public void setCarsList(ArrayList<Car> cars_array) {
        this.carsList = cars_array;
    }

    public class CarsViewHolder extends RecyclerView.ViewHolder {

        TextView carBrand, carStatus, carConstructionYear;
        ImageView carImage;


        public CarsViewHolder(@NonNull View itemView) {
            super(itemView);
            carBrand = itemView.findViewById(R.id.car_brand);
            carStatus = itemView.findViewById(R.id.car_status);
            carConstructionYear = itemView.findViewById(R.id.car_construction_year);
            carImage = itemView.findViewById(R.id.car_image);

        }
    }
}
