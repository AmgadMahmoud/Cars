package com.amgad.cars.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Amgad Mahmoud on 07,June,2020
 */
public class CarDetails {

    @SerializedName("id")
    private int id;

    @SerializedName("brand")
    private String brand;

    @SerializedName("constructionYear")
    private String constructionYear;

    @SerializedName("isUsed")
    private Boolean isUsed;

    @SerializedName("imageUrl")
    private String imageUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getConstructionYear() {
        return constructionYear;
    }

    public void setConstructionYear(String constructionYear) {
        this.constructionYear = constructionYear;
    }

    public Boolean getUsed() {
        return isUsed;
    }

    public void setUsed(Boolean used) {
        isUsed = used;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
