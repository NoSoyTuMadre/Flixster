package com.codepath.tonifields.flixster.models;

import android.util.Log;

import androidx.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    String backdropPath;
    String posterPath;
    String title;
    String overview;
    String basePath;
    float rating;
    String posterSize = "w342";
    String landscapePosterSize = "w1280";

    public Movie(JSONObject jsonObject) throws JSONException {
        this.backdropPath = jsonObject.getString("backdrop_path");
        this.posterPath = jsonObject.getString("poster_path");
        this.title = jsonObject.getString("title");
        this.overview = jsonObject.getString("overview");
        this.rating = Float.parseFloat(jsonObject.getString("vote_average"));
    }

    public Movie(@NonNull JSONObject jsonObject, @NonNull Object object2) throws JSONException {
        this.backdropPath = jsonObject.getString("backdrop_path");
        this.posterPath = jsonObject.getString("poster_path");
        this.title = jsonObject.getString("title");
        this.overview = jsonObject.getString("overview");
        String str = object2.toString();
        this.basePath = str.substring(0, 4) + 's' + str.substring(4);
        this.rating = Float.parseFloat(jsonObject.getString("vote_average"));
    }

    public static List<Movie> fromJsonArray(@NonNull JSONArray movieJsonArray, @NonNull JSONObject posterJsonObject) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < movieJsonArray.length(); i++) {
            movies.add(new Movie(movieJsonArray.getJSONObject(i), posterJsonObject.get("base_url")));
        }
        return movies;
    }

    public String getPosterPath() {
        return basePath + posterSize + posterPath;
    }

    public String getBackdropPath() { return basePath + landscapePosterSize + backdropPath; }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getBasePath() {
        return basePath;
    }

    public String getPosterSize() {
        return posterSize;
    }

    public String getLandscapePosterSize() {
        return landscapePosterSize;
    }

    public float getRating() { return rating; }
}
