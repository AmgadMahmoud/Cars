package com.amgad.cars.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Amgad Mahmoud on 07,June,2020
 */
public class Car {


    @SerializedName("data")
    private List<CarDetails> data;

    @SerializedName("status")
    private int status;

    public List<CarDetails> getData() {
        return data;
    }

    public void setData(List<CarDetails> data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
