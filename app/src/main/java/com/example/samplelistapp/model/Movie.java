package com.example.samplelistapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Movie implements Serializable {
    @SerializedName("id")
    private Double id;

    @SerializedName("vote_average")
    private Double stars;

    @SerializedName("title")
    private String title;

    @SerializedName("poster_path")
    private String image;

    @SerializedName("overview")
    private String overview;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("adult")
    private boolean isAdult;

    public Movie() {
    }

    public Movie(Double id, Double stars, String title, String image, String overview, boolean isAdult, String releaseDate) {
        this.id = id;
        this.stars = stars;
        this.title = title;
        this.image = image;
        this.overview = overview;
        this.isAdult = isAdult;
        this.releaseDate = releaseDate;
    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public Double getStars() {
        return stars;
    }

    public void setStars(Double stars) {
        this.stars = stars;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public boolean isAdult() {
        return isAdult;
    }

    public void setAdult(boolean adult) {
        isAdult = adult;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
